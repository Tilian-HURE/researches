package menuApp.option;


import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.CompteException;
import java.util.Scanner;


public class OptionDeposer extends Option {

    public OptionDeposer() {
        super("Déposer de l'argent sur un compte", "1");
    }


    @Override
    public void executer(AgenceBancaire ag) {
        System.out.print("\nN° compte -> ");
        Scanner input = new Scanner(System.in);
        String no = input.next();
        System.out.print("Montant à déposer -> ");
        double amount = input.nextDouble();
        this.deposerSurUnCompte(ag, no, amount);
    }


    /**
     * Fonction annexe.
     */
    public static void deposerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
        Compte c;
        c = ag.getCompte(numeroCompte);
        if (c==null) {
            System.out.println("Compte inexistant ...");
        } else {
            System.out.println("Solde avant dépôt: "+c.soldeCompte());
            try {
                c.deposer(montant);
                System.out.println("Montant déposé, solde : "+c.soldeCompte());
            } catch (CompteException e) {
                System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
                System.out.println(e.getMessage());
            }
        }
    }

}
