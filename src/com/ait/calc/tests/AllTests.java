package com.ait.calc.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AudioFeaturesTest.class, CalculatorTest.class,
		FormulaDaoTest.class, FormulaTest.class, HistoricalEquationTest.class,
		HistoryDaoTest.class, LogarithmicFuntionsTest.class,
		RecursionsTest.class, SetsTest.class, TrigonometricFunctionsTest.class, GraphTests.class })
public class AllTests {

}
