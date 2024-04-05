package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Gaulois abra;
	private Gaulois asterix;
	private Druide courcix;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		village.setChef( new Chef("abraracourcix", 10, village));
		abra = new Gaulois("abra",10);
		village.ajouterHabitant(abra);
		courcix = new Druide("courcix", 4, 1, 5);
		village.ajouterHabitant(courcix);
		asterix= new Gaulois("asterix",10);
		village.ajouterHabitant(asterix);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage,"is not null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[0] , "abraracourcix");
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[1] , "abra");
		assertEquals(controlAfficherVillage.donnerNomsVillageois()[3] , "asterix");
		assertNotEquals(controlAfficherVillage.donnerNomsVillageois()[1] , "asterix");
		assertNotEquals(controlAfficherVillage.donnerNomsVillageois()[2] , "asterix");


		
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNomVillage(),"le village des irréductibles" );
		assertNotEquals(controlAfficherVillage.donnerNomVillage(),"le village des non irréductibles" );
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);
		assertNotEquals(controlAfficherVillage.donnerNbEtals(), 6);
		assertNotEquals(controlAfficherVillage.donnerNbEtals(), 7);
		assertNotEquals(controlAfficherVillage.donnerNbEtals(), 75);
		assertNotEquals(controlAfficherVillage.donnerNbEtals(), 74);
		assertNotEquals(controlAfficherVillage.donnerNbEtals(), 17);
	}

}
