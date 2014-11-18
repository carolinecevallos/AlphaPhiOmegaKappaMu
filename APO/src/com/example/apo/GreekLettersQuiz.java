package com.example.apo;

import android.os.Bundle;

public class GreekLettersQuiz extends SimpleQuiz {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void createQuestions() {
		Question[] questions = {
			new Question("Α", "alpha"),
			new Question("Β", "beta"),
			new Question("Γ", "gamma"),
			new Question("Δ", "delta"),
			new Question("Ε", "epsilon"),
			new Question("Ζ", "zeta"),
			new Question("Η", "eta"),
			new Question("Θ", "theta"),
			new Question("Ι", "iota"),
			new Question("Κ", "kappa"),
			new Question("Λ", "lambda"),
			new Question("Μ", "mu"),
			new Question("Ν", "nu"),
			new Question("Ξ", "xi"),
			new Question("Ο", "omicron"),
			new Question("Π", "pi"),
			new Question("Ρ", "rho"),
			new Question("Σ", "sigma"),
			new Question("Τ", "tau"),
			new Question("Υ", "upsilon"),
			new Question("Φ", "phi"),
			new Question("Χ", "chi"),
			new Question("Ψ", "psi"),
			new Question("Ω", "omega"),
			
			new Question("α", "alpha"),
			new Question("β", "beta"),
			new Question("γ", "gamma"),
			new Question("δ", "delta"),
			new Question("ε", "epsilon"),
			new Question("ζ", "zeta"),
			new Question("η", "eta"),
			new Question("θ", "theta"),
			new Question("ι", "iota"),
			new Question("κ", "kappa"),
			new Question("λ", "lambda"),
			new Question("μ", "mu"),
			new Question("ν", "nu"),
			new Question("ξ", "xi"),
			new Question("ο", "omicron"),
			new Question("π", "pi"),
			new Question("ρ", "rho"),
			new Question("σ", "sigma"),
			new Question("τ", "tau"),
			new Question("υ", "upsilon"),
			new Question("φ", "phi"),
			new Question("χ", "chi"),
			new Question("ψ", "psi"),
			new Question("ω", "omega")
		};
		
		for (int i = 0; i < questions.length; i++) {
			quesList.add(questions[i]);
		}

	}
	
}
