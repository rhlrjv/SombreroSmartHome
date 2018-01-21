package SmartHomeApp;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SmartHomeTest {
    @Test
    public void whenSwitchIsOn_ThenSwitchableShouldBeTurnedOn() {
        Switch s = new AlwaysOnSwitch();
        SwitchableSpy switchable = new SwitchableSpy();

        new SmartHome(s, switchable).runOnce();

        assertTrue(switchable.turnOnWasCalled());
        assertFalse(switchable.turnOffWasCalled());
    }

    @Test
    public void whenSwitchIsOff_ThenSwitchableShouldBeTurnedOff() {
        Switch s = new AlwaysOffSwitch();
        SwitchableSpy switchable = new SwitchableSpy();

        new SmartHome(s, switchable).runOnce();

        assertTrue(switchable.turnOffWasCalled());
        assertFalse(switchable.turnOnWasCalled());
    }
}

class AlwaysOnSwitch implements Switch {
    @Override
    public boolean isOn() {
        return true;
    }
}

class AlwaysOffSwitch implements Switch {
    @Override
    public boolean isOn() {
        return false;
    }
}

class SwitchableSpy implements Switchable {
    private boolean turnOnWasCalled = false;
    private boolean turnOffWasCalled = false;

    @Override
    public void turnOn() {
        turnOnWasCalled = true;
    }

    @Override
    public void turnOff() {
        turnOffWasCalled = true;
    }

    public boolean turnOnWasCalled() {
        return turnOnWasCalled;
    }

    public boolean turnOffWasCalled() {
        return turnOffWasCalled;
    }
}