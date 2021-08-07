
public class LinkedList {

	private Node first;
	private Node last;
	private int count;
	
	public LinkedList(){
		this.first = null;
		this.last = null;
		count = 0;
	}
	
	public void add(String word){
		Node myNode = new Node(word); 
		
		if(this.first == null){
			this.setFirst(myNode);
		}
		if(this.last==null){
			this.setLast(myNode);
			count++;
		} else {
			this.getLast().setNext(myNode);
			this.setLast(myNode);
			count++;
			
		}
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}
	
	public boolean listHas(String word){
		Node myNode = this.first;
		while(myNode != null){
			if(myNode.getWord().equals(word)){
				return true;
			} else {
				myNode = myNode.getNext();
			}
		}
		return false;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
