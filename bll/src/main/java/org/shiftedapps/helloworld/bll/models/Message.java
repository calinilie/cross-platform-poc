package org.shiftedapps.helloworld.bll.models;

public class Message {

	private long id;
	private String author;
	private String message;
	private String receivedTimestamp;
	private long repliesTo;

	public Message(){
	}
	
	public Message(long id, String author, String message,
			String receivedTimestamp) {
		this.id = id;
		this.author = author;
		this.message = message;
		this.receivedTimestamp = receivedTimestamp;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReceivedTimestamp() {
		return receivedTimestamp;
	}

	public void setReceivedTimestamp(String receivedTimestamp) {
		this.receivedTimestamp = receivedTimestamp;
	}
	
	public long getRepliesTo() {
		return repliesTo;
	}

	public void setRepliesTo(long repliesTo) {
		this.repliesTo = repliesTo;
	}
}
