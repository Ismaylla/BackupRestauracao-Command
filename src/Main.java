import invoker.RemoteControl;
import commands.*;
import receivers.*;
import persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    // 1. Criação dos receivers
    Light livingRoomLight = new Light("Living Room Light");
    TV tv = new TV("TV");
    Sound sound = new Sound("Sound System");
    CeilingFan ceilingFan = new CeilingFan("Ceiling Fan");
    GarageDoor garageDoor = new GarageDoor("Garage Door");

    // Hottub e SecurityControl usam construtor padrão (sem parâmetros)
    Hottub hottub = new Hottub();
    SecurityControl security = new SecurityControl();

        // 2. Registro dos receivers para persistência
        ReceiverRegistry.register("LivingRoomLight", livingRoomLight);
        ReceiverRegistry.register("TV", tv);
        ReceiverRegistry.register("Sound", sound);
        ReceiverRegistry.register("CeilingFan", ceilingFan);
        ReceiverRegistry.register("GarageDoor", garageDoor);
        ReceiverRegistry.register("Hottub", hottub);
        ReceiverRegistry.register("Security", security);

        // 3. Criação dos comandos
        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);

        TVOnCommand tvOn = new TVOnCommand(tv);
        TVOffCommand tvOff = new TVOffCommand(tv);
        TVSetChannelCommand tvChannel = new TVSetChannelCommand(tv, 5);

        SoundOnCommand soundOn = new SoundOnCommand(sound);
        SoundOffCommand soundOff = new SoundOffCommand(sound);
        SoundSetVolumeCommand soundVolume = new SoundSetVolumeCommand(sound, 7);

        CeilingFanHighCommand fanHigh = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOffCommand fanOff = new CeilingFanOffCommand(ceilingFan);

        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageClose = new GarageDoorCloseCommand(garageDoor);

        HottubOnCommand hottubOn = new HottubOnCommand(hottub);
        HottubOffCommand hottubOff = new HottubOffCommand(hottub);

        SecurityArmCommand securityArm = new SecurityArmCommand(security);
        SecurityDisarmCommand securityDisarm = new SecurityDisarmCommand(security);

        // 4. Configuração do RemoteControl
        RemoteControl remote = new RemoteControl(7);
        remote.setCommand(0, lightOn, lightOff);
        remote.setCommand(1, tvOn, tvOff);
        remote.setCommand(2, soundOn, soundOff);
        remote.setCommand(3, fanHigh, fanOff);
        remote.setCommand(4, garageOpen, garageClose);
        remote.setCommand(5, hottubOn, hottubOff);
        remote.setCommand(6, securityArm, securityDisarm);

        System.out.println(remote);

        // 5. Simulação de uso
        remote.pressOnButton(0);
        remote.pressOffButton(0);

        remote.pressOnButton(1);
        remote.pressOffButton(1);

        remote.pressOnButton(2);
        remote.pressOffButton(2);

        remote.pressOnButton(3);
        remote.pressOffButton(3);

        remote.pressOnButton(4);
        remote.pressOffButton(4);

        remote.pressOnButton(5);
        remote.pressOffButton(5);

        remote.pressOnButton(6);
        remote.pressOffButton(6);

        // 6. Simulação de persistência
        List<HistoryManager.CommandRecord> history = new ArrayList<>();
        history.add(new HistoryManager.CommandRecord("LightOnCommand", "LivingRoomLight"));
        history.add(new HistoryManager.CommandRecord("TVSetChannelCommand", "TV", 5));
        history.add(new HistoryManager.CommandRecord("SoundSetVolumeCommand", "Sound", 7));

        HistoryManager.saveHistory(history);

        // Carregar histórico
        List<HistoryManager.CommandRecord> loadedHistory = HistoryManager.loadHistory();
        System.out.println("\nHistórico carregado:");
        for (HistoryManager.CommandRecord record : loadedHistory) {
            System.out.println(record.commandName + " -> " + record.receiverName);
            Command cmd = CommandFactory.createCommand(record.commandName, record.receiverName, record.params);
            cmd.execute();
        }
    }
}
