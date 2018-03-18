/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
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
        
        Cours coursAttendu = new Cours();
        coursAttendu.setGroupe("Gr10");
        coursAttendu.setNumeroCours("1012");
        coursAttendu.setSession("H18");
        coursAttendu.setTitre("BIO1012");
        
        Assert.assertEquals("Le cours n'est pas correctement initialisé", coursAttendu, fichierListeEtudiant.getCours());
        
        
    }
    
    @Test
    public void testTesterNomFichier2(){
        
        FichierNotesCours fichierListeEtudiant = new FichierNotesCours();
        
        boolean resultat = fichierListeEtudiant.testerNomFichier("evaluation1234BIO10112-Gr99-E18.json");
        
        Assert.assertTrue("Le nom du fichier est invalide.", resultat);        
        
        Cours coursAttendu = new Cours();
        coursAttendu.setGroupe("Gr99");
        coursAttendu.setNumeroCours("10112");
        coursAttendu.setSession("E18");
        coursAttendu.setTitre("BIO10112");
        
        Assert.assertEquals("Le cours n'est pas correctement initialisé", coursAttendu, fichierListeEtudiant.getCours());
        
        
    }    
    
    
    @Test
    public void testTesterNomFichierNegatif(){
        
        FichierNotesCours fichierListeEtudiant = new FichierNotesCours();
        
        boolean resultat = fichierListeEtudiant.testerNomFichier("evaluationBIO1012-Gr10-H18.json");
        
        Assert.assertFalse("Le nom du fichier est valide mais devrait être invalide.", resultat);        
        
    }    
    
}
