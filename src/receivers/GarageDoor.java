package receivers;

public class GarageDoor {
    private String location;

    public GarageDoor(String location) {
        this.location = location;
    }

    public void up() {
        System.out.println(location + " garage door is OPEN");
    }

    public void down() {
        System.out.println(location + " garage door is CLOSED");
    }

    public void stop() {
        System.out.println(location + " garage door STOPPED");
    }
}
