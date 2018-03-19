package inf2015.tp1.uqbc.fichiers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author DALIL
 */
public class FileWrite {

public static void main(String[] args) throws IOException{
		JSONObject jsonObject= new JSONObject();
		jsonObject.put("", "");
		jsonObject.put("", new Integer(100));
		
		JSONArray jsonArray= new JSONArray();
		jsonArray.put("exemple 1");
		jsonArray.put("");
		jsonArray.put("exemple 2");
		jsonArray.put("");
		
		jsonObject.put("",jsonArray);
		
		File file= new File("C:\\Users\\DALIL\\Desktop\\exemple.txt");
 
		FileWriter writer= new FileWriter(file);
		System.out.println(jsonArray);
		writer.write(jsonObject.toString());
		writer.close();
                }
}
