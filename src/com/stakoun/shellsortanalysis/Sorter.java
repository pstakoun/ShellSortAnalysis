package com.stakoun.shellsortanalysis;

public class Sorter
{
	private int[] sequence;
	
	public long sort(int[] array)
	{
		long start = System.currentTimeMillis();
		for (int gap : sequence) {
			for (int i = gap; i < array.length; i++) {
	            int val = array[i];
	            int j;
	            for (j = i; j >= gap && array[j - gap] > val; j -= gap) {
	                array[j] = array[j - gap];
	            }
	            array[j] = val;
	        }
		}
		return System.currentTimeMillis() - start;
	}
	
	public void setSequence(int[] sequence) {
		this.sequence = sequence;
	}
	
}
