package francis.erwan.parent.message;

import java.util.HashMap;

public class Start {
	/**
	 * HashMap ou la clé et une lettre, et la valeur son nombre d'occurences dans le
	 * texte
	 */
	private HashMap<Character, Integer> counterChar;
	/**
	 * HashMap ou la clé et un mot, et la valeur son nombre d'occurences dans le
	 * texte
	 */
	private HashMap<String, Integer> counterWords;

	public Start() {
		this.counterChar = new HashMap<>();
		this.counterWords = new HashMap<>();
	}

	/**
	 * @param counterChar
	 * @param counterWords
	 */
	public Start(HashMap<Character, Integer> counterChar, HashMap<String, Integer> counterWords) {
		super();
		this.counterChar = counterChar;
		this.counterWords = counterWords;
	}

	/**
	 * @return the counterChar
	 */
	public HashMap<Character, Integer> getCounterChar() {
		return counterChar;
	}

	/**
	 * @param counterChar
	 *            the counterChar to set
	 */
	public void setCounterChar(HashMap<Character, Integer> counterChar) {
		this.counterChar = counterChar;
	}

	/**
	 * @return the counterWords
	 */
	public HashMap<String, Integer> getCounterWords() {
		return counterWords;
	}

	/**
	 * @param counterWords
	 *            the counterWords to set
	 */
	public void setCounterWords(HashMap<String, Integer> counterWords) {
		this.counterWords = counterWords;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Start [counterChar=" + counterChar + ", counterWords=" + counterWords + "]";
	}

}
