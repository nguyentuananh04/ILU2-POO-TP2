package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois bonemine;
	private Gaulois panoramix;
	private Gaulois asterix;
	private Gaulois obelix;
	private ControlVerifierIdentite controlVerifierIdentite ;
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
		asterix = new Gaulois("Asterix", 4);
		village.ajouterHabitant(asterix);
		obelix = new Gaulois("Obelix", 6);
		village.ajouterHabitant(obelix);
		village.installerVendeur(bonemine, "fleurs", 15);
		village.installerVendeur(panoramix, "bananes", 10);
		village.installerVendeur(asterix, "fleurs", 5);
	}
	
	@Test
	void testControlAcheterProduit() {
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertNotNull(controlVerifierIdentite);
		assertNotNull(controlTrouverEtalVendeur);
		assertNotNull(controlAcheterProduit);
	}
	
	@Test
	void testVendeursProduitEgalNull() {
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois[] vendeursProduit = controlAcheterProduit.vendeursProduit("pommes");
		assertNull(vendeursProduit);
	}
	
	@Test
	void testVendeursProduitNotNull() {
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		Gaulois[] vendeursProduitActual = controlAcheterProduit.vendeursProduit("fleurs");
		Gaulois[] vendeursProduitExpected = {bonemine, asterix};
		assertArrayEquals(vendeursProduitActual, vendeursProduitExpected);
	}
	
	@Test
	void testVerifierIdentiteAcheteurTrue(){
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertTrue(controlAcheterProduit.verifierIdentiteAcheteur("Obelix"));
	}
	
	@Test
	void testVerifierIdentiteAcheteurFalse(){
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertFalse(controlAcheterProduit.verifierIdentiteAcheteur("myName"));
	}
	
	@Test
	void testAcheterAssezProduit() {
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertEquals(controlAcheterProduit.acheterProduit("Bonemine", 12), 12);
	}
	
	@Test
	void testAcheterManqueProduit() {
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		assertEquals(controlAcheterProduit.acheterProduit("Panoramix", 11), 10);
	}
	
	@Test
	void testAcheterKOProduit() {
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
		controlAcheterProduit.acheterProduit("Asterix", 5);
		assertEquals(controlAcheterProduit.acheterProduit("Asterix", 9), 0);
	}
}
