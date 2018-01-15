package francis.erwan.parent.message;

import akka.actor.ActorRef;

public class SendLine {

	private ActorRef counter;

	public SendLine(ActorRef counter) {
		this.counter = counter;
	}

	public ActorRef getCounter() {
		return counter;
	}

	public void setCounter(ActorRef counter) {
		this.counter = counter;
	}
	
}
