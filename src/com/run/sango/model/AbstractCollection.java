package com.run.sango.model;

import java.util.Arrays;

public class AbstractCollection implements Collection {
	
	private final int[] array;
	
	public AbstractCollection(int maxSize) {
		array = new int[maxSize];
		Arrays.fill(array, 0);
	}
	
	@Override
	public int getTotal() {
		int t = 0;
		for (int n: array) {
			t += n;
		}
		return t;
	}
	
	@Override
	public void set(int index, int amount) {
		array[index] = amount;
	}
	
	@Override
	public int get(int index) {
		return array[index];
	}
}
