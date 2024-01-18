package com.mebarkimohamedkenzi;

import com.example.mebarkimohamedkenzi.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button b1,b2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button) findViewById(R.id.btncalculer);
		b1.setOnClickListener(this);
		b2=(Button) findViewById(R.id.btncateg);
		b2.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==b1){
			Intent i1=new Intent(this, CalculActivity.class);
			startActivity(i1);
		}
		if(v==b2){
			Intent i2=new Intent(this, CategorieActivity.class);
			startActivity(i2);
		}
		
	}

	

}
