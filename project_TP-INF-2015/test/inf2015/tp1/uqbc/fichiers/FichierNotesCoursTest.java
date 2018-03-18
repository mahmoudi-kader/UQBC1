/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc.fichiers;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author benoit
 */
public class FichierNotesCoursTest {
    
    @Test
    public void testTesterNomFichier(){
        
        FichierNotesCours fichierListeEtudiant = new FichierNotesCours();
        
        boolean resultat = fichierListeEtudiant.testerNomFichier("evaluation1BIO1012-Gr10-H18.json");
        
        Assert.assertTrue("Le nom du fichier est invalide.", resultat);
        
    }
    
    @Test
    public void testTesterNomFichier2(){
        
        FichierNotesCours fichierListeEtudiant = new FichierNotesCours();
        
        boolean resultat = fichierListeEtudiant.testerNomFichier("evaluation1234BIO1012-Gr10-H18.json");
        
        Assert.assertTrue("Le nom du fichier est invalide.", resultat);        
        
    }    
    
    
    @Test
    public void testTesterNomFichierNegatif(){
        
        FichierNotesCours fichierListeEtudiant = new FichierNotesCours();
        
        boolean resultat = fichierListeEtudiant.testerNomFichier("evaluationBIO1012-Gr10-H18.json");
        
        Assert.assertFalse("Le nom du fichier est valide mais devrait être invalide.", resultat);        
        
    }    
    
}
