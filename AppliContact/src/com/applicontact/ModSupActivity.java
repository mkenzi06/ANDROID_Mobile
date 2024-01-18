package com.applicontact;

import com.applicontact.modele.Contacte;
import com.applicontact.modele.ContacteBd;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ModSupActivity extends Activity implements OnClickListener{
	ImageButton bs,bm;
	EditText et1,et2;
	Intent i;
	ContacteBd cbd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mod_sup);
		et1=(EditText) findViewById(R.id.etnewnom);
		et2=(EditText) findViewById(R.id.etnumnew);
		bs=(ImageButton) findViewById(R.id.insup);
		bs.setOnClickListener(this);
		bm=(ImageButton) findViewById(R.id.immod);
		bm.setOnClickListener(this);
		i=getIntent();
		et1.setText(i.getStringExtra("nomc"));
		et2.setText(i.getStringExtra("numc"));
		cbd=new ContacteBd(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==bs){
			cbd.supp(i.getIntExtra("idc", 0));
			Toast.makeText(this, "supression avec succes", Toast.LENGTH_SHORT).show();
		}
		if(v==bm){
			cbd.modifier(new Contacte(i.getIntExtra("idc", 0), et1.getText().toString(), et2.getText().toString()));
			Toast.makeText(this, "modification avec succes", Toast.LENGTH_SHORT).show();
		}
	}


}
