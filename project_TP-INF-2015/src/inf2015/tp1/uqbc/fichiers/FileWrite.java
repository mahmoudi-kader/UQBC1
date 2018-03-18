package inf2015.tp1.uqbc.fichiers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


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
		jsonArray.add("exemple 1");
		jsonArray.add("");
		jsonArray.add("exemple 2");
		jsonArray.add("");
		
		jsonObject.put("",jsonArray);
		
		File file= new File("C:\\Users\\DALIL\\Desktop\\exemple.txt");
 
		FileWriter writer= new FileWriter(file);
		System.out.println(jsonArray);
		writer.write(jsonObject.toJSONString());
		writer.close();
                }
}
