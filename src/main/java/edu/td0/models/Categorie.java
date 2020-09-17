package edu.td0.models;

import java.util.ArrayList;
import java.util.List;


public class Categorie {
	private String libelle;
	private boolean active;
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
	public Element getItem(String name) {
		int index=items.indexOf(new Element(name));
		if(index!=-1) {
			return items.get(index);
		}
		return null;
	}
	public void deleteItem(int i) {
		this.items.remove(i);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

}
