package receivers;

public class Hottub {
    private boolean on;

    public void on() {
        on = true;
        System.out.println("Hottub is ON");
    }

    public void off() {
        on = false;
        System.out.println("Hottub is OFF");
    }

    public void circulate() {
        if (on) {
            System.out.println("Hottub water is circulating");
        } else {
            System.out.println("Hottub is OFF, cannot circulate");
        }
    }

    public void jetsOn() {
        if (on) {
            System.out.println("Hottub jets are ON");
        } else {
            System.out.println("Hottub is OFF, cannot turn jets on");
        }
    }

    public void jetsOff() {
        if (on) {
            System.out.println("Hottub jets are OFF");
        } else {
            System.out.println("Hottub is OFF");
        }
    }

    public void setTemperature(int temp) {
        System.out.println("Hottub temperature set to " + temp + "°C");
    }
}
