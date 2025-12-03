package commands;

import receivers.Sound;

public class SoundSetVolumeCommand implements Command {
    private Sound sound;
    private int volume;

    public SoundSetVolumeCommand(Sound sound, int volume) {
        this.sound = sound;
        this.volume = volume;
    }

    @Override
    public void execute() {
        sound.setVolume(volume);
    }
}
