package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean NomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!NomVendeurConnu) {
			System.out.println("Je suis désolée" + nomVendeur
					+ "mais il faut etre un habitant de notre village pour commencer ici.");
		} else {
			System.out.println("Bonjour" + nomVendeur + ", je vais regarder si je peux voux trouver un étal");
			boolean EtalDisponible = controlPrendreEtal.resteEtals();
			if (!EtalDisponible) {
				System.out.println("Désolé je n'ai plus d'étals dispobible");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous!");
		System.out.println("il me faudrait quelques renseignements :");
		String produit = scan.next();
		int nbProduit = Clavier.entrerEntier("combien souhaitez vous en vendre?");
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur" + nomVendeur + "s'est installé a l'étal n" + numeroEtal);
		}
	}
}
