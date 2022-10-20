package menuApp.option;


import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.CompteException;
import java.util.Scanner;


public class OptionDeposer extends Option {

    public OptionDeposer() {
        super("D�poser de l'argent sur un compte", "1");
    }


    @Override
    public void executer(AgenceBancaire ag) {
        System.out.print("\nN� compte -> ");
        Scanner input = new Scanner(System.in);
        String no = input.next();
        System.out.print("Montant � d�poser -> ");
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
            System.out.println("Solde avant d�p�t: "+c.soldeCompte());
            try {
                c.deposer(montant);
                System.out.println("Montant d�pos�, solde : "+c.soldeCompte());
            } catch (CompteException e) {
                System.out.println("Erreur de d�pot, solde inchang� : " + c.soldeCompte());
                System.out.println(e.getMessage());
            }
        }
    }

}
