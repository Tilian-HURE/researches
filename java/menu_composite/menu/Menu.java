package menuApp.menu;


import banque.AgenceBancaire;
import menuApp.OptionMenu;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Menu (ou sous-menu) constitué d'options et/ou de sous-menus.
 * --> classe parente à redéfinir pour chaque classe fille implémentant un menu/sous-menu
 */
public abstract class Menu extends OptionMenu {

    private ArrayList<OptionMenu> omListe; // Liste des options et/ou sous-menus du menu actuel
    private String codeQuitter; // Code de fermeture du menu actuel

    public Menu(String titre, String code, String codeQuitter) {
        super(titre, code);
        this.omListe = new ArrayList<OptionMenu>();
        this.codeQuitter = codeQuitter;
    }


    /**
     * Ajoute une option ou un sous-menu à la suite de ceux déjà présents dans le menu actuel.
     * @param optionMenu : l'option ou le sous-menu à ajouter
     */
    public void ajouterOption(OptionMenu optionMenu) {
        this.omListe.add(optionMenu);
    }

    /**
     * Remplace l'option ou le sous-menu d'indice donné par l'option ou le sous-menu donné, dans le menu actuel.
     * @param indice : indice de l'option ou du sous-menu à modifier
     * @param optionMenu : option ou sous-menu de remplacement
     */
    public void modifierOption(int indice, OptionMenu optionMenu) {
        this.omListe.set(indice, optionMenu);
    }

    /**
     * Supprime l'option ou le sous-menu d'indice donné, dans le menu actuel.
     * @param indice : indice de l'option ou du sous-menu à supprimer
     * @throws Exception si la liste d'options/sous-menus est vide
     */
    public void supprimerOption(int indice) throws Exception {
        if (this.omListe.size() == 0) {
            throw new Exception("ERREUR : Ce menu ne contient aucune option ni sous-menu.");
        }
        this.omListe.remove(indice);
    }

    /**
     * Supprime l'option ou le sous-menu donné, dans le menu actuel.
     * @param optionMenu : option ou sous-menu à supprimer
     */
    public void supprimerOption(OptionMenu optionMenu) throws Exception {
        if (this.omListe.size() == 0) {
            throw new Exception("ERREUR : Ce menu ne contient aucune option ni sous-menu.");
        }
        this.omListe.remove(optionMenu);
    }


    /**
     * Affiche le menu et liste ses options.
     */
    public void afficherMenu() {
        System.out.println("\n" + this.getTitre() + " :");
        for (OptionMenu optionMenu: this.omListe) {
            optionMenu.afficher();
        }
        System.out.print(this.codeQuitter + ") Quitter\nVotre choix -> ");
    }


    /**
     * Permet de choisir une option qui sera exécutée ou d'ouvrir un sous-menu.
     * @param ag : agence bancaire qui sera utilisée pour l'exécution de certaines options pour le contexte donné
     */
    public void choisir(AgenceBancaire ag) {
        boolean continuer = true, erreur = true;
        Scanner saisie = new Scanner(System.in);
        String choix;
        while (continuer) {
            this.afficherMenu();
            choix = saisie.next();
            for (OptionMenu optionMenu: this.omListe) {
                if (choix.equals(optionMenu.getCode())) {
                    optionMenu.executer(ag);
                    erreur = false;
                    break;
                }
            }
            if (choix.equals(this.codeQuitter)) {
                continuer = false;
            } else if (erreur) {
                System.out.println("\nErreur de saisie.");
            }

        }
    }


    /**
     * Exécute un menu (lance la procédure permettant à l'utilisateur de choisir une option).
     * @param ag : agence bancaire à solliciter dans le contexte donné
     */
    @Override
    public void executer(AgenceBancaire ag) {
        this.choisir(ag);
    }

}
