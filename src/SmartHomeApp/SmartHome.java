package SmartHomeApp;

public class SmartHome {
    private final Switch s;
    private final Switchable switchable;

    public SmartHome(Switch s, Switchable switchable) {
        this.s = s;
        this.switchable = switchable;
    }

    public void runOnce() {
        if (s.isOn()) {
            switchable.turnOn();
        } else {
            switchable.turnOff();
        }
    }
}
