package francis.erwan.parent;

import java.util.HashMap;

public class Finish {
	
	private static Finish INSTANCE = null;
	
	private boolean isFinish = false;
	private int counterFinished = 0;
	private HashMap<String, Integer> result = new HashMap<>();

	public Finish() {
	
	}

	public static Finish getInstance(){
		if (INSTANCE == null)
        {   INSTANCE = new Finish(); 
        }
        return INSTANCE; 
    }
	
	public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public int getCounterFinished() {
		return counterFinished;
	}

	public void setCounterFinished(int counterFinished) {
		this.counterFinished = counterFinished;
	}
	
	public void newCounterFinished(){
		this.counterFinished++;
	}

	public HashMap<String, Integer> getResult() {
		return result;
	}

	public void setResult(HashMap<String, Integer> result) {
		this.result = result;
	}
	
}
