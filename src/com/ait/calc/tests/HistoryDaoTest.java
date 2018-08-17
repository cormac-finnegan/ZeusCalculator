package com.ait.calc.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ait.Database.Formula;
import com.ait.Database.FormulaDao;
import com.ait.Database.HistoricalEquation;
import com.ait.Database.HistoryDao;

public class HistoryDaoTest {
	private HistoryDao hdao;
	HistoricalEquation he;
	
	@Before
	public void setup(){
		hdao = new HistoryDao();
	}
	
	@Test
	public void testEquations() {
		String equation = "2+2";
		String answer = "4";
		
		hdao.addEquation("2+2", "4");
		ArrayList<HistoricalEquation> historyList = hdao.getEquations();
		he = historyList.get(historyList.size()-1);
		assertEquals(equation, he.getEquation());
		assertEquals(answer, he.getResult());
	}


}
