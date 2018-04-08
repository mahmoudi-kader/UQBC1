package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Evaluation;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONWriter;
/**
 *
 * @author DALIL
 */

public class JsonWriter {  

  public static void main(String[] args) {  

    Evaluation test = new Evaluation("blabla", "2", "Examen", "Intrea", "40%");  
    
    // Ecriture dans le fichier JSON    
    //mapper.writeValue(new File("C:\\Users\\DALIL\\Desktop\\Work\\TEST\\exemple.json"), test );
    
      String szValue = JSONWriter.valueToString(test);
      try(FileWriter writer = new FileWriter("C:\\\\Users\\\\DALIL\\\\Desktop\\\\Work\\\\TEST\\\\exemple.json")) {
          writer.write(szValue);
      } catch (IOException ex) {
          ex.printStackTrace();
      }
      
    

  }  
}
