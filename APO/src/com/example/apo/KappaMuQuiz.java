package com.example.apo;

import android.os.Bundle;

public class KappaMuQuiz extends SimpleQuiz {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void createQuestions() {
		Question[] questions = {
				new Question("What is our Region (Roman numerals)", "III"),
				new Question("What is our Section number?", "86"),
				new Question("What is our chapter name?", "Kappa Mu"),
				new Question("What is your pledge class's Greek name?", "Alpha Iota"),
				new Question("What year was our chapter originally chartered?", "1952"),
				new Question("What year was our chapter re-chartered?", "1998"),
				new Question("Name the school in our Section that begins with the letter U: (Initials)", "UMBC"),
				new Question("Name the school in our Section that begins with the letter M: (Two words)", "McDaniel College"),
				new Question("Name the school in our Section that begins with the letter F: (Three words)", "Frostburg State University"),
				new Question("Name the school in our Section that begins with the letter T: (Two words)", "Towson University"),
				new Question("On what type of years are national conventions held?", "Even"),
				new Question("On what type of years are regional conventions held?", "Odd"),
				new Question("What season are sectional conventions held?", "Spring"),
				new Question("What does NIB stand for?", "Newly Initiated Brother"),
				new Question("What does CAPS stand for?", "Chapter Assessment Planning Session"),
				new Question("What does DSK stand for?", "Distinguished Service Key"),
				new Question("What does LEADS stand for?", "Launch, Explore, Achieve, Discover, Serve"),
				new Question("Who is the national president?", "Mark Stratton"),
				new Question("Who is the region director?", "Megan Sheedfar"),
				new Question("Who is the section chair?", "Dave Bykowski")
		};
		
		for (int i = 0; i < questions.length; i++) {
			quesList.add(questions[i]);
		}
		
	}
}
