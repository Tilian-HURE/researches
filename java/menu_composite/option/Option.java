package menuApp.option;


import banque.AgenceBancaire;
import menuApp.OptionMenu;


/**
 * Option simple d'un menu.
 * --> classe parente � red�finir pour chaque classe fille impl�mentant une option
 */
public abstract class Option extends OptionMenu {

    public Option(String titre, String code) {
        super(titre, code);
    }


    /**
     * Ex�cute l'option choisie dans un menu (� red�finir pour chaque option).
     * @param ag : agence bancaire � solliciter dans le contexte donn�
     */
    @Override
    public abstract void executer(AgenceBancaire ag);

}
