package com.ait.calc.tests;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.ait.Database.HistoricalEquation;

public class HistoricalEquationTest {
	private final int ID = 5;
	private final String EQUATION = "2+2";
	private final String RESULT = "4";
	private final Timestamp DATE = new Timestamp(new Date().getTime());
	private String expected;
	private HistoricalEquation he;
	
	@Before
	public void setup(){
		he = new HistoricalEquation(ID, EQUATION, RESULT, DATE);
		Date formattedDate = null;
		try {
			 formattedDate  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.s").parse(DATE.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String formattedDateString = new SimpleDateFormat("E dd/MM/yy, HH:mm").format(formattedDate);
		expected =  EQUATION + " = " + RESULT+"\n"+formattedDateString+"\n\n";
	}

	@Test
	public void testConstructor() {
		assertEquals(ID, he.getId());
		assertEquals(EQUATION, he.getEquation());
		assertEquals(RESULT, he.getResult());
		assertEquals(DATE, he.getDate());
	}

	@Test
	public void testAccessorMutator() {
		he = new HistoricalEquation();
		he.setId(ID);
		he.setEquation(EQUATION);
		he.setResult(RESULT);
		he.setDate(DATE);
	
		assertEquals(ID, he.getId());
		assertEquals(EQUATION, he.getEquation());
		assertEquals(RESULT, he.getResult());
		assertEquals(DATE, he.getDate());
	}
	
	@Test
	public void testToString() {
		
		assertEquals(expected, he.toString());
	}
}
