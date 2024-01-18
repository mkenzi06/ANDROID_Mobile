package com.applicontact.modele;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ContacteBd extends SQLiteOpenHelper{
	String creersql="CREATE TABLE contact (id integer primary key AUTOINCREMENT," +
			"nom text(30),numero text(20))";
	String sup="DROP TABLE contact IF EXISTS";
	//constructeur permet de creer la base de donnee interne
	public ContacteBd(Context context) {
		super(context, "contacteBD",null , 1);
	}
	//methode de creation de schema de la bd
	@Override
	public void onCreate(SQLiteDatabase bdd) {
		bdd.execSQL(creersql);
	}
	//mettre a jour la base de donnees
	@Override
	public void onUpgrade(SQLiteDatabase bdd, int oldversion, int newversion) {
		bdd.execSQL(sup);
		this.onCreate(bdd);
	}
	//creer la methode d'ajout dans la base de donnee
	public void insertContact(Contacte c) {
		//pour preciser le mode 
		SQLiteDatabase sdb = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("nom", c.getNom());
		values.put("numero",c.getNum());
		sdb.insert("contact", null, values);
	}
	//methode de recuperation de tous les contacts 
	public ArrayList<Contacte> getcontacts() {
		SQLiteDatabase sdb=this.getReadableDatabase();
		ArrayList<Contacte> alc= new ArrayList<Contacte>();
		Cursor cu=sdb.rawQuery("select * from contact", null);
		if(cu.moveToFirst()){
			do {
				Contacte c=new Contacte(cu.getInt(0), cu.getString(1), cu.getString(2));
				alc.add(c);
			} while (cu.moveToNext());
		}
		
		return alc;
		
		
	}
	public void supp(int id){
		SQLiteDatabase sdb=this.getWritableDatabase();
		sdb.delete("contact","id="+id, null);
	}
	public void modifier(Contacte c) {
		SQLiteDatabase sdb=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put("nom", c.getNom());
		values.put("numero",c.getNum());
		sdb.update("contact",values , "id="+c.getId(), null);
	}

}
