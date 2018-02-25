/*
 * Classe qui représente un cours
 */
package inf2015.tp1.uqbc;

/**
 *
 * @author nawal
 */
public class Cours {
    private String cours;
    private String groupe;
    private String session;

    /**
     * @return the cours
     */
    public String getCours() {
        return cours;
    }

    /**
     * @param cours the cours to set
     */
    public void setCours(String cours) {
        this.cours = cours;
    }

    /**
     * @return the groupe
     */
    public String getGroupe() {
        return groupe;
    }

    /**
     * @param groupe the groupe to set
     */
    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    /**
     * @return the session
     */
    public String getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(String session) {
        this.session = session;
    }
    
    
}
