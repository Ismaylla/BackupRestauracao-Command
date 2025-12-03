package commands;

import receivers.TV;

public class TVSetChannelCommand implements Command {
    private TV tv;
    private int channel;

    public TVSetChannelCommand(TV tv, int channel) {
        this.tv = tv;
        this.channel = channel;
    }

    @Override
    public void execute() {
        tv.setChannel(channel);
    }
}
