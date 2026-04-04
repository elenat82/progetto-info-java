public class Auto implements Comparable<Auto>{
//    attributi
    private int id;
    private static int contatore = 1;
    private Persona proprietario;
    private CasaProduttrice marca;
    private int potenzaFiscale;
    private int nPassaggi = 0;

//    costruttore
    public Auto(Persona proprietario, CasaProduttrice marca, int potenzaFiscale) {
        this.proprietario = proprietario;
        this.marca = marca;
        this.potenzaFiscale = potenzaFiscale;
        //non usiamo this.contatore perchè è una variabile della classe, non dell'istanza
        this.id = contatore;
        contatore++;
    }

//    getter
    public int getId() {
        return id;
    }

    public Persona getProprietario() {
        return proprietario;
    }

    public CasaProduttrice getMarca() {
        return marca;
    }

    public int getPotenzaFiscale() {
        return potenzaFiscale;
    }

    public int getnPassaggi() {
        return nPassaggi;
    }

//    setter per tutte tranne identificativo e numero di passaggi di proprietà
    public void setProprietario(Persona proprietario) {
        this.proprietario = proprietario;
        this.aumentaPassaggiDi1();
    }

    public void setMarca(CasaProduttrice marca) {
        this.marca = marca;
    }

    public void setPotenzaFiscale(int potenzaFiscale) {
        this.potenzaFiscale = potenzaFiscale;
    }

//    altri metodi pubblici

//    faccio solo uno per aumentare o diminuire la potenza fiscale e uno per calcolare la tassa,
//    per cambiare il proprietario utilizzerò il setter definito prima
    public void aumentaDiminuisciPotenzaFiscale(int delta) {
        this.potenzaFiscale += delta;
    }

    public int calcolaTassa() {
//        potenza fiscale * 3
        return this.potenzaFiscale * 3;
    }

//    altri metodi privati

//    richiamo questo metodo dentro setProprietario così ogni volta che viene cambiato il proprietario
//    il numero dei passaggi aumenta di uno
    private void aumentaPassaggiDi1() {
        this.nPassaggi++;
    }

//    metodo richiesto dall'interfaccia Comparable
    @Override
    public int compareTo(Auto a) {
        if (this.getPotenzaFiscale() < a.getPotenzaFiscale()) {
            return -1;
        }
        else if (this.getPotenzaFiscale() == a.getPotenzaFiscale()) {
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", proprietario=" + proprietario +
                ", marca=" + marca +
                ", potenzaFiscale=" + potenzaFiscale +
                ", nPassaggi=" + nPassaggi +
                '}';
    }
}
