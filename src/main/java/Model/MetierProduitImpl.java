package Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MetierProduitImpl implements IMetier<Produit> {

	List<Produit> produits = new ArrayList<Produit>();

	public void add(Produit o) {
		// TODO Auto-generated method stub
		Produit p = findById(o.getId());
		if (p == null) {
			produits.add(o);
		} else {
			System.out.println("Produit existe déjà");
		}
	}

	public List<Produit> getAll() {
		// TODO Auto-generated method stub
		return produits;
	}

	public void getAllFromFile() {
		// TODO Auto-generated method stub

//		File file = new File("produit.txt");
//		if (file.exists() && !file.isDirectory()) {
//			try {
//				FileInputStream fis = new FileInputStream(file);
//				ObjectInputStream ois = new ObjectInputStream(fis);
//				this.produits = (List<Produit>) ois.readObject();
//			} catch (Exception e) { // TODO Auto-generated catch block e.printStackTrace();
//				return null;
//			}
//		}
//		return this.produits;

		ObjectMapper objectMapper = new ObjectMapper();
		File jsonFile = new File("produits.json");
		if (jsonFile.exists() && !jsonFile.isDirectory()) {
			try {
				String jsonString = new String(Files.readAllBytes(Paths.get(jsonFile.getAbsolutePath())));
				this.produits = objectMapper.readValue(jsonString,
						objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Produit.class));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Produit findById(long id) {
		// TODO Auto-generated method stub

		for (Produit p : produits) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;

		// return this.produits.stream().filter(produit -> produit.getId() ==
		// id).findFirst().orElseThrow(null);

	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		Produit p = findById(id);
		if (p != null) {
			produits.remove(p);
			System.out.println("Produit suprimer avec success");
		}else {
			System.out.println("Produit n'existe pas");
		}
	}

	public void saveAll() {
		/*
		 * File file = new File("produit.txt"); try { FileOutputStream fos = new
		 * FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos);
		 * 
		 * oos.writeObject(this.produits);
		 * 
		 * oos.close();
		 * 
		 * } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			objectMapper.writeValue(Paths.get("produits.json").toFile(), this.produits);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
