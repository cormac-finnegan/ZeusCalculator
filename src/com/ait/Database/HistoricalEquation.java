package com.ait.Database;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoricalEquation {
	private int id;
	private String equation;
	private String result;
	private Timestamp date;
	
	public HistoricalEquation(int id, String equation, String result, Timestamp date) {
		super();
		this.id = id;
		this.equation = equation;
		this.result = result;
		this.date = date;
	}

	
	public HistoricalEquation() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEquation() {
		return equation;
	}

	public void setEquation(String equation) {
		this.equation = equation;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}


	@Override
	public String toString() {
		Date formattedDate = null;
		try {
			 formattedDate  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.s").parse(date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String formattedDateString = new SimpleDateFormat("E dd/MM/yy, HH:mm").format(formattedDate);
		return equation + " = " + result+"\n"+formattedDateString+"\n\n";
	}
	
	
}
