package edu.td0.models;

import java.util.ArrayList;
import java.util.List;


public class Categorie {
	private String name;
	List<Element> items;

	public Categorie(String name) {

		this.name=name;
		items=new ArrayList<Element>();
	}

	

}
