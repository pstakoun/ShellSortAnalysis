package com.stakoun.shellsortanalysis;

import com.stakoun.shellsortanalysis.Main.Sequence;

public class SequenceGenerator
{
	public int[] genSequence(Sequence sequence, int N)
	{
		switch (sequence)
		{
		case CIURA: return genCiuraSequence(N);
		case FRANK_LAZARUS: return genFrankLazarusSequence(N);
		case HIBBARD: return genHibbardSequence(N);
		case KNUTH: return genKnuthSequence(N);
		case SEDGEWICK: return genSedgewickSequence(N);
		case SHELL: return genShellSequence(N);
		case TOKUDA: return genTokudaSequence(N);
		default: return new int[0];
		}
	}
	
	public int[] genCiuraSequence(int N)
	{
		int[] ciura = new int[] {1, 4, 10, 23, 57, 132, 301, 701, 1750};
		
		// Get length of sequence
		int gap;
		int k = 0;
		do {
			gap = ciura[k++];
		} while (k < ciura.length && ciura[k] < N);
		
		// Create sequence
		int[] res = new int[k];
		k = 0;
		do {
			gap = ciura[k];
			res[k++] = gap;
		} while (k < ciura.length && ciura[k] < N);
		return reverse(res);
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
	
	public int[] genHibbardSequence(int N)
	{
		// Get length of sequence
		int gap;
		int k = 1;
		do {
			gap = pow(2, k++) - 1;
		} while (gap < N/2);
		
		// Create sequence
		int[] res = new int[k-1];
		k = 1;
		do {
			gap = pow(2, k) - 1;
			res[k++-1] = gap;
		} while (gap < N/2);
		return reverse(res);
	}
	
	public int[] genKnuthSequence(int N)
	{
		// Get length of sequence
		int gap;
		int k = 1;
		do {
			gap = (pow(3, k++) - 1) / 2;
		} while (gap < N);
		
		// Create sequence
		int[] res = new int[k-1];
		k = 1;
		do {
			gap = (pow(3, k) - 1) / 2;
			res[k++-1] = gap;
		} while (gap < N);
		return reverse(res);
	}
	
	public int[] genSedgewickSequence(int N)
	{
		// Get length of sequence
		int gap;
		int k = 1;
		do {
			gap = pow(4, k) + 3 * pow(2, k++-1) + 1;
		} while (gap < N);
		
		// Create sequence
		int[] res = new int[k-1];
		k = 1;
		do {
			gap = pow(4, k) + 3 * pow(2, k-1) + 1;
			res[k++-1] = gap;
		} while (gap < N);
		return reverse(res);
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
	
	public int[] genTokudaSequence(int N)
	{
		// Get length of sequence
		int gap;
		int k = 1;
		do {
			gap = ceil((double)(pow(9l, k) - pow(4l, k)) / (double)(5 * pow(4l, k++-1)));
		} while (gap < N);
		// Create sequence
		int[] res = new int[k-1];
		k = 1;
		do {
			gap = ceil((double)(pow(9l, k) - pow(4l, k)) / (double)(5 * pow(4l, k-1)));
			res[k++-1] = gap;
		} while (gap < N);
		return reverse(res);
	}
	
	public int pow(int base, int exp)
	{
		int res = 1;
		for (int i = 0; i < exp; i++)
			res *= base;
		return res;
	}
	
	public long pow(long base, int exp)
	{
		long res = 1;
		for (int i = 0; i < exp; i++)
			res *= base;
		return res;
	}
	
	public int ceil(double d)
	{
		if (d - (int)d > 0.00001)
			return (int)d + 1;
		return (int)d;
	}
	
	public int[] reverse(int[] arr)
	{
		int len = arr.length;
		int[] newArr = new int[len];
		for (int i = 0; i < len; i++)
			newArr[i] = arr[len-i-1];
		return newArr;
	}

}
