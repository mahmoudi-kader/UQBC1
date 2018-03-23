package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import java.io.File;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author benoit
 */
public class FichierNotesCoursTest {

    @Test
    public void testTesterNomFichier() {

        FichierNotesCours fichierListeEtudiant = new FichierNotesCours();

        File file = new File("evaluation1BIO1012-Gr10-H18.json");
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
    public void testTesterNomFichier2() {

        FichierNotesCours fichierListeEtudiant = new FichierNotesCours();

        File file = new File("evaluation1234BIO10112-Gr99-E18.json");
        boolean resultat = fichierListeEtudiant.initialiserFichier(file);

        Assert.assertTrue("Le nom du fichier est invalide.", resultat);

        Cours coursAttendu = new Cours();
        coursAttendu.setGroupe("Gr99");
        coursAttendu.setNumeroCours("10112");
        coursAttendu.setSession("E18");
        coursAttendu.setTitre("BIO10112");

        Assert.assertEquals("Le cours n'est pas correctement initialisé", coursAttendu, fichierListeEtudiant.getCours());

    }

    @Test
    public void testTesterNomFichierNegatif() {

        FichierNotesCours fichierListeEtudiant = new FichierNotesCours();

        File file = new File("ListeEtudiantsCoursBI0O1012-Gr10-H18.json");
        boolean resultat = fichierListeEtudiant.initialiserFichier(file);

        Assert.assertFalse("Le nom du fichier est valide mais devrait être invalide.", resultat);

    }

}
