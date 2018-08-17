package com.ait.calc.Controller;

public interface CombinationsInterface {

	// permutation with repetition of numbers allowed
	public int orderedWithRepeat(int n, int r);
	// permutation WITHOUT repetition
	public int orderedWithOutRepeat(int n, int r);
	// combination with repetition of numbers allowed
	public int unOrderedWithRepeat(int n, int r);
	// combination WITHOUT repetition
	public int unOrderedWithOutRepeat(int n, int r);
}
