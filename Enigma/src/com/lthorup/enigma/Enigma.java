package com.lthorup.enigma;

public class Enigma {

	private final int MAX_ROTORS = 5;
	private final int MAX_REFLECTORS = 3;
	private Rotor[] rotorLibrary = new Rotor[MAX_ROTORS];
	private Rotor[] reflectorLibrary = new Rotor[MAX_REFLECTORS];
	private Rotor rotorA, rotorB, rotorC, reflector;
	
	public Enigma() {
		rotorLibrary[0] = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q', false);
		rotorLibrary[1] = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E', false);
		rotorLibrary[2] = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V', false);
		rotorLibrary[3] = new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", 'J', false);
		rotorLibrary[4] = new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", 'Z', false);
		
		reflectorLibrary[0] = new Rotor("EJMZALYXVBWFCRQUONTSPIKHGD", 0, true);
		reflectorLibrary[1] = new Rotor("YRUHQSLDPXNGOKMIEBFZCWVJAT", 0, true);
		reflectorLibrary[2] = new Rotor("FVPJIAOYEDRZXWGCTKUQSBNMHL", 0, true);
		
		configure(0, 1, 2, 0, 0, 0, 0);
	}
	
	public void configure(int a, int b, int c, int r, int offsetA, int offsetB, int offsetC) {
		rotorA = rotorLibrary[a].copy();
		rotorB = rotorLibrary[b].copy();
		rotorC = rotorLibrary[c].copy();
		reflector = reflectorLibrary[r];
		rotorA.setOffset(offsetA);
		rotorB.setOffset(offsetB);
		rotorC.setOffset(offsetC);
		rotorA.link(rotorB, null);
		rotorB.link(rotorC, rotorA);
		rotorC.link(reflector, rotorB);
		reflector.link(null, rotorC);
	}
	
	public String encode(String input) {
		String output = "";
		int cnt = 0;
		for (int i = 0; i < input.length(); i++) {
			char in = Character.toUpperCase(input.charAt(i));
			if (in >= 'A' && in <= 'Z') {
				rotorA.rotate();
				char out = rotorA.map(in);
				output += String.valueOf(out);
				cnt++;
				if ((cnt % 4) == 0)
					output += " ";
			}
		}
		return output;
	}
}
