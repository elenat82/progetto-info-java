public class Persona {
//    attributi
    private int id;
    private static int contatore = 1;
    private String cognome;
    private String nome;
    private String indirizzo;

//    costruttore
    public Persona(String cognome, String nome, String indirizzo) {
        this.cognome = cognome;
        this.nome = nome;
        this.indirizzo = indirizzo;
        //non usiamo this.contatore perchè è una variabile della classe, non dell'istanza
        this.id = contatore;
        contatore++;
    }

//    getter e setter solo per indirizzo
    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", cognome='" + cognome + '\'' +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}
