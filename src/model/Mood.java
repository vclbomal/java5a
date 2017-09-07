package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mood {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private int mood = 3;
	private String month;
	private int year;
	private String comment= null;
	private boolean freetopublic = false;
	
	public Mood() {
	}
	
	public Mood(int mood, String month, int year, String comment, boolean freetopublic) {
		super();
		this.setMood(mood);
		this.setMonth(month);
		this.setYear(year);
		this.setComment(comment);
		this.setFreetopublic(freetopublic);
		}

	public int getMood() {
		return mood;
	}

	public void setMood(int mood) {
		this.mood = mood;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isFreetopublic() {
		return freetopublic;
	}

	public void setFreetopublic(boolean freetopublic) {
		this.freetopublic = freetopublic;
	}
	
}
