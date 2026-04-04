import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CasaProduttrice casaProduttrice1 = new CasaProduttrice("Ferrari", "Maranello");
        System.out.println(casaProduttrice1);

        Persona persona1 = new Persona("Rossi", "Antonio",  "via Roma 25, Torino");
        System.out.println(persona1);

        Auto auto1 = new Auto(persona1, casaProduttrice1, 1200);
        System.out.println(auto1);

        CasaProduttrice casaProduttrice2 = new CasaProduttrice(("Audi"), "Berlino");
        System.out.println(casaProduttrice2);

        Persona persona2 = new Persona("Verdi", "Giorgio",  "corso Garibaldi 1, Milano");
        System.out.println(persona2);

        Auto auto2 = new Auto(persona2, casaProduttrice2, 900);
        System.out.println(auto2);

        int tassaAuto1 = auto1.calcolaTassa();
        System.out.println("tassa auto1: " + tassaAuto1);

        casaProduttrice1.setSede("Torino");
        System.out.println("auto1 dopo cambio sede casaProduttrice1: " + auto1.getMarca());

        auto2.setPotenzaFiscale(1600);
        System.out.println("auto2 dopo cambio potenza fiscale con setter: " + auto2.getPotenzaFiscale());
        auto2.aumentaDiminuisciPotenzaFiscale(-500);
        System.out.println("auto2 dopo cambio potenza fiscale con secondo metodo: " + auto2.getPotenzaFiscale());

        auto1.setProprietario(new Persona("Esposito", "Pasquale", "piazza Plebiscito 3, Napoli"));
        auto1.setProprietario(new Persona("De Angelis", "Roberto", "via Condotti 1, Milano"));
        System.out.println("attuale proprietario auto1: " + auto1.getProprietario());
        System.out.println("numero di passaggi proprietà auto1: " + auto1.getnPassaggi());

        AutoElettrica autoElettrica1 = new AutoElettrica(persona1, casaProduttrice1, 1200, 120, 55);
        System.out.println(autoElettrica1);
        System.out.println("tassa autoElettrica1: "+ autoElettrica1.calcolaTassa());

//        Scommentare la riga successiva per provare l'anno di immatricolazione successivo al 1980
//        AutoStorica autoStorica1 = new AutoStorica(persona2, casaProduttrice2, 1200, 2000);
        AutoStorica autoStorica2 = new AutoStorica(persona2, casaProduttrice2, 1200, 1970);
        System.out.println(autoStorica2);

        //autoStorica2.setProprietario(persona1);

        Flotta flotta = new Flotta(new Persona("Antonelli", "Antonello", "piazza di Spagna 1, Roma"), 5);

        flotta.getAutoDellaFlotta()[0] = auto1;
        flotta.getAutoDellaFlotta()[1] = autoStorica2;
        flotta.getAutoDellaFlotta()[2] = auto2;
        flotta.getAutoDellaFlotta()[3] = autoElettrica1;
        flotta.getAutoDellaFlotta()[4] = new AutoStorica(persona1, casaProduttrice1, 900, 1966);

//        Visualizzare	il	proprietario	dell’auto	dato	il	suo	indice
        Persona proprietarioAuto3 = flotta.getProprietarioSingolaAuto(3);
        System.out.println("Il proprietario dell'auto all'indice 3 è: " + proprietarioAuto3);

//        Cercare	tutte	le	auto (i	loro	indici)	posseduti	da	una	certa	persona
        ArrayList<Integer> autoPossedateDaP1 = flotta.getIndiciAutoPerPersona(persona1);
        System.out.println("Indici auto possedute da p1: " + autoPossedateDaP1);

//        Modificare	il	proprietario	dell’auto	dato	il	suo	indice
        flotta.modificaProprietarioAuto(4, persona2);
        System.out.println("Nuovo proprietario dell'auto all'indice 4: " + flotta.getProprietarioSingolaAuto(4));

//        Trovare	la	tassa	di	proprietà	dell’auto	dato	indice
        int tassaAuto0 = flotta.getTassaProprieta(0);
        System.out.println("La tassa dell'auto all'indice 0 è: " + tassaAuto0);

//        Trovare	l’auto	con	tassa	di	proprietà massima	e	quella con	tassa minima
        HashMap<String, Integer> tasseMinEMax = flotta.trovaMaxEMinTassa();
        System.out.println("L'auto con la tassa minima è " + flotta.getAutoDellaFlotta()[tasseMinEMax.get("indiceTassaMinima")]);
        System.out.println("L'auto con la tassa massima è " + flotta.getAutoDellaFlotta()[tasseMinEMax.get("indiceTassaMassima")]);

//        Trovare	tutte	le	auto	data	la	marca
        List<Auto> autoDellaMarca = flotta.trovaAutoDellaMarca(casaProduttrice1);
        System.out.println("Le auto della marca " + casaProduttrice1 + " sono: " + autoDellaMarca);

//        Trovare	le	auto	che	non	hanno	mai	cambiato	proprietario
        ArrayList<Auto> autoUnicoProprietario = flotta.trovaAutoUnicoProprietario();
        System.out.println("Le auto che non hanno mai cambiato proprietario sono: " + autoUnicoProprietario);

//        Ordinare	le	auto	in	base	alla	potenza	fiscale
        flotta.ordinaPerPotenzaFiscale();
        System.out.println("Flotta ordinata per potenza fiscale: " + flotta);

    }

}