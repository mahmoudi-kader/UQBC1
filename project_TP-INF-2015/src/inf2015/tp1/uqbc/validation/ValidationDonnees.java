package inf2015.tp1.uqbc.validation;

/**
 *
 * Classe qui valide les donnees du cours
 */
public class ValidationDonnees {

    public static void validerNomCours(String cours) {
        boolean valide = false;

        if (cours != null && cours.length() == 3 && estAlphabetique(cours)) {
            valide = true;
        }
        if (!valide) {
            throw new ValidationException("La valeur " + cours + " n'est pas valide.");
        }
    }

    public static void validerNumeroCours(String cours) {
        boolean valide = false;

        if (cours != null && cours.length() == 4 && estNumerique(cours)) {
            valide = true;
        }
        if (!valide) {
            throw new ValidationException("La valeur " + cours + " n'est pas valide comme numero de cours.");
        }
    }

    public static void validerGroupe(String groupe) {
        boolean valide = false;

        if (groupe != null && groupe.length() == 4) {
            if (groupe.substring(0, 2).toUpperCase().equals("GR") && estNumerique(groupe.substring(2, 4))) {
                valide = true;
            }
        }
        if (!valide) {
            throw new ValidationException("La valeur " + groupe + " n'est pas valide");
        }
    }

    public static void validerSession(String cours) {
        boolean valide = false;

        if (cours != null && cours.length() == 3) {
            if (cours.substring(0, 1).toUpperCase().equals("H") || cours.substring(0, 1).toUpperCase().equals("E") || cours.substring(0, 1).toUpperCase().equals("A")) {
                valide = estNumerique(cours.substring(1, 3));
            }
        }
        if (!valide) {
            throw new ValidationException("La valeur " + cours + " n'est pas valide ");
        }
    }

    public static void validerCodePermanent(String codePermanent) {
        boolean valide = false;

        if (!(codePermanent == null) && codePermanent.length() == 9) {
            if (estAlphabetique(codePermanent.substring(0, 3)) == true) {
                if (estNumerique(codePermanent.substring(3, 9)) == true) {
                    valide = true;
                } else {
                    valide = false;
                }
            }
        }
        if (!valide) {
            throw new ValidationException("La valeur " + codePermanent + " n'est pas valide ");
        }
    }

    public static void validerTypeEvaluation(String typeEvaluation) {
        boolean valide = false;

        if (!(typeEvaluation == null) && estAlphabetique(typeEvaluation)) {
            if (typeEvaluation.equalsIgnoreCase("Examen") || typeEvaluation.equalsIgnoreCase("Rapport") || typeEvaluation.equalsIgnoreCase("TP")) {
                valide = true;
            }
        }
        if (!valide) {
            throw new ValidationException("La valeur " + typeEvaluation + " n'est pas valide ");
        }
    }

    public static void validerNomEvaluation(String nomEvaluation, String typeEvaluation) {
        boolean valide = false;

        if (!(nomEvaluation == null) && !(typeEvaluation == null)) {
            if (typeEvaluation.equalsIgnoreCase("Examen")) {
                if (nomEvaluation.startsWith("Examen") || nomEvaluation.startsWith("Quiz")) {
                    valide = true;
                }
            } else if (typeEvaluation.equalsIgnoreCase("Rapport")) {
                if (nomEvaluation.startsWith("Rapport")) {
                    valide = true;
                }
            } else if (typeEvaluation.equalsIgnoreCase("TP")) {
                if (nomEvaluation.startsWith("TP")) {
                    valide = true;
                }
            }
        }
        if (!valide) {
            throw new ValidationException("La valeur " + nomEvaluation + " n'est pas valide ");
        }
    }

    public static void validerPonderation(String ponderation) {
        boolean valide = false;

        if (!(ponderation == null)) {
            if (estNumerique(ponderation.substring(0, ponderation.length() - 1)) == true) {
                if (ponderation.substring(ponderation.length() - 1).equals("%")) {
                    if(convertirNumerique(ponderation.substring(0, ponderation.length() - 1)) <= 100){
                        valide = true;
                    }
                }
            }
        }
        if (!valide) {
            throw new ValidationException("La valeur " + ponderation + " n'est pas valide ");
        }
    }

    private static boolean estNumerique(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    
    private static int convertirNumerique(String str) {
        int numero = 0;
        int indice = 1;
        char c;
        for (int i=str.length()-1 ; i>=0 ; i--) {
            c = str.charAt(i);
            if (Character.isDigit(c)) {
                numero = numero + (Character.getNumericValue(c) * indice);
                indice = indice * 10;
            }
        }
        return numero;
    }

    private static boolean estAlphabetique(String str) {
        for (char c : str.toCharArray()) {
            if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z')) {
                return false;
            }
        }
        return true;
    }

    private static boolean estDouble(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
