package com.example.apo;

public class Question {

	private int ID;
	private String QUESTION;
	private String ANSWER;
	
	public Question() {
		ID = 0;
		QUESTION = "";
		ANSWER = "";
	}
	
	public Question(String q, String ans) {
		QUESTION = q;
		ANSWER = ans;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getQuestion() {
		return QUESTION;
	}
	
	public String getAnswer() {
		return ANSWER;
	}
	
	public void setID(int id) {
		ID = id;
	}
	
	public void setQUESTION(String qUESTION) {
		QUESTION = qUESTION;
	}
	
	public void setANSWER(String aNSWER) {
		ANSWER = aNSWER;
	}
	
}
