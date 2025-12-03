package commands;

import receivers.CeilingFan;

public class CeilingFanOffCommand implements Command {
    private CeilingFan fan;

    public CeilingFanOffCommand(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }
}
