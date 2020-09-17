package edu.td0.models;

import java.util.ArrayList;
import java.util.List;


public class Categorie {
	private String libelle;
	List<Element> items;

	public Categorie(String libelle) {

		this.setLibelle(libelle);
		items=new ArrayList<Element>();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<Element> getItems(){
		
		return items;
	}
	public void addItem(Element e) {
		this.items.add(e);
	}
	public void deleteItem(int i) {
		this.items.remove(i);
	}
	

}
