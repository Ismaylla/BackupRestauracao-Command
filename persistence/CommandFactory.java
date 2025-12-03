package persistence;

import commands.*;
import receivers.*;

public class CommandFactory {

    public static Command createCommand(String commandName, String receiverName, Object... params) {
        Object receiver = ReceiverRegistry.getReceiver(receiverName);
        if (receiver == null) {
            throw new IllegalArgumentException("Receiver não encontrado: " + receiverName);
        }

        switch (commandName) {
            case "LightOnCommand":
                return new LightOnCommand((Light) receiver);
            case "LightOffCommand":
                return new LightOffCommand((Light) receiver);
            case "TVOnCommand":
                return new TVOnCommand((TV) receiver);
            case "TVOffCommand":
                return new TVOffCommand((TV) receiver);
            case "TVSetChannelCommand":
                return new TVSetChannelCommand((TV) receiver, (int) params[0]);
            case "SoundOnCommand":
                return new SoundOnCommand((Sound) receiver);
            case "SoundOffCommand":
                return new SoundOffCommand((Sound) receiver);
            case "SoundSetVolumeCommand":
                return new SoundSetVolumeCommand((Sound) receiver, (int) params[0]);
            case "CeilingFanHighCommand":
                return new CeilingFanHighCommand((CeilingFan) receiver);
            case "CeilingFanMediumCommand":
                return new CeilingFanMediumCommand((CeilingFan) receiver);
            case "CeilingFanLowCommand":
                return new CeilingFanLowCommand((CeilingFan) receiver);
            case "CeilingFanOffCommand":
                return new CeilingFanOffCommand((CeilingFan) receiver);
            case "GarageDoorOpenCommand":
                return new GarageDoorOpenCommand((GarageDoor) receiver);
            case "GarageDoorCloseCommand":
                return new GarageDoorCloseCommand((GarageDoor) receiver);
            case "HottubOnCommand":
                return new HottubOnCommand((Hottub) receiver);
            case "HottubOffCommand":
                return new HottubOffCommand((Hottub) receiver);
            case "SecurityArmCommand":
                return new SecurityArmCommand((SecurityControl) receiver);
            case "SecurityDisarmCommand":
                return new SecurityDisarmCommand((SecurityControl) receiver);
            default:
                throw new IllegalArgumentException("Comando desconhecido: " + commandName);
        }
    }
}
