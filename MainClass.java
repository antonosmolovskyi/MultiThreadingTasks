package easyJava;

public class MainClass {

	public static void main(String[] args) {
		Message message = new Message("Hi", false);
		new Player(message);
		new Echo(message);
		
		
	}

}
