package com.ddylan.hydrogen.api;

import java.io.*;
import java.util.HashMap;

public class SettingsManager {

    private HashMap<String, String> settings = new HashMap<>();
    public HashMap<String, String> getSettings() {
        return this.settings;
    }
    public boolean init(boolean dev) {
        File file = new File((dev ? "../" : "") + "settings.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();

                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("redis-host::localhost");
                writer.newLine();
                writer.write("ban-message::&cYour account has been suspended from the MineHQ Network. %newline%%newline%Appeal at https://minehq.com/support");
                writer.newLine();
                writer.write("blacklist-message::&cYour account has been blacklisted from the MineHQ Network. %newline%%newline%This type of punishment cannot be appealed.");
                writer.newLine();
                writer.write("log-ips::false");
                writer.close();

                System.out.println("Edit the config.txt file with details to your redis & database server then restart the web api.");

                return false;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineSplit = line.split("::");
                this.settings.put(lineSplit[0], lineSplit[1].replaceAll("&", "§").replaceAll("%newline%", "\n"));
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
