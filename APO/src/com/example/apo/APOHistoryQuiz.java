package com.example.apo;

import android.os.Bundle;

public class APOHistoryQuiz extends SimpleQuiz {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	

	public void createQuestions() {
		Question[] questions = {
				new Question("Who founded APO? (Three words)", "Frank Reed Horton"),
				new Question("Who was the second president (Three words)", "H. Roe Bartle"),
				new Question("What was the second president's nickname? (Two words)", "The Chief"),
				new Question("What month was APO founded?", "December"),
				new Question("What year was APO founded?", "1925"),
				new Question("At which school was APO founded? (Two words)", "Lafayette College"),
				new Question("In what building was APO founded? (Two words)", "Brainerd Hall"),
				new Question("On what floor of the founding building was APO founded? (Full word)", "Second"),
				new Question("In what city was APO founded?", "Easton"),
				new Question("In which state was APO founded? (Initials)", "PA"),
				new Question("In what year were women allowed to join APO?", "1976"),
				new Question("What are the cardinal principles of APO? (Three, include commas)", "Leadership, Friendship, Service"),
				new Question("What is the national tree?", "Oak"),
				new Question("What are the national colors? (Two colors, five words)", "Royal Blue and Old Gold"),
				new Question("What is the national jewel?", "Diamond"),
				new Question("What is the national flower?", "Forget-Me-Not"),
				new Question("What is the national bird? (Two words)", "Golden Eagle"),
				new Question("In which city is the national office?", "Independence"),
				new Question("In which state is the national office? (Initials)", "MO"),
				new Question("What is the motto?", "Be a leader, be a friend, be of service"),
				new Question("What are the four fields of service? (In given order)", "College, Community, Fraternity, Nation"),
				new Question("Where is the international location in North America?", "Canada"),
				new Question("Where is the international location in Oceania", "Australia"),
				new Question("Where is the international location in the Pacific?", "Philippines"),
		};
		
		for (int i = 0; i < questions.length; i++) {
			quesList.add(questions[i]);
		}

	}

}
