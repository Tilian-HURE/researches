package menuApp.menu;


import banque.AgenceBancaire;
import menuApp.OptionMenu;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Menu (ou sous-menu) constitu� d'options et/ou de sous-menus.
 * --> classe parente � red�finir pour chaque classe fille impl�mentant un menu/sous-menu
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
     * Ajoute une option ou un sous-menu � la suite de ceux d�j� pr�sents dans le menu actuel.
     * @param optionMenu : l'option ou le sous-menu � ajouter
     */
    public void ajouterOption(OptionMenu optionMenu) {
        this.omListe.add(optionMenu);
    }

    /**
     * Remplace l'option ou le sous-menu d'indice donn� par l'option ou le sous-menu donn�, dans le menu actuel.
     * @param indice : indice de l'option ou du sous-menu � modifier
     * @param optionMenu : option ou sous-menu de remplacement
     */
    public void modifierOption(int indice, OptionMenu optionMenu) {
        this.omListe.set(indice, optionMenu);
    }

    /**
     * Supprime l'option ou le sous-menu d'indice donn�, dans le menu actuel.
     * @param indice : indice de l'option ou du sous-menu � supprimer
     * @throws Exception si la liste d'options/sous-menus est vide
     */
    public void supprimerOption(int indice) throws Exception {
        if (this.omListe.size() == 0) {
            throw new Exception("ERREUR : Ce menu ne contient aucune option ni sous-menu.");
        }
        this.omListe.remove(indice);
    }

    /**
     * Supprime l'option ou le sous-menu donn�, dans le menu actuel.
     * @param optionMenu : option ou sous-menu � supprimer
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
     * Permet de choisir une option qui sera ex�cut�e ou d'ouvrir un sous-menu.
     * @param ag : agence bancaire qui sera utilis�e pour l'ex�cution de certaines options pour le contexte donn�
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
     * Ex�cute un menu (lance la proc�dure permettant � l'utilisateur de choisir une option).
     * @param ag : agence bancaire � solliciter dans le contexte donn�
     */
    @Override
    public void executer(AgenceBancaire ag) {
        this.choisir(ag);
    }

}
