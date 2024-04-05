package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois abra;
	
	@BeforeEach
	
	void setUp() throws Exception {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		village.setChef( new Chef("Abraracourcix", 10, village));
		abra = new Gaulois("abra",10);
		village.ajouterHabitant(abra);
		
	}

	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite,"Constructeur n'est pas nul");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertEquals(controlVerifierIdentite.verifierIdentite("abra"), true);
		assertEquals(controlVerifierIdentite.verifierIdentite("Courix"), false);
	}

}
