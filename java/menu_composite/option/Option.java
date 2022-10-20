package menuApp.option;


import banque.AgenceBancaire;
import menuApp.OptionMenu;


/**
 * Option simple d'un menu.
 * --> classe parente à redéfinir pour chaque classe fille implémentant une option
 */
public abstract class Option extends OptionMenu {

    public Option(String titre, String code) {
        super(titre, code);
    }


    /**
     * Exécute l'option choisie dans un menu (à redéfinir pour chaque option).
     * @param ag : agence bancaire à solliciter dans le contexte donné
     */
    @Override
    public abstract void executer(AgenceBancaire ag);

}
