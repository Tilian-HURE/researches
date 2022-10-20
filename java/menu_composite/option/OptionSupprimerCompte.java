package menuApp.option;


import banque.AgenceBancaire;


public class OptionSupprimerCompte extends Option {

    public OptionSupprimerCompte() {
        super("Supprimer un compte", "2");
    }


    @Override
    public void executer(AgenceBancaire ag) {
        System.out.println("\nTODO");
    }

}
