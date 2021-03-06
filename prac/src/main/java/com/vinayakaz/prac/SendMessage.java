package com.vinayakaz.prac;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import com.google.gson.Gson;
//Include the following imports to use Service Bus APIs
import com.google.gson.reflect.TypeToken;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.QueueClient;
import com.microsoft.azure.servicebus.ReceiveMode;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
public class SendMessage {
    static final Gson GSON = new Gson();

    public void run() throws Exception {
        // Create a QueueClient instance and then asynchronously send messages.
        // Close the sender once the send operation is complete.
        QueueClient sendClient = new QueueClient(new ConnectionStringBuilder("Endpoint=sb://ota-services.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=p5PKfReCZN3Q6XvlydFl17bsUOQdFuvZ+kCfvdamwkE=", "sb-queue-ota-status-cpg"), ReceiveMode.PEEKLOCK);
        this.sendMessagesAsync(sendClient).thenRunAsync(() -> sendClient.closeAsync());

        sendClient.close();
    }

        CompletableFuture<Void> sendMessagesAsync(QueueClient sendClient) {
            List<HashMap<String, String>> data =
                    GSON.fromJson(
                            "[" +
                                    "{'name' = 'Einstein', 'firstName' = 'Albert'}," +
                                    "{'name' = 'Heisenberg', 'firstName' = 'Werner'}," +
                                    "{'name' = 'Curie', 'firstName' = 'Marie'}," +
                                    "{'name' = 'Hawking', 'firstName' = 'Steven'}," +
                                    "{'name' = 'Newton', 'firstName' = 'Isaac'}," +
                                    "{'name' = 'Bohr', 'firstName' = 'Niels'}," +
                                    "{'name' = 'Faraday', 'firstName' = 'Michael'}," +
                                    "{'name' = 'Galilei', 'firstName' = 'Galileo'}," +
                                    "{'name' = 'Kepler', 'firstName' = 'Johannes'}," +
                                    "{'name' = 'Kopernikus', 'firstName' = 'Nikolaus'}" +
                                    "]",
                            new TypeToken<List<HashMap<String, String>>>() {}.getType());

            List<CompletableFuture> tasks = new ArrayList();
            for (int i = 0; i < data.size(); i++) {
                final String messageId = Integer.toString(i);
                Message message = new Message(GSON.toJson(data.get(i), Map.class).getBytes(UTF_8));
                message.setContentType("application/json");
                message.setLabel("Scientist");
                message.setMessageId(messageId);
                message.setTimeToLive(Duration.ofMinutes(2));
                System.out.printf("\nMessage sending: Id = %s", message.getMessageId());
                tasks.add(
                        sendClient.sendAsync(message).thenRunAsync(() -> {
                            System.out.printf("\n\tMessage acknowledged: Id = %s", message.getMessageId());
                        }));
            }
            return CompletableFuture.allOf(tasks.toArray(new CompletableFuture<?>[tasks.size()]));
        }
}
