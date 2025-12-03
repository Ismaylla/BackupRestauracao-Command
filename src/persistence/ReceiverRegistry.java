package persistence;

import receivers.*;
import java.util.HashMap;
import java.util.Map;

public class ReceiverRegistry {
    private static Map<String, Object> receivers = new HashMap<>();

    public static void register(String name, Object receiver) {
        receivers.put(name, receiver);
    }

    public static Object getReceiver(String name) {
        return receivers.get(name);
    }
}
