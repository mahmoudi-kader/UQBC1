package inf2015.tp1.uqbc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;


/**
 *
 * @author DALIL
 */
public class FileWrite {
    
    public static void main(String[] args) throws IOException {
        
        JSONObject obj = new JSONObject();
        FileWriter file = new FileWriter("./");
        
        file.write(obj.toString());
        System.out.println("JSON Object: " + obj);
        file.flush();
        file.close();
    }
}
