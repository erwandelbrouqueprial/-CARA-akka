/**
 * 
 */
package francis.erwan.parent.counter;

import java.util.HashMap;

/**
 * @author erwan
 *
 */
public class Counter {

	/**
	 * HashMap ou la cl� et une lettre, et la valeur son nombre d'occurences dans le texte
	 */
	private HashMap<Character, Integer> counterChar = new HashMap<>();
	/**
	 * HashMap ou la cl� et un mot, et la valeur son nombre d'occurences dans le texte
	 */
	private HashMap<String, Integer> counterWords = new HashMap<>();

	public Counter() {
	}
	
	public HashMap<Character,Integer> charCounter(final String texte){
		for (Character c : texte.toCharArray()) {
			if (!counterChar.containsKey(c)) {
				counterChar.put(c, 1);
			} else {
				counterChar.put(c, counterChar.get(c) + 1);
			}
		}

		return counterChar;
	}
	
	public HashMap<String,Integer> wordCounter(final String texte){
		String[] words = texte.split(" ");
		for (String c : words) {
			if (!counterWords.containsKey(c)) {
				counterWords.put(c, 1);
			} else {
				counterWords.put(c, counterWords.get(c) + 1);
			}
		}

		return counterWords;
	}
	
	

	/**
	 * @return the counterWords
	 */
	public HashMap<String, Integer> getCounterWords() {
		return counterWords;
	}

	/**
	 * @param counterWords the counterWords to set
	 */
	public void setCounterWords(HashMap<String, Integer> counterWords) {
		this.counterWords = counterWords;
	}

	/**
	 * @return the counterLetter
	 */
	public HashMap<Character, Integer> getCounterLetter() {
		return counterChar;
	}

	/**
	 * @param counterLetter
	 *            the counterLetter to set
	 */
	public void setCounterLetter(HashMap<Character, Integer> counterLetter) {
		this.counterChar = counterLetter;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Counter [counterChar=" + counterChar + ", counterWords=" + counterWords + "]";
	}

}
