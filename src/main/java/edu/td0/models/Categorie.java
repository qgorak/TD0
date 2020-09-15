package edu.td0.models;

import java.util.ArrayList;
import java.util.List;


public class Categorie {
	private String libelle;
	List<Element> items;

	public Categorie(String libelle) {

		this.libelle=libelle;
		items=new ArrayList<Element>();
	}

	

}
