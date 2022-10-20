package menuApp.option;


import banque.AgenceBancaire;


public class OptionAjouterCompte extends Option {

    public OptionAjouterCompte() {
        super("Ajouter un compte", "1");
    }


    @Override
    public void executer(AgenceBancaire ag) {
        System.out.println("\nTODO");
    }

}
