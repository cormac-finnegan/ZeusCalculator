package com.ait.calc.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ait.calc.controller.SetsInterface;
import com.ait.calc.model.Sets;

public class SetsTest {

	private SetsInterface sets;
	
	@Before
	public void setUp() {		
		sets = new Sets();
	}
	
	@Test
	public void testPermutationWithRepeatWhereNIsNegative() {
		int n = -3;
		int r = 2;
		if(n < 0) {
			assertEquals(sets.permutationWithRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testPermutationWithRepeatWhereNIsEqualToR() {	
		int n = 2;
		int r = 2;
		if(n >= 0) {
			if(n == r) {
				assertEquals(sets.permutationWithRepeat(n, r), 4);			
			} else {
				assertEquals(sets.permutationWithRepeat(n, r), 0);
			}
		} else {
			assertEquals(sets.permutationWithRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testPermutationWithRepeatWhereNIsGreaterThanR() {	
		int n = 3;
		int r = 2;
		if(n >=0) {
			if(n > r) {			
				assertEquals(sets.permutationWithRepeat(n, r), 9);
			} else {
				assertEquals(sets.permutationWithRepeat(n, r), 0);
			}
		} else {
			assertEquals(sets.permutationWithRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testPermutationWithRepeatWhereNIsLesserThanR() {	
		int n = 2;
		int r = 3;
		if(n >=0) {
			assertEquals(sets.permutationWithRepeat(n, r), 8);			
		} else {
			assertEquals(sets.permutationWithRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testPermutationWithoutRepeatWhereNIsNegative() {	
		int n = -3;
		int r = 2;
		if(n < 0) {
			assertEquals(sets.permutationWithOutRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testPermutationWithoutRepeatWhereNIsEqualToR() {	
		int n = 3;
		int r = 3;
		if(n >= 0) {
			if(n == r) {
				assertEquals(sets.permutationWithOutRepeat(n, r), 6);
			} else {
				assertEquals(sets.permutationWithOutRepeat(n, r), 0);
			}
		} else {
			assertEquals(sets.permutationWithOutRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testPermutationWithoutRepeatWhereNIsGreaterThanR() {	
		int n = 3;
		int r = 2;
		if(n >=0) {
			if(n > r) {			
				assertEquals(sets.permutationWithOutRepeat(n, r), 6);
			} else if(n == r) {
				assertEquals(sets.permutationWithOutRepeat(n, r), 6);
			} else {
				assertEquals(sets.permutationWithOutRepeat(n, r), 0);
			}
		} else {
			assertEquals(sets.permutationWithOutRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testPermutationWithoutRepeatWhereNIsLesserThanR() {	
		int n = 3;
		int r = 4;
		if(n >=0) {
			if(n > r) {			
				assertEquals(sets.permutationWithOutRepeat(n, r), 6);
			} else if(n == r) {
				assertEquals(sets.permutationWithOutRepeat(n, r), 6);
			} else {
				assertEquals(sets.permutationWithOutRepeat(n, r), 0);
			}
		} else {
			assertEquals(sets.permutationWithOutRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testCombinationWithRepeatWhereNIsNegative() {
		int n = -3;
		int r = 2;
		if(n < 0) {
			assertEquals(sets.combinationWithRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testCombinationWithRepeatWhereNIsEqualToR() {	
		int n = 2;
		int r = 2;
		if(n >= 0) {
			if(n == r) {
				assertEquals(sets.combinationWithRepeat(n, r), 3);			
			} else {
				assertEquals(sets.combinationWithRepeat(n, r), 0);
			}
		} else {
			assertEquals(sets.combinationWithRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testCombinationWithRepeatWhereNIsGreaterThanR() {	
		int n = 3;
		int r = 2;
		if(n >=0) {
			if(n > r) {			
				assertEquals(sets.combinationWithRepeat(n, r), 6);
			} else {
				assertEquals(sets.combinationWithRepeat(n, r), 0);
			}
		} else {
			assertEquals(sets.combinationWithRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testCombinationWithRepeatWhereNIsLesserThanR() {	
		int n = 2;
		int r = 3;
		if(n >=0) {
			assertEquals(sets.combinationWithRepeat(n, r), 4);			
		} else {
			assertEquals(sets.combinationWithRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testCombinationWithOutRepeatWhereNIsNegative() {
		int n = -3;
		int r = 2;
		if(n < 0) {
			assertEquals(sets.combinationWithOutRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testCombinationWithOutRepeatWhereNIsEqualToR() {	
		int n = 2;
		int r = 2;
		if(n >= 0) {
			if(n == r) {
				assertEquals(sets.combinationWithOutRepeat(n, r), 1);			
			} else {
				assertEquals(sets.combinationWithOutRepeat(n, r), 0);
			}
		} else {
			assertEquals(sets.combinationWithOutRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testCombinationWithOutRepeatWhereNIsGreaterThanR() {	
		int n = 3;
		int r = 2;
		if(n >=0) {
			if(n > r) {			
				assertEquals(sets.combinationWithOutRepeat(n, r), 3);
			} else {
				assertEquals(sets.combinationWithOutRepeat(n, r), 0);
			}
		} else {
			assertEquals(sets.combinationWithOutRepeat(n, r), 0);
		}
	}
	
	@Test
	public void testCombinationWithOutRepeatWhereNIsLesserThanR() {	
		int n = 2;
		int r = 3;
		if(n >=0) {
			if(n < r) {			
				assertEquals(sets.combinationWithOutRepeat(n, r), 0);
			}
		} else {
			assertEquals(sets.combinationWithOutRepeat(n, r), 0);
		}
	}

}
