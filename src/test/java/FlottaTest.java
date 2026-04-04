import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class FlottaTest {

    Flotta flottaClass;
    Persona persona1 = new Persona("Mario", "Rossi", "via Roma 1, Torino");
    CasaProduttrice casaPr1 = new CasaProduttrice("Alfa Romeo", "Milano");
    CasaProduttrice casaPr2 = new CasaProduttrice("Peugeot", "Roma");
    Auto auto1 = new Auto(persona1, casaPr1, 1000);
    Auto auto2 = new Auto(persona1, casaPr2, 1200);

    @Before
    public void setUpBefore() throws Exception {
        flottaClass = new Flotta(persona1, 1);
        flottaClass.getAutoDellaFlotta()[0] = auto1;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void trovaAutoDellaMarca() {
        List<Auto> autoMarca = flottaClass.trovaAutoDellaMarca(casaPr1);
        System.out.println(autoMarca);
        assertThrows(UnsupportedOperationException.class, () -> {
            autoMarca.add(auto2);
        });
    }
}