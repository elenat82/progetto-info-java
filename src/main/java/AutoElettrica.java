public class AutoElettrica extends Auto{
//    attributi
    private int autonomia;
    private int tempoRicarica;

//    costruttore
    public AutoElettrica(Persona proprietario, CasaProduttrice marca, int potenzaFiscale, int autonomia, int tempoRicarica) {
        super(proprietario, marca, potenzaFiscale);
        this.autonomia = autonomia;
        this.tempoRicarica = tempoRicarica;
    }

//    getter
    public int getAutonomia() {
        return autonomia;
    }

    public int getTempoRicarica() {
        return tempoRicarica;
    }

//    Overriding	del	metodo	per	calcolare	la	tassa	di	proprietà’	che	in	questo	caso
//    deve	essere	0
    @Override
    public int calcolaTassa() {
        return 0;
    }

    @Override
    public String toString() {
        return "AutoElettrica{" +
                "autonomia=" + autonomia +
                ", tempoRicarica=" + tempoRicarica +
                "} " + super.toString();
    }
}
