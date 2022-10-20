package menuApp.option;


import banque.AgenceBancaire;


public class OptionListeDesComptes extends Option {

    public OptionListeDesComptes() {
        super("Liste des comptes de l'agence", "1");
    }


    @Override
    public void executer(AgenceBancaire ag) {
        ag.afficher();
    }

}
