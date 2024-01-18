package com.applicontact;

import com.applicontact.modele.Contacte;
import com.applicontact.modele.ContacteBd;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjoutActivity extends Activity implements OnClickListener {
	EditText etnom,etnum;
	Button btnajout;
	ContacteBd cbd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ajout);
		cbd=new ContacteBd(this);
		etnom=(EditText) findViewById(R.id.etnom);
		etnum=(EditText) findViewById(R.id.etnum);
		btnajout=(Button) findViewById(R.id.btnajo);
		btnajout.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		if(v==btnajout){
			Contacte c=new Contacte(etnom.getText().toString(), etnum.getText().toString());
			cbd.insertContact(c);
			Toast.makeText(this, "ajout fait avec succes", Toast.LENGTH_SHORT).show();
		}
		
	}



}
