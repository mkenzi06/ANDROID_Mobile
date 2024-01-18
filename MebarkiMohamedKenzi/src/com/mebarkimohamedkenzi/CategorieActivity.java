package com.mebarkimohamedkenzi;

import java.util.Vector;

import com.example.mebarkimohamedkenzi.R;
import com.example.mebarkimohamedkenzi.R.layout;
import com.example.mebarkimohamedkenzi.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CategorieActivity extends Activity {
	ListView lv1, lv2;
	String mod[] = { "Moins de 18.5", "18.5 a 25", "25 a 30", "30 a 35",
			"35 a 40", "plus de 40" };
	String mod2[] = { "Maigreur", "Normale", "surpoids", "obesite moderee",
			"obesite severe", "obesite Morbide" };
	Vector<String> v1,v2;
	ArrayAdapter<String> adap1,adap2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categorie);
		lv1=(ListView) findViewById(R.id.listmoy);
		lv2=(ListView) findViewById(R.id.listremarque);
		v1 = new Vector<String>(); 
		v2 = new Vector<String>();
		for (int i = 0; i < mod.length; i++) {
			v1.addElement(mod[i]);
			v2.addElement(mod2[i]);
		}
		adap1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, v1);
		lv1.setAdapter(adap1);
		adap2=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, v2);
		lv2.setAdapter(adap2);
		
	}

}
