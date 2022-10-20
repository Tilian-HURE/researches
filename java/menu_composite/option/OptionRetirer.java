package menuApp.option;


import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.CompteException;
import java.util.Scanner;


public class OptionRetirer extends Option {

    public OptionRetirer() {
        super("Retirer de l'argent sur un compte", "2");
    }


    @Override
    public void executer(AgenceBancaire ag) {
        System.out.print("\nN° compte -> ");
        Scanner input = new Scanner(System.in);
        String no = input.next();
        System.out.print("Montant à retirer -> ");
        double amount = input.nextDouble();
        this.retirerSurUnCompte(ag, no, amount);
    }


    /**
     * Fonction annexe.
     */
    public static void retirerSurUnCompte (AgenceBancaire ag, String numeroCompte, double montant) {
        Compte c;
        c = ag.getCompte(numeroCompte);
        if (c==null) {
            System.out.println("Compte inexistant ...");
        } else {
            System.out.println("Solde avant retrait : " + c.soldeCompte());
            try {
                c.retirer(montant);
                System.out.println("Montant retiré, solde : "+c.soldeCompte());
            } catch (CompteException e) {
                System.out.println("Erreur de dépot, solde inchangé : " + c.soldeCompte());
                System.out.println(e.getMessage());
            }
        }
    }

}
