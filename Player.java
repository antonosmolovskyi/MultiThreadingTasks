package easyJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player implements Runnable {

	Message message;
	List<String> list = Arrays.asList("Hello", "Whats up", "Ma booooy", "Java is cool");

	public Player(Message message) {
		this.message = message;
		new Thread(this, "Player").start();
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public void run() {
		while (true) {
			int random = (int) (Math.random() * list.size());
			message.say(list.get(random));
			
		}
	}

}
