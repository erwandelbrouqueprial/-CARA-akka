package francis.erwan.parent.actor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import francis.erwan.parent.message.Start;

public class Dispatcher extends AbstractActor {

	private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
	private File textFile;

	public Dispatcher(File textFile) {
		this.textFile = textFile;
	}

	static public Props props(File textFile) {
		return Props.create(Dispatcher.class, () -> new Dispatcher(textFile));
	}

	@Override
	public Receive createReceive() {
		// TODO Le message quand un fils a finis pour récupérer le comptage
		return receiveBuilder().match(Start.class, start -> {
			this.startDispatch();
		}).build();
	}

	private void startDispatch() {
		log.info("Starting dispatch");

		try (BufferedReader buffer = new BufferedReader(new FileReader(this.textFile))) {
			String line;
			while ((line = buffer.readLine()) != null) {
				//log.info("line : " + line);
				// TODO Envoi au fils de la ligne
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
