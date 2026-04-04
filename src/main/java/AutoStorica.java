public class AutoStorica extends Auto{
//    attributi
    private int annoImmatricolazione;
    private static int maxAnnoImmatricolazione = 1980;

//    costruttore
    public AutoStorica(Persona proprietario, CasaProduttrice marca, int potenzaFiscale, int annoImmatricolazione) {
        super(proprietario, marca, potenzaFiscale);
        if (annoImmatricolazione <= maxAnnoImmatricolazione) {
            this.annoImmatricolazione = annoImmatricolazione;
        }
        else {
            System.out.println("L'anno di immatricolazione deve essere precedente al " + maxAnnoImmatricolazione);
            System.exit(-1);
        }
    }

//    Overriding	del	metodo	per	cambiare	il	proprietario che in	questo	caso	che	non
//    deve	permettere	il	cambio	(restituire	un	errore)
    @Override
    public void setProprietario(Persona proprietario) {
        System.out.println("Non è possibile cambiare il proprietario di una AutoStorica");
        System.exit(-1);
    }

    @Override
    public String toString() {
        return "AutoStorica{" +
                "annoImmatricolazione=" + annoImmatricolazione +
                "} " + super.toString();
    }
}
