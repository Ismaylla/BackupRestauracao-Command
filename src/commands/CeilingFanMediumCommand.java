package commands;

import receivers.CeilingFan;

public class CeilingFanMediumCommand implements Command {
    private CeilingFan fan;

    public CeilingFanMediumCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.medium();
    }
}
