package inf2015.tp1.uqbc.fichiers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 *
 * @author DALIL
 */
public class FileReader {

    public static String StringFromFile(String PathToFile) {
        String fileContent = "";
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(PathToFile)));
        } catch (IOException e) {
            throw new RuntimeException("Une exception non prévue est survenue: " + e.getMessage(), e);
        }
        return fileContent;
    }

}
