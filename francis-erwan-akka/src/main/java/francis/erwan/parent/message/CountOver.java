package francis.erwan.parent.message;

import java.util.HashMap;

public class CountOver {

	private HashMap<String, Integer> wordCounter;

	public CountOver(HashMap<String, Integer> wordCounter) {
		this.wordCounter = wordCounter;
	}

	public HashMap<String, Integer> getWordCounter() {
		return wordCounter;
	}

	public void setWordCounter(HashMap<String, Integer> wordCounter) {
		this.wordCounter = wordCounter;
	}

}
