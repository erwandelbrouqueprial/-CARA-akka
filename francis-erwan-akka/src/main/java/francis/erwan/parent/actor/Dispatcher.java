package francis.erwan.parent.actor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import francis.erwan.parent.Finish;
import francis.erwan.parent.message.Count;
import francis.erwan.parent.message.CountOver;
import francis.erwan.parent.message.SendLine;
import francis.erwan.parent.message.Start;

public class Dispatcher extends AbstractActor {

	private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
	private HashMap<String, Integer> result = new HashMap<>();
	private File textFile;
	private int lineIndex;

	private ArrayList<String> allLines = new ArrayList<>();
	private ActorRef dispatcher;

	public Dispatcher(File textFile) {
		this.textFile = textFile;
		this.lineIndex = 0;
	}

	static public Props props(File textFile) {
		return Props.create(Dispatcher.class, () -> new Dispatcher(textFile));
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder().match(Start.class, start -> {
			this.startDispatch(start.getDispatcher());
		}).match(CountOver.class, countOver -> {
			this.startCounting(countOver.getWordCounter());
		}).match(SendLine.class, sendLine -> {
			if(lineIndex != this.allLines.size()) {
				sendLine.getCounter().tell(new Count(this.dispatcher, this.allLines.get(lineIndex)), ActorRef.noSender());
				lineIndex++;
			}
			else {
				Finish.getInstance().newCounterFinished();
				Finish.getInstance().setResult(this.result);
			}

		}).build();
	}

	private void startDispatch(ActorRef dispatcher) {

		this.dispatcher = dispatcher;

		try (BufferedReader buffer = new BufferedReader(new FileReader(this.textFile))) {
			String line;
			while ((line = buffer.readLine()) != null) {
				allLines.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void startCounting(HashMap<String, Integer> counted) {
		Iterator<Entry<String, Integer>> it = counted.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Integer> pair = (Entry<String, Integer>) it.next();

			if (!result.containsKey(pair.getKey())) {
				result.put(pair.getKey(), pair.getValue());
				log.info("Nouveau mot : " + pair.getKey());
			} else {
				int newVal = result.get(pair.getKey()) + pair.getValue();
				result.put(pair.getKey(), newVal);
				log.info("Compté pour le mot " + pair.getKey() + " : " + newVal);

			}

		}

	}

}
