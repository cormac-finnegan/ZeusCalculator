package com.ait.calc.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ait.Database.Formula;

public class FormulaTest {
	private final int ID = 5;
	private final String NAME = "Area of a Square";
	private final String EQUATION = "side^2";
	private final String VARIABLES = "side";
	private final String VARIABLE_NAMES = "Side Length";
	private Formula f;
	
	@Test
	public void testConstructor() {
		f = new Formula(ID, NAME, EQUATION, VARIABLES, VARIABLE_NAMES);
		assertEquals(ID, f.getId());
		assertEquals(NAME, f.getName());
		assertEquals(EQUATION, f.getEquation());
		assertEquals(VARIABLES, f.getVariables()[0]);
		assertEquals(VARIABLE_NAMES, f.getVariableNames()[0]);
	}
	
	@Test
	public void testAccesorMutator() {
		f = new Formula(-1, "", "", "", "");
		f.setId(ID);
		f.setEquation(EQUATION);
		f.setName(NAME);
		f.setVariables(new String[]{VARIABLES});
		f.setVariableNames(new String[]{VARIABLE_NAMES});
		assertEquals(ID, f.getId());
		assertEquals(NAME, f.getName());
		assertEquals(EQUATION, f.getEquation());
		assertEquals(VARIABLES, f.getVariables()[0]);
		assertEquals(VARIABLE_NAMES, f.getVariableNames()[0]);
	}
	
	@Test
	public void testToString() {
		f = new Formula(-1, NAME, "", "", "");
		assertEquals(NAME, f.toString());
	}
}
