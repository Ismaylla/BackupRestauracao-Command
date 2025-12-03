package invoker;

import commands.Command;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command lastCommand;

    public RemoteControl(int slots) {
        onCommands = new Command[slots];
        offCommands = new Command[slots];

        // Inicializa com comandos nulos para evitar NullPointerException
        Command noCommand = new NoCommand();
        for (int i = 0; i < slots; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

        lastCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot < 0 || slot >= onCommands.length) {
            throw new IllegalArgumentException("Slot inválido");
        }
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void pressOnButton(int slot) {
        if (slot < 0 || slot >= onCommands.length) return;
        onCommands[slot].execute();
        lastCommand = onCommands[slot];
    }

    public void pressOffButton(int slot) {
        if (slot < 0 || slot >= offCommands.length) return;
        offCommands[slot].execute();
        lastCommand = offCommands[slot];
    }

    public void pressUndoButton() {
        lastCommand.execute(); // simula "desfazer" simples
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----- Remote Control -----\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot ").append(i).append("] ON: ")
              .append(onCommands[i].getClass().getSimpleName())
              .append(" | OFF: ")
              .append(offCommands[i].getClass().getSimpleName())
              .append("\n");
        }
        return sb.toString();
    }

    // Classe interna para inicialização de slots vazios
    private static class NoCommand implements Command {
        @Override
        public void execute() {
            System.out.println("Nenhum comando atribuído a este slot.");
        }
    }
}
