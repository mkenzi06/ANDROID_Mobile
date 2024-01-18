package com.applicontact;

import java.util.ArrayList;

import com.applicontact.modele.Contacte;

import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ContactAdapter extends ArrayAdapter<Contacte> {
private Activity con;
	public ContactAdapter(Activity Context, ArrayList<Contacte> alc) {
		super(Context, R.layout.item_contact,alc);
		this.con=Context;
	}
	@Override
		public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater li=con.getLayoutInflater();
		//recuperer arbre de vue
		convertView=li.inflate(R.layout.item_contact, null);
		TextView tvnomc = (TextView) convertView.findViewById(R.id.tvnom);
		TextView tvnumc = (TextView) convertView.findViewById(R.id.tvnum);
		Contacte select= getItem(position) ;
		tvnomc.setText(select.getNom());
		tvnumc.setText(select.getNum());
			return convertView;
		}
	

}
