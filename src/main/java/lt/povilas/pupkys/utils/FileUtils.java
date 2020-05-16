package lt.povilas.pupkys.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class FileUtils {
    private static String path = "APIKey.txt";
    private static String url = "test-output/index.html";

    /**
     * Writes string to file
     */
    public static void writeToFile(String text) {
        try {
            Files.writeString(Paths.get(path), text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads string from file
     */
    public static String readFromFile() {
        String content = null;
        try {
            content = Files.readString(Paths.get(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    /**
     * Writes JSON to file
     */
    public static void writeJsonToFile(JSONObject jsonObject) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads JSON from file
     */
    public static JSONObject readJsonFromFile() {
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader(path)) {
            return (JSONObject) parser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Opens test report
     */
    public static void openReport() {
        File htmlFile = new File(url);
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
