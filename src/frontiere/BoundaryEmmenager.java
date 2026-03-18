package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder bienvenueGaulois = new StringBuilder();
					bienvenueGaulois.append("Bienvenue villageois ");
					bienvenueGaulois.append(nomVisiteur);
					bienvenueGaulois.append("\n");
					bienvenueGaulois.append("Quelle est votre force?\n");
					int forceGaulois = -1;
					forceGaulois = Clavier.entrerEntier(bienvenueGaulois.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder bienvenueDruide = new StringBuilder();
		StringBuilder effetPotionMinQuestion = new StringBuilder();
		StringBuilder effetPotionMaxQuestion = new StringBuilder();
		int forceDruide = -1;
		int effetPotionMin = -1;
		int effetPotionMax = -1;
		
		bienvenueDruide.append("Bienvenue druide " + nomVisiteur + "\n");
		bienvenueDruide.append("Quelle est votre force?\n");
		forceDruide = Clavier.entrerEntier(bienvenueDruide.toString());
		
		do {
			effetPotionMinQuestion.append("Quelle est la fore de potion la plus faible que vous produisez?\n");
			effetPotionMin = Clavier.entrerEntier((effetPotionMinQuestion.toString()));
			
			effetPotionMaxQuestion.append("Quelle est la fore de potion la plus forte que vous produisez?\n");
			effetPotionMax = Clavier.entrerEntier((effetPotionMaxQuestion.toString()));
			
			if(effetPotionMax < effetPotionMin) {
				System.out.println("Attention Druide, vous vous êtes trompés entre le minimum et le maximum.\n");
			}
		} while (effetPotionMax < effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
