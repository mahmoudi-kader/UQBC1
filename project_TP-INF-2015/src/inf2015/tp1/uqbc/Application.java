package inf2015.tp1.uqbc;

import inf2015.tp1.uqbc.fichiers.FileReader;

/**
 *
 * @author benoit
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //String json = new FileReader().StringFromFile("C:\\Users\\DALIL\\Desktop\\ListeEtudiantsCoursBIO1012-Gr10-H18.json");
        //System.out.println(json);
        
        ValidationDonnees repertoire = new ValidationDonnees();
        repertoire.setNomRepertoire("C:\\Users\\nawal\\Documents\\Cerificat UQAM1\\2018-hiver\\inf2015\\json\\");
        repertoire.validerRepertoire();
    }
    
}
