package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import java.io.File;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author benoit
 */
public class FichierListeEtudiantTest {

    @Test
    public void testTesterNomFichier() {

        FichierListeEtudiant fichierListeEtudiant = new FichierListeEtudiant();

        File file = new File("ListeEtudiantsCoursBIO1012-Gr10-H18.json");
        boolean resultat = fichierListeEtudiant.initialiserFichier(file);

        Assert.assertTrue("Le nom du fichier est invalide.", resultat);

    }

    @Test
    public void testTesterNomFichierAttributsCours() {

        FichierListeEtudiant fichierListeEtudiant = new FichierListeEtudiant();

        File file = new File("ListeEtudiantsCoursBIO1012-Gr10-H18.json");
        boolean resultat = fichierListeEtudiant.initialiserFichier(file);

        Assert.assertTrue("Le nom du fichier est invalide.", resultat);

        Cours coursAttendu = new Cours();
        coursAttendu.setGroupe("Gr10");
        coursAttendu.setNumeroCours("1012");
        coursAttendu.setSession("H18");
        coursAttendu.setTitre("BIO1012");

        Assert.assertEquals("Le cours n'est pas correctement initialisé", coursAttendu, fichierListeEtudiant.getCours());

    }

    @Test
    public void testTesterNomFichierNegatif() {

        FichierListeEtudiant fichierListeEtudiant = new FichierListeEtudiant();

        File file = new File("ListeEtudiantsCoursBI0O1012-Gr10-H18.json");
        boolean resultat = fichierListeEtudiant.initialiserFichier(file);

        Assert.assertFalse("Le nom du fichier est valide mais devrait être invalide.", resultat);

    }

}
