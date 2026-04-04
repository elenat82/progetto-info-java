import java.util.*;

public class Flotta {
//    attributi
    private Persona titolare;
    private Auto[] autoDellaFlotta;

//    costruttore
    public Flotta(Persona titolare, int numeroDiAuto) {
        this.titolare = titolare;
        this.autoDellaFlotta = new Auto[numeroDiAuto];
        //allocazione dei singoli elementi del vettore
        for (int i = 0; i < this.autoDellaFlotta.length; i++) {
            this.autoDellaFlotta[i] = new Auto(null, null, 0);
        }
    }

//    getter
    public Persona getTitolare() {
        return titolare;
    }

    public Auto[] getAutoDellaFlotta() {
        return autoDellaFlotta;
    }

//    setter
    public void setTitolare(Persona titolare) {
        this.titolare = titolare;
    }

//    altri metodi pubblici

//    Visualizzare	il	proprietario	dell’auto	dato	il	suo	indice
    public Persona getProprietarioSingolaAuto(int i) {
        return this.autoDellaFlotta[i].getProprietario();
    }

//    Cercare	tutte	le	auto (i	loro	indici)	posseduti	da	una	certa	persona
    public ArrayList<Integer> getIndiciAutoPerPersona(Persona persona) {
        ArrayList<Integer> indici = new ArrayList<Integer>();
        for (int i = 0; i < this.autoDellaFlotta.length; i++) {
            if (persona.equals(this.autoDellaFlotta[i].getProprietario())) {
                indici.add(i);
            }
        }
        return indici;
    }

//    Stampare	i	dati	di	ognuna	delle	auto
    public void stampaTutteAuto() {
        for (int i = 0; i < this.autoDellaFlotta.length; i++) {
            System.out.println(this.autoDellaFlotta[i].toString());
        }
    }

//    Modificare	il	proprietario	dell’auto	dato	il	suo	indice
    public void modificaProprietarioAuto(int i, Persona nuovoProprietario) {
        Auto auto = this.autoDellaFlotta[i];
        Class c = auto.getClass();
        if(c.getName() != "AutoStorica") {
            auto.setProprietario(nuovoProprietario);
        }
        else {
            System.out.println("Non è possibile modificare il proprietario di un'auto storica");
        }
    }

//    Trovare	la	tassa	di	proprietà	dell’auto	dato	indice
    public int getTassaProprieta(int i) {
        return this.autoDellaFlotta[i].calcolaTassa();
    }

//    Trovare	il	totale	delle	spese	delle	tasse	di	proprietà	da	pagare	per	tutte	le	auto	della flotta
    public int totaleTasseProprieta() {
        int somma = 0;
        for (int i = 0; i < this.autoDellaFlotta.length; i++) {
            somma = somma + this.autoDellaFlotta[i].calcolaTassa();
        }
        return somma;
    }

//    Trovare	l’auto	con	tassa	di	proprietà massima	e	quella con	tassa minima
    public HashMap<String, Integer> trovaMaxEMinTassa() {
        HashMap<String, Integer> tasse = new HashMap<String, Integer>();
        tasse.put("indiceTassaMinima", 0);
        tasse.put("indiceTassaMassima", 0);

        for (int i = 0; i < this.autoDellaFlotta.length; i++) {
            int indiceMinimoCorrente = tasse.get("indiceTassaMinima");
            int indiceMassimoCorrente = tasse.get("indiceTassaMassima");
            int tassaIndiceMinimoCorrente = this.autoDellaFlotta[indiceMinimoCorrente].calcolaTassa();
            int tassaIndiceMassimoCorrente = this.autoDellaFlotta[indiceMassimoCorrente].calcolaTassa();
            int tassa = this.autoDellaFlotta[i].calcolaTassa();
            if(tassa < tassaIndiceMinimoCorrente) {
                tasse.put("indiceTassaMinima", i);
            }
            if (tassa > tassaIndiceMassimoCorrente) {
                tasse.put("indiceTassaMassima", i);
            }
        }
        return tasse;
    }

//    Trovare	tutte	le	auto	data	la	marca
    public List<Auto> trovaAutoDellaMarca(CasaProduttrice marca) {
        List<Auto> listaAuto = new ArrayList<Auto>();
        for (int i = 0; i < this.autoDellaFlotta.length; i++) {
            if(marca.equals(this.autoDellaFlotta[i].getMarca())) {
                listaAuto.add(this.autoDellaFlotta[i]);
            }
        }
        return Collections.unmodifiableList(listaAuto);
    }

//    Trovare	le	auto	che	non	hanno	mai	cambiato	proprietario	(unico	proprietario), restituendo	il	vettore	di	tali	auto
    public ArrayList<Auto> trovaAutoUnicoProprietario() {
        ArrayList<Auto> autoCon1Proprietario = new ArrayList<Auto>();
        for (int i = 0; i < this.autoDellaFlotta.length; i++) {
            int cambi = this.autoDellaFlotta[i].getnPassaggi();
            if (cambi == 0) {
                autoCon1Proprietario.add(this.autoDellaFlotta[i]);
            }
        }
        return autoCon1Proprietario;
    }

//    Ordinare	le	auto	in	base	alla	potenza	fiscale
    public void ordinaPerPotenzaFiscale() {
        Arrays.sort(this.autoDellaFlotta);
    }

    @Override
    public String toString() {
        return "Flotta{" +
                "titolare=" + titolare +
                ", autoDellaFlotta=" + Arrays.toString(autoDellaFlotta) +
                '}';
    }
}
