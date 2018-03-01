package inf2015.tp1.uqbc;

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

        String json = new FileReader().StringFromFile("C:\\Users\\DALIL\\Desktop\\ListeEtudiantsCoursBIO1012-Gr10-H18.json");
        System.out.println(json);
    }
    
}
