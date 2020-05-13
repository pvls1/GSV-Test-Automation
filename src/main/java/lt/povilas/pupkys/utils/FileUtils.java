package lt.povilas.pupkys.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class FileUtils {
    private static String path = ".\\APIKey.txt";

    public static void writeToFile(String text) {
        try {
            Files.writeString(Paths.get(path), text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile() {
        String content = null;
        try {
            content = Files.readString(Paths.get(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
