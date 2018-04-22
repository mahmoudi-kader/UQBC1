package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Utilitaires;
import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author benoit
 */
public class TraitementFichierTest {

    @Test
    public void testRamasser() {
        
        List<FichierJSON> liste = new LinkedList();
        String repertoire = Utilitaires.REPERTOIRE_PAR_DEFAUT+Utilitaires.SEP_FICHIER+"fichiers";
        
        TraitementFichiers.ramasser(repertoire, liste);
        
        Assert.assertEquals(11, liste.size());
    }
    
        @Test
    public void testRamasserException() {
        
        List<FichierJSON> liste = new LinkedList();
        String repertoire = Utilitaires.REPERTOIRE_PAR_DEFAUT+Utilitaires.SEP_FICHIER+"FGHFHFGH";
        
        try{
            TraitementFichiers.ramasser(repertoire, liste);
            Assert.fail("On ne devrait pas se rendre ici, car la méthode doit lancer une exception.");
        }catch(Throwable t){
            Assert.assertTrue(t.getMessage().contains("n'est pas accessible"));
        }
    }

}
