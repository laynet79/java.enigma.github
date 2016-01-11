package com.lthorup.enigma;

public class Rotor {

	private int[] inTable, outTable;
	private int notch;
	private int offset;
	private boolean isReflector;
	private Rotor inNext, outNext;
	
	public Rotor(String table, int notch, boolean isReflector) {
		this.inTable = new int[26];
		this.outTable = new int[26];
		for (int i = 0; i < 26; i++)
		{
			inTable[i] = charToIndex(table.charAt(i));
			outTable[inTable[i]] = i;
		}
		this.notch = notch - 'A';
		this.offset = 0;
		this.isReflector = isReflector;
		inNext = outNext = null;
	}
	
	public Rotor copy() {
		String s = "";
		for (int i = 0; i < 26; i++)
			s += String.valueOf(indexToChar(inTable[i]));
		return new Rotor(s, notch, isReflector);
	}
	
	public void link(Rotor inNext, Rotor outNext) {
		this.inNext = inNext;
		this.outNext = outNext;
	}
	
	public void setOffset(int offset) {
		this.offset = offset;
	}
	
	public void rotate() {
		if (! isReflector) {
			offset = (offset + 1) % 26;
			if (offset == notch && inNext != null)
				inNext.rotate();
		}
	}
	
	public char map(char input) {
		int indexIn = charToIndex(input);
		int outIndex = mapIn(indexIn);
		return indexToChar(outIndex);
	}
	
	public int mapIn(int input) {
		int output = inTable[(input+offset)%26];
		if (isReflector) {
			output = outNext.mapOut(output);
		}
		else if (inNext != null)
			output = inNext.mapIn(output);
		return output;
	}
	
	public int mapOut(int input) {
		int output = (outTable[input] + 26 - offset) % 26;
		if (outNext != null)
			output = outNext.mapOut(output);
		return output;
	}
		
	private int charToIndex(char c) {
		return c - 'A';
	}
	
	private char indexToChar(int index) {
		return (char)(index + 'A');
	}
	
}
