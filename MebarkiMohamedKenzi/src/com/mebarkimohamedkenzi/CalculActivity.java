package com.mebarkimohamedkenzi;

import java.text.DecimalFormat;

import com.example.mebarkimohamedkenzi.R;
import com.example.mebarkimohamedkenzi.R.layout;
import com.example.mebarkimohamedkenzi.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculActivity extends Activity implements OnClickListener {
	EditText etpoids,ettaille;
	Button bcalc;
	TextView tvimc,tvc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calcul);
		etpoids=(EditText) findViewById(R.id.etp);
		ettaille = (EditText) findViewById(R.id.ett);
		tvimc=(TextView) findViewById(R.id.tvimc);
		tvc=(TextView) findViewById(R.id.tvcat);
		bcalc=(Button) findViewById(R.id.bc);
		bcalc.setOnClickListener(this);
		
		
	}
	@Override
	public void onClick(View v) {
		if (v==bcalc) {
			DecimalFormat decimalFormat = new DecimalFormat("#.##");
			float imc=Float.parseFloat((etpoids.getText().toString()))
					/ (Float.parseFloat(ettaille.getText().toString()) * Float.parseFloat(ettaille
							.getText().toString()));
			String formattedNumber = decimalFormat.format(imc);
			tvimc.setText(formattedNumber);
			
		
		float f=Float.parseFloat(formattedNumber);
		if (f < 18.5) {
			tvc.setText("Maigreur");
		}
		if(f>=18.5 && f<=25){
			tvc.setText("Normale");
		}
		if(f>=25 && f<=30){
			tvc.setText("Surpoids");
		}
		if(f>=30 && f<=35){
			tvc.setText("Obesite moderee");
		}
		if(f>=35 && f<=40){
			tvc.setText("Obesite severe");
		}
		if(f>40){
			tvc.setText("Obesite Morbide");
		}
		}
		
	}

	
}
