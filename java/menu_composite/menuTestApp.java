package menuApp;


import application.AccesAgenceBancaire;
import banque.AgenceBancaire;
import menuApp.menu.Menu;
import menuApp.menu.MenuGestionComptes;
import menuApp.menu.MenuOperationsComptes;
import menuApp.menu.MenuPrincipal;
import menuApp.option.*;


/**
 * Classe de test applicative démontrant un exemple de l'utilisation des classes implémentant des
 * options ou des menus/sous-menus dans le contexte d'une agence bancaire gérant des comptes.
 */
public class menuTestApp {

    public static void main(String[] args) {
        // Récupération d'une agence bancaire
        AgenceBancaire monAg = AccesAgenceBancaire.getAgenceBancaire();

        // Création du 1er sous-menu (opérations sur les comptes)
        Menu sousMenu1 = new MenuOperationsComptes();
        sousMenu1.ajouterOption(new OptionDeposer());
        sousMenu1.ajouterOption(new OptionRetirer());

        // Création du 2e sous-menu (gestion des comptes)
        Menu sousMenu2 = new MenuGestionComptes();
        sousMenu2.ajouterOption(new OptionAjouterCompte());
        sousMenu2.ajouterOption(new OptionSupprimerCompte());

        // Création du menu principal
        Menu menuPrincipal = new MenuPrincipal();
        menuPrincipal.ajouterOption(new OptionListeDesComptes());
        menuPrincipal.ajouterOption(new OptionVoirCompte());
        menuPrincipal.ajouterOption(sousMenu1);
        menuPrincipal.ajouterOption(sousMenu2);

        // Test du menu
        menuPrincipal.executer(monAg);
    }

}
