package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marcher aujourd'hui!");
		} else {
			String donnesEtals[] = controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe = donnesEtals[0];
			if (etalOccupe.equals("true")){
				String produit = donnesEtals[2];
				String quantiteInit = donnesEtals[3];
				String quantiteVendue = donnesEtals[4];
				System.out.println("Vous avez vendu " + quantiteVendue + " sur " + quantiteInit + " " + produit +"\n");
				System.out.println("Au revoir " + donnesEtals[0] + ", passez une bonne journée");
		}
	}
}
}
