package com.ait.calc.controller;

public interface SetsInterface {

	// permutation with repetition of numbers allowed
	public int permutationWithRepeat(int n, int r);
	// permutation WITHOUT repetition
	public int permutationWithOutRepeat(int n, int r);
	// combination with repetition of numbers allowed
	public int combinationWithRepeat(int n, int r);
	// combination WITHOUT repetition
	public int combinationWithOutRepeat(int n, int r);
	
}
