package francis.erwan.parent.message;

import akka.actor.ActorRef;

public class Count {

	private ActorRef dispatcher;
	private String line;

	public Count(ActorRef dispatcher, String line) {
		this.dispatcher = dispatcher;
		this.line = line; 
	}

	public ActorRef getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(ActorRef dispatcher) {
		this.dispatcher = dispatcher;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

}
