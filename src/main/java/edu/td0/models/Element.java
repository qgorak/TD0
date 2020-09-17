package edu.td0.models;



public class Element extends Object{
	private String nom;
	private int evaluation;


	
	public Element(String nom) {
		this.nom=nom;

	}
	
	public String getNom()	{
		return this.nom;
	}
	public void setNom(String nom)	{
		this.nom=nom;
	}



	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public void incEvaluation() {
		if (this.evaluation!=10) {
		this.evaluation = this.evaluation+1;
		}
	}
	public void decEvaluation() {
		if (this.evaluation!=0) {
		this.evaluation = this.evaluation-1;
		}
	}
	@Override
	public boolean equals(Object obj) {
		return true;
	}
	public String toString() {
		return this.nom;
	}
	
	
	
}

