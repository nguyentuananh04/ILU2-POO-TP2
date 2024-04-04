package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
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
		village.installerVendeur(bonemine, "fleurs", 15);
		village.installerVendeur(panoramix, "bananes", 10);
	}
	
	@Test
	void testControlAfficherMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		assertNotNull(controlAfficherMarche);
	}
	
	@Test
	void testDonnerInfosMarche() {
		ControlAfficherMarche controlAfficherMarche = new ControlAfficherMarche(village);
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		assertEquals(infosMarche.length, 6);
		assertEquals(infosMarche[0], "Bonemine");
		assertEquals(infosMarche[1], "15");
		assertEquals(infosMarche[2], "fleurs");
		assertEquals(infosMarche[3], "Panoramix");
		assertEquals(infosMarche[4], "10");
		assertEquals(infosMarche[5], "bananes");
	}
}
