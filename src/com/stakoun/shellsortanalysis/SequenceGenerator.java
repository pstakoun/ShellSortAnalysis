package com.stakoun.shellsortanalysis;

import com.stakoun.shellsortanalysis.Main.Sequence;

public class SequenceGenerator
{
	public int[] genSequence(Sequence sequence, int N)
	{
		switch (sequence)
		{
		case SHELL_1959: return genShellSequence(N);
		case FRANK_LAZARUS_1960: return genFrankLazarusSequence(N);
		default: return null;
		}
	}
	
	public int[] genShellSequence(int N)
	{
		// Get length of sequence
		int gap;
		int k = 1;
		do {
			gap = N / pow(2, k++);
		} while (gap > 1);
		
		// Create sequence
		int[] res = new int[k-1];
		k = 1;
		do {
			gap = N / pow(2, k);
			res[k++-1] = gap;
		} while (gap > 1);
		return res;
	}

	public int[] genFrankLazarusSequence(int N)
	{
		// Get length of sequence
		int gap;
		int k = 1;
		do {
			gap = 2 * (N / pow(2, k+++1)) + 1;
		} while (gap > 1);
		
		// Create sequence
		int[] res = new int[k-1];
		k = 1;
		do {
			gap = 2 * (N / pow(2, k+1)) + 1;
			res[k++-1] = gap;
		} while (gap > 1);
		return res;
	}
	
	public int pow(int base, int exp)
	{
		int res = 1;
		for (int i = 0; i < exp; i++)
			res *= base;
		return res;
	}

}
