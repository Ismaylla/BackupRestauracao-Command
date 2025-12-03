package receivers;

public class Sound {
    private String location;
    private int volume;

    public Sound(String location) {
        this.location = location;
    }

    public void on() {
        System.out.println(location + " sound system is ON");
    }

    public void off() {
        System.out.println(location + " sound system is OFF");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(location + " sound system volume set to " + volume);
    }
}
