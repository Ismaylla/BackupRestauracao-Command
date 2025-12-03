package commands;

import receivers.CeilingFan;

public class CeilingFanHighCommand implements Command {
    private CeilingFan fan;

    public CeilingFanHighCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.high();
    }
}
