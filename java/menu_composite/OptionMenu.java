package menuApp;


import banque.AgenceBancaire;


/**
 * Classe parente des classes Menu et Option.
 */
public abstract class OptionMenu {

    private String titre; // Titre de l'option ou du menu
    private String code; // Code de l'option ou du menu

    public OptionMenu(String titre, String code) {
        this.titre = titre;
        this.code = code;
    }


    // Observateurs
    public String getTitre() {
        return this.titre;
    }
    public String getCode() {
        return this.code;
    }


    /**
     * Affiche le num�ro et le titre de l'option ou du menu.
     */
    public void afficher() {
        System.out.println(this.code + ") " + this.titre);
    }


    /**
     * Ex�cute l'option choisie dans un menu (� red�finir pour chaque option).
     * @param ag : agence bancaire � solliciter dans le contexte donn�
     */
    public abstract void executer(AgenceBancaire ag);

}
