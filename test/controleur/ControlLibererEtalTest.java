package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ResourceBundle.Control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois bonemine;
	private Gaulois panoramix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

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
		village.installerVendeur(bonemine, "fleurs", 5);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal, "Constructer ne renvoie pas null");
	}
	
	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
	}
	
	@Test
	void testIsNotVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertFalse(controlLibererEtal.isVendeur("Panoramix"));
	}
	
	@Test
	void testLibererEtalSuccess() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		String[] etatEtal = controlLibererEtal.libererEtal("Bonemine");
		assertEquals("true", etatEtal[0]);
		assertEquals("Bonemine", etatEtal[1]);
		assertEquals("fleurs", etatEtal[2]);
		assertEquals("5", etatEtal[3]);
		assertEquals("0", etatEtal[4]);
	}
	
	@Test
	void testLIbererEtalFail() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		String[] etatEtal = controlLibererEtal.libererEtal("Panoramix");
		assertNull(etatEtal);
	}
}
