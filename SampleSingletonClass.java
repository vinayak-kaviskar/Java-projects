import java.io.Serializable;

public class SecureSingleton implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    // Private static instance (Lazy initialization)
    private static volatile SecureSingleton instance;

    // Private constructor to prevent instantiation
    private SecureSingleton() {
        if (instance != null) { // Prevent Reflection
            throw new RuntimeException("Use getInstance() method to create the Singleton!");
        }
    }

    // Double-Checked Locking for thread safety
    public static SecureSingleton getInstance() {
        if (instance == null) {
            synchronized (SecureSingleton.class) {
                if (instance == null) {
                    instance = new SecureSingleton();
                }
            }
        }
        return instance;
    }

    // Prevent Cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of Singleton is not allowed!");
    }

    // Prevent Deserialization from breaking Singleton
    protected Object readResolve() {
        return getInstance();
    }
}
