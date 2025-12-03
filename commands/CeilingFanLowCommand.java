package commands;

import receivers.CeilingFan;

public class CeilingFanLowCommand implements Command {
    private CeilingFan fan;

    public CeilingFanLowCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.low();
    }
}
