package com.applicontact;

import java.util.ArrayList;

import com.applicontact.modele.Contacte;
import com.applicontact.modele.ContacteBd;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class ContactActivity extends Activity implements OnClickListener,OnItemClickListener {
	ListView lv;
	Button btn;
	ArrayList<Contacte> conta;
	ContactAdapter ca;
	ContacteBd cbd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		btn=(Button) findViewById(R.id.btncontact);
		btn.setOnClickListener(this);
		lv=(ListView) findViewById(R.id.listcontact);
		lv.setOnItemClickListener(this);
		cbd=new ContacteBd(this);
		conta=new ArrayList<Contacte>();
			}
	@Override
	public void onClick(View v) {
		if(v==btn){
			Intent i = new Intent(ContactActivity.this,AjoutActivity.class);
			startActivity(i);
		}
		
		
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View arg1, int position, long arg3) {
		Intent i2=new Intent(ContactActivity.this,ModSupActivity.class);
		Contacte co=(Contacte) parent.getItemAtPosition(position);
		i2.putExtra("nomc", co.getNom());
		i2.putExtra("numc", co.getNum());
		i2.putExtra("idc", co.getId());
		startActivity(i2);
		
	}
	@Override
	protected void onResume() {
		
		
		super.onResume();
		conta=cbd.getcontacts();
//		conta.add(new Contacte(1,"kenzi", "0790068733"));
//		conta.add(new Contacte(2,"naim", "079093883"));
//		conta.add(new Contacte(3,"bachiiiiiiiir", "0790456733"));
		ca=new ContactAdapter(this, conta);
		
		lv.setAdapter(ca);

	}

	

}
