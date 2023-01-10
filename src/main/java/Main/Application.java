package Main;

import java.util.List;
import java.util.Scanner;

import Model.IMetier;
import Model.MetierProduitImpl;
import Model.Produit;

public class Application {

	private final static IMetier<Produit> metier = new MetierProduitImpl();
	private final static String MENU = "\n" + "1. Afficher la liste des produits.\n"
			+ "2. Rechercher un produit par son id.\n" + "3. Ajouter un nouveau produit dans la liste.\n"
			+ "4. Supprimer un produit par id.\n" + "5. Save All.\n" + "6. Quitter ce programme.\n";

	public static void main(String[] args) {
		metier.getAllFromFile();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (choice != 6) {
			System.out.print("Menu:");
			System.out.println(MENU);

			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				List<Produit> produits = metier.getAll();
				if (produits != null) {
					if (!produits.isEmpty()) {
						for (Produit p : produits) {
							System.out.println(p);
						}
					} else {
						System.out.println("No Data For Produit");
					}
				} else {
					System.out.println("Errer System");
				}
				break;
			case 2:
				System.out.print("Enter the id: ");
				while (!scanner.hasNextLong()) {
					System.out.println("Invalid ID value  ");
					scanner.next();
					System.out.print("Enter the id: ");
				}
				long id = scanner.nextLong();
				Produit p = metier.findById(id);
				if (p != null) {
					System.out.println(p);
				} else {
					System.out.println("Product not found.\n\n");
				}
				break;
			case 3:
				long idproduit = 0;
				double priceproduit;
				int stockproduit;
				System.out.print("Enter the id: ");
				while (!scanner.hasNextLong()) {
					System.out.println("Invalid ID value  ");
					scanner.next();
					System.out.print("Enter the id: ");
				}
				idproduit = scanner.nextLong();
				System.out.print("Enter the name: ");
				String nameproduit = scanner.next();
				System.out.print("Enter the brand: ");
				String brandproduit = scanner.next();
				System.out.print("Enter the price: ");
				while (!scanner.hasNextDouble()) {
					System.out.println("Invalid price value  ");
					scanner.next();
					System.out.print("Enter the price: ");
				}
				priceproduit = scanner.nextDouble();
				System.out.print("Enter the description: ");
				String descriptionproduit = scanner.next();
				System.out.print("Enter the stock: ");
				while (!scanner.hasNextInt()) {
					System.out.println("Invalid stock value  ");
					scanner.next();
					System.out.print("Enter the stock: ");
				}
				stockproduit = scanner.nextInt();
				Produit produit = new Produit(idproduit, nameproduit, brandproduit, priceproduit, descriptionproduit,
						stockproduit);
				metier.add(produit);
				break;
			case 4:
				System.out.print("Enter the id: ");
				while (!scanner.hasNextLong()) {
					System.out.println("Invalid ID value  ");
					scanner.next();
					System.out.print("Enter the id: ");
				}
				id = scanner.nextLong();
				metier.delete(id);

				break;
			case 5:
				metier.saveAll();
				break;
			case 6:
				System.out.println("Program has been Quit");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		}
		scanner.close();
	}
}
