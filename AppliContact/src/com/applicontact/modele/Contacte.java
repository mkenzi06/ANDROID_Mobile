package com.applicontact.modele;

public class Contacte {
	private int id;
	private String nom,num;
	public Contacte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contacte(int id, String nom, String num) {
		super();
		this.id = id;
		this.nom = nom;
		this.num = num;
	}
	public Contacte(String nom, String num) {
		super();
		this.nom = nom;
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	

}
