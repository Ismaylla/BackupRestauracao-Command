package persistence;

import commands.Command;
import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private static final String FILE_PATH = "command_history.json";
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Salva lista de comandos como JSON simples
    public static void saveHistory(List<CommandRecord> records) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(records, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega lista de comandos do JSON
    public static List<CommandRecord> loadHistory() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            CommandRecord[] records = gson.fromJson(reader, CommandRecord[].class);
            List<CommandRecord> list = new ArrayList<>();
            if (records != null) {
                for (CommandRecord record : records) {
                    list.add(record);
                }
            }
            return list;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
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
