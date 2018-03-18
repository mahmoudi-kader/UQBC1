package inf2015.tp1.uqbc;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author DALIL
 */
public class FileWrite {
    
    public static void main(String[] args) throws IOException {
        
        JSONObject obj = new JSONObject();
        FileWriter file = new FileWriter("./");
        
    try {
            file.write(obj.toJSONString());
            System.out.println("JSON Object: " + obj);
}   catch (IOException e) {
        e.printStackTrace();
}   finally {
        file.flush();
        file.close();
        }
    
    
    }
    
    
}
