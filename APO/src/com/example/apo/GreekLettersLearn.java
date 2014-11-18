package com.example.apo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GreekLettersLearn extends Activity {
	
	GridView mGridView;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.greek_letters_learn);
		mGridView = (GridView) findViewById(R.id.gridView1);
		String[] greekData = {
			"English", "Capital", "Lower", "Name",
			"A", "Α", "α", "alpha",
			"B", "Β", "β", "beta",
			"G", "Γ", "γ", "gamma",
			"D", "Δ", "δ", "delta",
			"E", "Ε", "ε", "epsilon",
			"Z", "Ζ", "ζ", "zeta",
			"E", "Η", "η", "eta",
			"Th", "Θ", "θ", "theta",
			"I", "Ι", "ι", "iota",
			"K", "Κ", "κ", "kappa",
			"L", "Λ", "λ", "lambda",
			"M", "Μ", "μ", "mu",
			"N", "Ν", "ν", "nu",
			"X", "Ξ", "ξ", "xi",
			"O", "Ο", "ο", "omicron",
			"P", "Π", "π", "pi",
			"R", "Ρ", "ρ", "rho",
			"S", "Σ", "σ", "sigma",
			"T", "Τ", "τ", "tau",
			"U", "Υ", "υ", "upsilon",
			"Ph", "Φ", "φ", "phi",
			"Ch", "Χ", "χ", "chi",
			"Ps", "Ψ", "ψ", "psi",
			"O", "Ω", "ω", "omega"
		};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, greekData);
		    mGridView.setAdapter(adapter);
	}
	
}
