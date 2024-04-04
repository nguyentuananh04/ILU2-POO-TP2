package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ResourceBundle.Control;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.*;
import villagegaulois.*;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois bonemine;
	private Gaulois panoramix;
	private ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);

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
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
		assertNotNull(controlVerifierIdentite, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testResteEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testPrendreEtalSuccess() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertEquals(controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 11), 1);
		assertEquals(controlPrendreEtal.prendreEtal("Panoramix", "bananes", 100), 2);
	}
	
	@Test
	void testVerifierIdentite( ) {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.verifierIdentite("Bonemine"));
	}
}
