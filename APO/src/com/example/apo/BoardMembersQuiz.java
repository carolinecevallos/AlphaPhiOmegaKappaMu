package com.example.apo;

import android.os.Bundle;

public class BoardMembersQuiz extends SimpleQuiz {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void createQuestions() {
		Question[] questions = {
			new Question("President", "Rebecca Wilson"),
			new Question("Service (Beginning with S)", "Stephen Jenkins"),
			new Question("Service (Beginning with P)", "Philippe Rameau"),
			new Question("Service (Beginning with K)", "Kayla Dickerman"),
			new Question("Membership", "Harry Ngai"),
			new Question("Fellowship (Beginning with W)", "Wei-Shi Lin"),
			new Question("Fellowship (Beginning with D)", "David Hudak"),
			new Question("Pledgemaster (Beginning with K)", "Kivilcim Gunay"),
			new Question("Pledgemaster (Beginning with S)", "Stephanie Huie"),
			new Question("Treasurer", "Carissa Zukowski"),
			new Question("Secretary", "Caitlin McDonald"),
			new Question("Sergeant at Arms", "Maggie Weese"),
			new Question("What is the prefix to all board members' email address? (punctuation)", "jhu.apo."),
			new Question("Which board position organizes penny wars and big/little pairings?", "Sergeant at Arms"),
			new Question("Which board position organizes the assassins game?", "Membership")
		};
			
		for (int i = 0; i < questions.length; i++) {
			quesList.add(questions[i]);
		}
		
	}
	
}
