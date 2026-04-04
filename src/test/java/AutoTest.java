import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.*;
public class AutoTest {
	Auto autoClass;
	Persona persona1 = new Persona("Mario", "Rossi", "via Roma 1, Torino");
	Persona persona2 = new Persona("Giorgio", "Verdi", "piazza San Carlo 1, Torino");
	CasaProduttrice casaPr1 = new CasaProduttrice("Alfa Romeo", "Milano");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before class");
	}

	@Before
	public void setUpBefore() {
		autoClass = new Auto(persona1, casaPr1, 900);
	}

	@Test
	public void testGetId() {
		assertEquals(0, autoClass.getId());
	}

	@Test
	public void testGetProprietario() {
		assertEquals(persona1, autoClass.getProprietario());
	}

	@Test
	public void testGetMarca() {
		assertEquals(casaPr1, autoClass.getMarca());
	}

	@Test
	public void testGetPotenzaFiscale() {
		assertEquals(900, autoClass.getPotenzaFiscale());
	}

	@Test
	public void testGetnPassaggi() {
		assertEquals(0, autoClass.getnPassaggi());
	}

	@Test
	public void testSetProprietario() {
		Persona persona = new Persona("Giorgio", "Verdi", "piazza Castello 1, Roma");
		autoClass.setProprietario(persona);
		assertEquals(persona, autoClass.getProprietario());
	}

	@Test
	public void testSetMarca() {
		CasaProduttrice casaProduttrice = new CasaProduttrice("Peugeot", "via Garibaldi 3, Torino");
		autoClass.setMarca(casaProduttrice);
		assertEquals("Peugeot", autoClass.getMarca().getNome());
	}

	@Test
	public void testSetPotenzaFiscale() {
		autoClass.setPotenzaFiscale(100);
		assertEquals(100, autoClass.getPotenzaFiscale());
	}

	@Test
	public void testAumentaDiminuisciPotenzaFiscale() {
		autoClass.aumentaDiminuisciPotenzaFiscale(100);
		assertEquals(1000, autoClass.getPotenzaFiscale());
	}

	@Test
	public void testCalcolaTassa() {
		assertEquals(2700, autoClass.calcolaTassa());
	}

	@Test
	public void testAutoSort() {
		List<Auto> autoList = Arrays.asList(new Auto(persona2, casaPr1, 1000), autoClass);
		Collections.sort(autoList);
		assertEquals(autoList.get(0).getPotenzaFiscale(), 900);
	}

	@After
	public void tearDown() throws Exception {
		Field field = Auto.class.getDeclaredField("contatore");
		field.setAccessible(true);
		field.set(autoClass, 0);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}
}