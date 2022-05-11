package easyJava;

public class Message {

	private String message;
	private boolean sent;

	public Message(String message, boolean sent) {
		this.message = message;
		this.sent = sent;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSent() {
		return sent;
	}

	public void setSent(boolean sent) {
		this.sent = sent;
	}

	public synchronized void say(String message) {
		try {
			while (isSent()) {
				wait();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}

		this.setMessage(message);
		this.setSent(true);
		System.out.println("Delivered : " + this.getMessage());
		notify();
	}

	public synchronized void reply() {
		try {
			while (isSent() == false) {
				wait();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Took : " + this.getMessage());
		this.setSent(false);
		notify();
	}

}
