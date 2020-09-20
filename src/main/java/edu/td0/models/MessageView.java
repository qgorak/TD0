package edu.td0.models;


public class MessageView {
	private String message;


	public MessageView() {
	}
	public MessageView(String libelle) {

		this.setMessage(libelle);

	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	@Override

	public String toString() {
		return this.message;
	}
}