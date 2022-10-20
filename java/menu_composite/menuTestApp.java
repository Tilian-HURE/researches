package menuApp;


import application.AccesAgenceBancaire;
import banque.AgenceBancaire;
import menuApp.menu.Menu;
import menuApp.menu.MenuGestionComptes;
import menuApp.menu.MenuOperationsComptes;
import menuApp.menu.MenuPrincipal;
import menuApp.option.*;


/**
 * Classe de test applicative d�montrant un exemple de l'utilisation des classes impl�mentant des
 * options ou des menus/sous-menus dans le contexte d'une agence bancaire g�rant des comptes.
 */
public class menuTestApp {

    public static void main(String[] args) {
        // R�cup�ration d'une agence bancaire
        AgenceBancaire monAg = AccesAgenceBancaire.getAgenceBancaire();

        // Cr�ation du 1er sous-menu (op�rations sur les comptes)
        Menu sousMenu1 = new MenuOperationsComptes();
        sousMenu1.ajouterOption(new OptionDeposer());
        sousMenu1.ajouterOption(new OptionRetirer());

        // Cr�ation du 2e sous-menu (gestion des comptes)
        Menu sousMenu2 = new MenuGestionComptes();
        sousMenu2.ajouterOption(new OptionAjouterCompte());
        sousMenu2.ajouterOption(new OptionSupprimerCompte());

        // Cr�ation du menu principal
        Menu menuPrincipal = new MenuPrincipal();
        menuPrincipal.ajouterOption(new OptionListeDesComptes());
        menuPrincipal.ajouterOption(new OptionVoirCompte());
        menuPrincipal.ajouterOption(sousMenu1);
        menuPrincipal.ajouterOption(sousMenu2);

        // Test du menu
        menuPrincipal.executer(monAg);
    }

}
