package menuApp.option;


import banque.AgenceBancaire;
import banque.Compte;
import java.util.Scanner;


public class OptionVoirCompte extends Option {

    public OptionVoirCompte() {
        super("Voir un compte (avec son n°)", "2");
    }


    @Override
    public void executer(AgenceBancaire ag) {
        System.out.print("\nN° compte -> ");
        Scanner input = new Scanner(System.in);
        String no = input.next();
        Compte account = ag.getCompte(no);
        if (account == null) {
            System.out.println("Compte inexistant.");
        } else {
            account.afficher();
        }
    }

}
