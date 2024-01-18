package com.maminicalculatrice;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculActivity extends Activity implements OnClickListener {
	EditText etn1, etn2;
	Button bp, bs, bm, bd, bi;
	TextView resultat;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calcul);
		etn1 = (EditText) findViewById(R.id.etnb1);
		etn2 = (EditText) findViewById(R.id.etnb2);
		bp = (Button) findViewById(R.id.badd);
		bp.setOnClickListener(this);
		bs = (Button) findViewById(R.id.bsous);
		bs.setOnClickListener(this);
		bm = (Button) findViewById(R.id.bmul);
		bm.setOnClickListener(this);
		bd = (Button) findViewById(R.id.bdiv);
		bd.setOnClickListener(this);
		bi = (Button) findViewById(R.id.bce);
		bi.setOnClickListener(this);
		resultat = (TextView) findViewById(R.id.tvr);

	}

	@Override
	public void onClick(View v) {
		Float n1 = Float.parseFloat(etn1.getText().toString());
		Float n2 = Float.parseFloat(etn2.getText().toString());
		if (v == bp) {
			resultat.setText((n1 + n2) + "");
		}
		if (v == bs) {
			resultat.setText((n1 - n2) + "");
		}
		if (v == bm) {
			resultat.setText((n1 * n2) + "");
		}
		if (v == bd) {
			if (n2 == 0) {
				Toast.makeText(this, "erreur division par 0",
						Toast.LENGTH_SHORT).show();
			} else {
				resultat.setText((n1 / n2) + "");
			}

		}
		if (v == bi) {
			etn1.setText("");
			etn2.setText("");
			resultat.setText(".....");
		}

	}

}
