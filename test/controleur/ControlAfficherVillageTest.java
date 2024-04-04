package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.*;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois bonemine;
	private Gaulois panoramix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		bonemine = new Gaulois("Bonemine", 3);
		village.ajouterHabitant(bonemine);
		panoramix = new Gaulois("Panoramix", 5);
		village.ajouterHabitant(panoramix);
	}
	
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String[] villageoisActual = controlAfficherVillage.donnerNomsVillageois();
		String[] villageoisExpected = {"Abraracourcix", "Bonemine", "Panoramix"};
		assertArrayEquals(villageoisActual, villageoisExpected);
	}
	
	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals("le village des irréductibles", controlAfficherVillage.donnerNomVillage());
	}
	
	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);
	}

}
