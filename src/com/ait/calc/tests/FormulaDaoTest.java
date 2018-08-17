package com.ait.calc.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ait.Database.Formula;
import com.ait.Database.FormulaDao;

public class FormulaDaoTest {
	private FormulaDao fdao;
	Formula f;
	
	@Before
	public void setup(){
		fdao = new FormulaDao();
		f = new Formula(1, "Area of a Square", "side^2", "side", "Side Length");
	}
	
	@Test
	public void testGetFormula() {
		ArrayList<Formula> formulaList = fdao.getFormula();
		Formula dbF = formulaList.get(0);
		assertEquals(f.getId(), dbF.getId());
		assertEquals(f.getEquation(), dbF.getEquation());
		assertEquals(f.getName(), dbF.getName());
	}

}
