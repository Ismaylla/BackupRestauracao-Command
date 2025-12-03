package persistence;

import commands.Command;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private static final String FILE_PATH = "command_history.txt";

    // Salva histórico em arquivo de texto simples
    public static void saveHistory(List<CommandRecord> records) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (CommandRecord record : records) {
                writer.write(record.commandName + ";" + record.receiverName);
                if (record.params != null && record.params.length > 0) {
                    for (Object param : record.params) {
                        writer.write(";" + param.toString());
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega histórico do arquivo
    public static List<CommandRecord> loadHistory() {
        List<CommandRecord> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String commandName = parts[0];
                String receiverName = parts[1];
                Object[] params = new Object[parts.length - 2];
                for (int i = 2; i < parts.length; i++) {
                    params[i - 2] = Integer.parseInt(parts[i]); // assume parâmetros inteiros
                }
                list.add(new CommandRecord(commandName, receiverName, params));
            }
        } catch (FileNotFoundException e) {
            // Arquivo ainda não existe, retorna lista vazia
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Classe auxiliar para armazenar informações de cada comando
    public static class CommandRecord {
        public String commandName;
        public String receiverName;
        public Object[] params;

        public CommandRecord(String commandName, String receiverName, Object... params) {
            this.commandName = commandName;
            this.receiverName = receiverName;
            this.params = params;
        }
    }
}
