package com.stakoun.shellsortanalysis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main
{
	public static enum Sequence {
		CIURA,
		FRANK_LAZARUS,
		HIBBARD,
		KNUTH,
		SEDGEWICK,
		SHELL,
		TOKUDA
	}
	
	private static final String file = "results.csv";
	private static final float trials = 10f;
	private static final int maxN = 500000;
	private static final int inc = 1000;
	private static final Sequence[] sequences = Sequence.values();
	private static final int numSequences = sequences.length;
	
	private static FileWriter writer;
	private static Sorter sorter;
	private static SequenceGenerator sequenceGenerator;
	private static Random random;
	private static Sequence sequence;
	private static double[][] times;
	
	public static void main(String[] args) throws IOException
	{
		writer = new FileWriter(file);
		sorter = new Sorter();
		sequenceGenerator = new SequenceGenerator();
		random = new Random();
		times = new double[maxN/inc+1][numSequences+1];
		
		for (int i = 0; i < maxN/inc+1; i++)
			times[i][0] = i*inc;

		for (int i = 1; i < numSequences+1; i++) {
			sequence = sequences[i-1];
			for (int N = 0; N <= maxN; N += inc) {
				sorter.setSequence(sequenceGenerator.genSequence(sequence, N));
				long total = 0;
				for (int t = 0; t < trials; t++) {
					total += sorter.sort(getRandomArray(N));
				}
				double avg = total / trials;
				times[N/inc][i] = avg;
				System.out.println(sequence.name()+"; "+N+"; "+avg);
			}
		}
		
		for (int i = 0; i < maxN/inc+1; i++) {
			for (int j = 0; j < numSequences+1; j++)
				writer.append(times[i][j]+",");
			writer.append("\n");
		}
		
		writer.flush();
		writer.close();
	}
	
	public static int[] getRandomArray(int N)
	{
		int[] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = getRandom(N);
		}
		return array;
	}
	
	public static int getRandom(int N) {
		return random.nextInt(N);
	}
	
}
