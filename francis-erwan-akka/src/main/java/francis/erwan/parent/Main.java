package francis.erwan.parent;

import java.io.File;
import java.io.IOException;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import francis.erwan.parent.actor.Counter;
import francis.erwan.parent.actor.Dispatcher;
import francis.erwan.parent.message.SendLine;
import francis.erwan.parent.message.Start;

public class Main {
	public static void main(String[] args) {
		final ActorSystem system = ActorSystem.create("helloakka");
		try {

			final ActorRef dispatcher = system.actorOf(Dispatcher.props(new File(args[0])), "dispatcherActor");

			final ActorRef counter1 = system.actorOf(Counter.props(dispatcher), "counter1Actor");
			final ActorRef counter2 = system.actorOf(Counter.props(dispatcher), "counter2Actor");
			final ActorRef counter3 = system.actorOf(Counter.props(dispatcher), "counter3Actor");

			dispatcher.tell(new Start(dispatcher), ActorRef.noSender());

			while (!Finish.getInstance().isFinish()) {
				dispatcher.tell(new SendLine(counter1), ActorRef.noSender());
				dispatcher.tell(new SendLine(counter2), ActorRef.noSender());
				dispatcher.tell(new SendLine(counter3), ActorRef.noSender());

				if (Finish.getInstance().getCounterFinished() == 3) { // nb de compteur
					Finish.getInstance().setFinish(true);
				}
			}

			System.in.read();
		} catch (IOException ioe) {
		} finally {
			system.terminate();
		}
	}
}
