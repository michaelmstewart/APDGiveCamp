package org.apd.model.parsers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ResourceReader {
    public static ArrayList<String> Read(String resourceString) throws Exception {
        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(LocaleParser.class.getResourceAsStream(resourceString)));

        try {
            String line = bufferedReader.readLine();

            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }

        return lines;
    }
}
