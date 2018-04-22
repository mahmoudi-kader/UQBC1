/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf2015.tp1.uqbc.validation;

import inf2015.tp1.uqbc.validation.ValidationDonnees;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author nawal
 */
public class ValidationDonneesTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    
    public ValidationDonneesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        String getNomRepertoire = "";

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
    
    @Test
     public void testValiderNomCours1() {
         String nomCours;
         
         nomCours = "BIOC";
         exception.expectMessage("La valeur " + nomCours + " n'est pas valide.");
         ValidationDonnees.validerNomCours(nomCours);
    }
     
     @Test
     public void testValiderNomCours2() {
         String nomCours;
         
         nomCours = "Bio";
         try{
            ValidationDonnees.validerNomCours(nomCours);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
    }
     
     @Test
     public void testValiderNomCours3() {
         String nomCours;
    
         nomCours = "BI1";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + nomCours + " n'est pas valide.");
         ValidationDonnees.validerNomCours(nomCours);
    }
     
     @Test
     public void testValiderNomCours4() {
         String nomCours;
         
         nomCours = "BIO";
         try{
             ValidationDonnees.validerNomCours(nomCours);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
    }
     
     @Test
     public void testValiderNomCours5() {
         String nomCours;
         
         nomCours = "BI-";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + nomCours + " n'est pas valide.");
         ValidationDonnees.validerNomCours(nomCours);
    }
     
     @Test
     public void testValiderNomCours6() {
         String nomCours;
         
         nomCours = null;
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + nomCours + " n'est pas valide.");
         ValidationDonnees.validerNomCours(nomCours);
    }
     
     @Test
     public void testValiderNumeroCours1() {
         String numeroCours;
         
         numeroCours = "12345";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + numeroCours + " n'est pas valide comme numero de cours.");
         ValidationDonnees.validerNumeroCours(numeroCours);
     }
     @Test
     public void testValiderNumeroCours2() {
         String numeroCours;
        
         numeroCours = "1234";
         try{
             ValidationDonnees.validerNumeroCours(numeroCours);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
         
     }
     @Test
     public void testValiderNumeroCours3() {
         String numeroCours;
                 
         numeroCours = "123b";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + numeroCours + " n'est pas valide comme numero de cours.");
         ValidationDonnees.validerNumeroCours(numeroCours);
     }
     
     @Test
     public void testValiderNumeroCours4() {
         String numeroCours;
                 
         numeroCours = null;
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + numeroCours + " n'est pas valide comme numero de cours.");
         ValidationDonnees.validerNumeroCours(numeroCours);
     }
     
      @Test
     public void testValiderGroupe1() {
         String groupe;
         groupe = "gr11";
         try{
             ValidationDonnees.validerGroupe(groupe);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderGroupe2() {
         String groupe;
         
         groupe = "gr1234";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + groupe + " n'est pas valide");
         ValidationDonnees.validerGroupe(groupe);
        
     }

     @Test
     public void testValiderGroupe3() {
         String groupe;
         
         groupe = "1234";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + groupe + " n'est pas valide");
         ValidationDonnees.validerGroupe(groupe);
     }
     
     @Test
     public void testValiderGroupe4() {
         String groupe;
                 
         groupe = "grc1";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + groupe + " n'est pas valide");
         ValidationDonnees.validerGroupe(groupe);
     }
     
     @Test
     public void testValiderGroupe5() {
         String groupe;
         
         groupe = "gc11";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + groupe + " n'est pas valide");
         ValidationDonnees.validerGroupe(groupe);
     }
     
     @Test
     public void testValiderGroupe6() {
         String groupe;
         
         groupe = null;
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + groupe + " n'est pas valide");
         ValidationDonnees.validerGroupe(groupe);
     }
     
     @Test
     public void testValiderSession1() {
         String session;
         
         session = null;
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + session + " n'est pas valide ");
         ValidationDonnees.validerSession(session);
     }
     
     @Test
     public void testValiderSession2() {
         String session;
         
         session = "1111";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + session + " n'est pas valide ");
         ValidationDonnees.validerSession(session);
     }
     
     @Test
     public void testValiderSession3() {
         String session;
         
         session = "hh1";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + session + " n'est pas valide ");
         ValidationDonnees.validerSession(session);
     }
     
     @Test
     public void testValiderSession4() {
         String session;
         
         session = "e1e";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + session + " n'est pas valide ");
         ValidationDonnees.validerSession(session);
     }
     
     @Test
     public void testValiderSession5() {
         String session;
         
         session = "c18";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + session + " n'est pas valide ");
         ValidationDonnees.validerSession(session);
     }
     
     @Test
     public void testValiderSession6() {
         String session;
         
         session = "h18";
         try{
            ValidationDonnees.validerSession(session);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderSession7() {
         String session;
         
         session = "H18";
         try{
            ValidationDonnees.validerSession(session);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderSession8() {
         String session;
         
         session = "E18";
         try{
            ValidationDonnees.validerSession(session);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderSession9() {
         String session;
         
         session = "A18";
         try{
            ValidationDonnees.validerSession(session);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderCodePermanent1() {
         String codePermanent;
         
         codePermanent = "AAA123456";
         try{
            ValidationDonnees.validerCodePermanent(codePermanent);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderCodePermanent2() {
         String codePermanent;
         
         codePermanent = "bbb123456";
         try{
            ValidationDonnees.validerCodePermanent(codePermanent);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderCodePermanent3() {
         String codePermanent;
         
         codePermanent = "bbbb12345678";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + codePermanent + " n'est pas valide ");
         ValidationDonnees.validerCodePermanent(codePermanent);
     }
     
     @Test
     public void testValiderCodePermanent4() {
         String codePermanent;
         
         codePermanent = "bbbb12345";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + codePermanent + " n'est pas valide ");
         ValidationDonnees.validerCodePermanent(codePermanent);
     }
     
     @Test
     public void testValiderCodePermanent5() {
         String codePermanent;
         
         codePermanent = "bb1234567";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + codePermanent + " n'est pas valide ");
         ValidationDonnees.validerCodePermanent(codePermanent);
     }
     
     @Test
     public void testValiderCodePermanent6() {
         String codePermanent;
         
         codePermanent = null;
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + codePermanent + " n'est pas valide ");
         ValidationDonnees.validerCodePermanent(codePermanent);
     }
     
     @Test
     public void testValiderTypeEvaluation1() {
         String typeEvaluation;
         
         typeEvaluation = "Examen";
         try{
            ValidationDonnees.validerTypeEvaluation(typeEvaluation);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderTypeEvaluation2() {
         String typeEvaluation;
         
         typeEvaluation = "RAPPORT";
         try{
            ValidationDonnees.validerTypeEvaluation(typeEvaluation);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderTypeEvaluation3() {
         String typeEvaluation;
         
         typeEvaluation = "tp";
         try{
            ValidationDonnees.validerTypeEvaluation(typeEvaluation);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderTypeEvaluation4() {
         String typeEvaluation;
         
         typeEvaluation = "tp1";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + typeEvaluation + " n'est pas valide ");
         ValidationDonnees.validerTypeEvaluation(typeEvaluation);
     }
     
     @Test
     public void testValiderTypeEvaluation5() {
         String typeEvaluation;
         
         typeEvaluation = null;
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + typeEvaluation + " n'est pas valide ");
         ValidationDonnees.validerTypeEvaluation(typeEvaluation);
     }
     
     @Test
     public void testValiderNomEvaluation1() {
         String typeEvaluation;
         String nomEvaluation;
         
         typeEvaluation = "Examen";
         nomEvaluation = "Examen final";
         try{
            ValidationDonnees.validerNomEvaluation(nomEvaluation, typeEvaluation);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderNomEvaluation2() {
         String typeEvaluation;
         String nomEvaluation;
         
         typeEvaluation = "Examen";
         nomEvaluation = "Quiz1";
         try{
            ValidationDonnees.validerNomEvaluation(nomEvaluation, typeEvaluation);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderNomEvaluation3() {
         String typeEvaluation;
         String nomEvaluation;
         
         typeEvaluation = "Rapport";
         nomEvaluation = "Rapport1";
         try{
            ValidationDonnees.validerNomEvaluation(nomEvaluation, typeEvaluation);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderNomEvaluation4() {
         String typeEvaluation;
         String nomEvaluation;
         
         typeEvaluation = "TP";
         nomEvaluation = "TP1";
         try{
            ValidationDonnees.validerNomEvaluation(nomEvaluation, typeEvaluation);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
     }
     
     @Test
     public void testValiderNomEvaluation5() {
         String typeEvaluation;
         String nomEvaluation;
         
         typeEvaluation = "TP";
         nomEvaluation = null;
         
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + nomEvaluation + " n'est pas valide ");
         ValidationDonnees.validerNomEvaluation(nomEvaluation, typeEvaluation);

     }
     
     @Test
     public void testValiderNomEvaluation6() {
         String typeEvaluation;
         String nomEvaluation;
         
         typeEvaluation = null;
         nomEvaluation = null;
         
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + nomEvaluation + " n'est pas valide ");
         ValidationDonnees.validerNomEvaluation(nomEvaluation, typeEvaluation);

     }
     
     @Test
     public void testValiderNomEvaluation7() {
         String typeEvaluation;
         String nomEvaluation;
         
         typeEvaluation = null;
         nomEvaluation = "TP1";
         
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + nomEvaluation + " n'est pas valide ");
         ValidationDonnees.validerNomEvaluation(nomEvaluation, typeEvaluation);

     }
     
     @Test
     public void testValiderNomEvaluation8() {
         String typeEvaluation;
         String nomEvaluation;
         
         typeEvaluation = "Rapport";
         nomEvaluation = "TP1";
         
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + nomEvaluation + " n'est pas valide ");
         ValidationDonnees.validerNomEvaluation(nomEvaluation, typeEvaluation);

     }
     
     @Test
     public void testValiderPonderation1() {
         String ponderation;
         
         ponderation = "50%";
         try{
            ValidationDonnees.validerPonderation(ponderation);
         }catch(Exception e){
            throw new Error("aucune exception à retourner", e);
         }
         

     }
     
     @Test
     public void testValiderPonderation2() {
         String ponderation;
         
         ponderation = "5555%";
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + ponderation + " n'est pas valide ");
         ValidationDonnees.validerPonderation(ponderation);
     }
     
     @Test
     public void testValiderPonderation3() {
         String ponderation;
         
         ponderation = "100";
         
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + ponderation + " n'est pas valide ");
         ValidationDonnees.validerPonderation(ponderation);

     }
    
     @Test
     public void testValiderPonderation4() {
         String ponderation;
         
         ponderation = null;
         
         exception.expect(RuntimeException.class);
         exception.expectMessage("La valeur " + ponderation + " n'est pas valide ");
         ValidationDonnees.validerPonderation(ponderation);

     }
}
