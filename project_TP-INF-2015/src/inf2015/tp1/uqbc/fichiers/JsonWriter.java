
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Evaluation;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
/**
 *
 * @author DALIL
 */

public class JsonWriter {  

  public static void main(String[] args) {  

    Evaluation test = new Evaluation("blabla", "2", "Examen", "Intrea", "40%");  

    ObjectMapper mapper = new ObjectMapper();

    try {  

        // Writing to a file   
        mapper.writeValue(new File("C:\\Users\\DALIL\\Desktop\\Work\\TEST\\exemple.json"), test );

    } catch (IOException e) {  
        e.printStackTrace();  
    }  

  }  
}
