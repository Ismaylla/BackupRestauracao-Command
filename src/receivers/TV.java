package receivers;

public class TV {
    private String location;
    private int channel;

    public TV(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " TV is ON");
    }

    public void off() {
        System.out.println(location + " TV is OFF");
    }

    public void setChannel(int channel) {
        this.channel = channel;
        System.out.println(location + " TV channel set to " + channel);
    }
}
