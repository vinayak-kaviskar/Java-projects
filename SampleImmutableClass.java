import java.util.HashMap;
import java.util.Map;

public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final Map<String, String> address; // Mutable field (Needs deep copy)

    // Constructor (All fields initialized)
    public ImmutablePerson(String name, int age, Map<String, String> address) {
        this.name = name;
        this.age = age;
        
        // Deep copy to prevent external modification
        this.address = new HashMap<>(address);
    }

    // Getters (No setters)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Return deep copy of mutable object
    public Map<String, String> getAddress() {
        return new HashMap<>(address);
    }
}
