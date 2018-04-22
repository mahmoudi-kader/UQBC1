package inf2015.tp1.uqbc.fichiers;

import inf2015.tp1.uqbc.Cours;
import inf2015.tp1.uqbc.Etudiant;
import inf2015.tp1.uqbc.Evaluation;
import inf2015.tp1.uqbc.ResultatEvaluation;
import inf2015.tp1.uqbc.Utilitaires;
import inf2015.tp1.uqbc.validation.ValidationDonnees;
import inf2015.tp1.uqbc.validation.ValidationException;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Cette class va ramasser tous les fichiers du répertoire, et les mettre dans
 * une liste. Si un répertoire est rencontré, on exécute la même logique dans le
 * répertoire.
 *
 * @author benoit
 */
public class TraitementFichiers {


    private static final Hashtable<String, Etudiant> tableEtudiants = new Hashtable<>();

    /**
     * ramasser tous les fichiers du répertoire, et les mettre dans une liste.
     * Si un répertoire est rencontré, on exécute la même méthode dans le
     * répertoire Si la variable repertoire est nulle, on utilise le répertoire
     * courant. Si la variable liste est nulle, on lance une exception.
     *
     * @param repertoire
     * @param liste
     */
    public static void ramasser(String repertoire, List<FichierJSON> liste) {
        if (repertoire == null || repertoire.length() == 0) {
            repertoire = Utilitaires.REPERTOIRE_PAR_DEFAUT;
        }

        if (liste == null) {
            throw new RuntimeException("La variable 'liste' doit être initialisée.");
        }

        File repertoireTravail = new File(repertoire);

        if (!repertoireTravail.exists() || !repertoireTravail.isDirectory() || !repertoireTravail.canRead()) {
            throw new RuntimeException("Le répertoire : '" + repertoire + "' n'est pas un répertoire ou n'est pas accessible.");
        }

        FilenameFilter myFilenameFilter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name){
                boolean accept = false;
                if(name != null && name.toLowerCase().endsWith("json") ){
                    accept = true;
                }
                return accept;
            }
        };
        
        File[] listeFichiers = repertoireTravail.listFiles(myFilenameFilter);

        for (File fichier : listeFichiers) {

            try {

                if (fichier.isDirectory()) {
                    ramasser(fichier.getAbsolutePath(), liste);
                } else {

                    if (!fichier.canRead()) {
                        throw new ValidationException("Le fichier '" + fichier.getAbsolutePath() + "' n'est pas accessible.");
                    }

                    FichierJSON fichierJSON = null;
                    if (fichier.getName().startsWith(Utilitaires.PREFIXE_FICHIER_LISTE_ETUDIANTS)) {

                        fichierJSON = new FichierListeEtudiant();

                    } else if (fichier.getName().startsWith(Utilitaires.PREFIXE_FICHIER_NOTES)) {

                        fichierJSON = new FichierNotesCours();

                    } else {
                        throw new ValidationException("Le nom du fichier '" + fichier.getName() + "' n'est pas un format reconnu.");
                    }
                    fichierJSON.initialiserFichier(fichier);
                    fichierJSON.setJson(FileReader.StringFromFile(fichier.getAbsolutePath()));
                    liste.add(fichierJSON);
                }

            } catch (ValidationException ve) {
                System.out.println(ve.getMessage() + " dans le fichier : " + fichier.getAbsolutePath());
            }
        }

    }

    public static List<Cours> chargerDonnees(List<FichierJSON> liste) {

        Map<Cours, Cours> map = new Hashtable();

        for (FichierJSON fichier : liste) {

            try {

                String szJson = fichier.getJson();
                JSONObject jsonObj = new JSONObject(szJson);

                if (fichier instanceof FichierNotesCours) {

                    String commentaire = jsonObj.getString("commentaire");
                    String nomEvaluation = jsonObj.getString("nom_evaluation");
                    String ponderation = jsonObj.getString("ponderation");
                    String typeEvaluation = jsonObj.getString("type");
                    JSONArray donnees = jsonObj.getJSONArray("donnees");

                    if (donnees == null || donnees.length() == 0) {
                        throw new RuntimeException("Le fichier " + fichier.getFichier().getAbsolutePath() + " est vide.");
                    }
                    ValidationDonnees.validerNomEvaluation(nomEvaluation, typeEvaluation);
                    ValidationDonnees.validerPonderation(ponderation);

                    //On s'assure que le cours n'est pas déjà dans notre liste de cours
                    Cours cours = fichier.getCours();
                    if (map.containsKey(cours)) {
                        cours = map.get(cours);
                    } else {
                        map.put(cours, cours);
                    }

                    Evaluation eval = ((FichierNotesCours) fichier).getEvaluation();
                    eval.setCommentaire(commentaire);
                    eval.setNomEvaluation(nomEvaluation);
                    eval.setType(jsonObj.getString("type"));
                    eval.setPonderation(ponderation);

                    eval.setListeResultatEvaluation(traiterDonneesResultats(donnees));
                    cours.getListeEvaluation().add(eval);

                    //FichierListeEtudiant
                } else {

                    FichierListeEtudiant listeEtudiant = (FichierListeEtudiant) fichier;

                    //On s'assure que le cours n'est pas déjà dans notre liste de cours
                    Cours cours = fichier.getCours();
                    if (map.containsKey(cours)) {
                        cours = map.get(cours);
                    } else {
                        map.put(cours, cours);
                    }

                    String commentaire = jsonObj.getString("commentaire");
                    JSONArray donnees = jsonObj.getJSONArray("donnees");

                    if (donnees == null || donnees.length() == 0) {
                        throw new RuntimeException("Le fichier " + fichier.getFichier().getAbsolutePath() + " est vide.");
                    }

                    cours.getListeEtudiant().addAll(traiterDonneesEtudiants(donnees));

                }

            } catch (ValidationException ve) {
                System.out.println(ve.getMessage() + " dans le fichier :" + fichier.getFichier().getAbsolutePath());
            }

        }

        List<Cours> listeCours = new ArrayList<>(map.values());

        return listeCours;
    }

    protected static List<Etudiant> traiterDonneesEtudiants(JSONArray donnees) {

        List<Etudiant> liste = new ArrayList<>();

        int size = donnees.length();

        for (int i = 0; i < size; i++) {

            JSONObject obj = donnees.getJSONObject(i);
            String codePermanent = obj.getString("code_permanent");
            String nom = obj.getString("nom");
            String prenom = obj.getString("prenom");

            ValidationDonnees.validerCodePermanent(codePermanent);

            Etudiant etudiant = tableEtudiants.get(codePermanent);
            if (etudiant == null) {
                etudiant = new Etudiant(codePermanent, nom, prenom);
                tableEtudiants.put(codePermanent, etudiant);
            } else {
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
            }

            liste.add(etudiant);
        }

        return liste;
    }

    protected static List<ResultatEvaluation> traiterDonneesResultats(JSONArray donnees) {

        List<ResultatEvaluation> liste = new ArrayList<>();

        int size = donnees.length();

        for (int i = 0; i < size; i++) {

            JSONObject obj = donnees.getJSONObject(i);
            String codePermanent = obj.getString("code_permanent");
            Double note = obj.getDouble("note");

            ValidationDonnees.validerCodePermanent(codePermanent);

            ResultatEvaluation resultatEvaluation = new ResultatEvaluation();

            Etudiant etudiant = tableEtudiants.get(codePermanent);
            if (etudiant == null) {
                etudiant = new Etudiant(codePermanent, null, null);
                tableEtudiants.put(codePermanent, etudiant);
            }
            resultatEvaluation.setEtudiant(etudiant);
            resultatEvaluation.setNote(note);

            liste.add(resultatEvaluation);

        }

        return liste;
    }

}
