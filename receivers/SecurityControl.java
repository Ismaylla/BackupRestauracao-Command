package receivers;

public class SecurityControl {
    private boolean armed;

    public void arm() {
        armed = true;
        System.out.println("Security system ARMED");
    }

    public void disarm() {
        armed = false;
        System.out.println("Security system DISARMED");
    }

    public boolean isArmed() {
        return armed;
    }
}
