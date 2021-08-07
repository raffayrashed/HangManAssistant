
public class Node {
	
	private String word;
	private Node next;
	
	public Node(String word){
		this.setWord(word);
		this.setNext(null);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
