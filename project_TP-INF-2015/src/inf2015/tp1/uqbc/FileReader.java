package inf2015.tp1.uqbc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 *
 * @author DALIL
 */
public class FileReader {
    
    public String StringFromFile(String PathToFile){
        String fileContent = "";
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(PathToFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
    
}
