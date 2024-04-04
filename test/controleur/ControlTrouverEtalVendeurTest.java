package controleur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ResourceBundle.Control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.Etal;

class ControlTrouverEtalVendeurTest {
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
		village.installerVendeur(bonemine, "fleurs", 5);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur,"Constructeur ne renvoie pas null");
	}
	
	@Test
	void testTrouverEtalVendeurSuccess() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur.trouverEtalVendeur("Bonemine"),"Vendeur introuvable");
	}
	
	@Test
	void testTrouverEtalVendeurFail() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("Panoramix"),"Vendeur inexistant mais trouvable");
	}
}
