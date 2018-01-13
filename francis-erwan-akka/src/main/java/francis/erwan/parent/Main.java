package francis.erwan.parent;

import java.io.File;
import java.io.IOException;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import francis.erwan.parent.actor.Dispatcher;
import francis.erwan.parent.message.Start;

public class Main {
  public static void main(String[] args) {
    final ActorSystem system = ActorSystem.create("helloakka");
    try {
      //#create-actors
     /* final ActorRef printerActor = 
        system.actorOf(Printer.props(), "printerActor");
      final ActorRef howdyGreeter = 
        system.actorOf(Greeter.props("Howdy", printerActor), "howdyGreeter");
      final ActorRef helloGreeter = 
        system.actorOf(Greeter.props("Hello", printerActor), "helloGreeter");
      final ActorRef goodDayGreeter = 
        system.actorOf(Greeter.props("Good day", printerActor), "goodDayGreeter"); */
      
      final ActorRef dispatcher = 
    	        system.actorOf(Dispatcher.props(new File(args[0])), "dispatcherActor");
      
      //#create-actors

      //#main-send-messages
     /* howdyGreeter.tell(new WhoToGreet("Akka"), ActorRef.noSender());
      howdyGreeter.tell(new Greet(), ActorRef.noSender());

      howdyGreeter.tell(new WhoToGreet("Lightbend"), ActorRef.noSender());
      howdyGreeter.tell(new Greet(), ActorRef.noSender());

      helloGreeter.tell(new WhoToGreet("Java"), ActorRef.noSender());
      helloGreeter.tell(new Greet(), ActorRef.noSender());

      goodDayGreeter.tell(new WhoToGreet("Play"), ActorRef.noSender());
      goodDayGreeter.tell(new Greet(), ActorRef.noSender()); */
      
      dispatcher.tell(new Start(), ActorRef.noSender());
      
      //#main-send-messages

      System.out.println(">>> Press ENTER to exit <<<");
      
      System.out.println(args[0]);
      
      System.in.read();
    } catch (IOException ioe) {
    } finally {
      system.terminate();
    }
  }
}
