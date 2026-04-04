public class CasaProduttrice {
//    attributi
    private int id;
    private static int contatore = 1;
    private String nome;
    private String sede;

//    costruttore
    public CasaProduttrice(String nome, String sede) {
        this.nome = nome;
        this.sede = sede;
        //non usiamo this.contatore perchè è una variabile della classe, non dell'istanza
        this.id = contatore;
        contatore++;
    }

    //    getter
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSede() {
        return sede;
    }

//    setter solo per la sede
    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "CasaProduttrice{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sede='" + sede + '\'' +
                '}';
    }
}
