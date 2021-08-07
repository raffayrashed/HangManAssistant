import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class MyArrayLinkedList {

	private int legnth = 16;
	private LinkedList hArray[] = new LinkedList[legnth];
	
	public MyArrayLinkedList(){
		for(int i = 0; i < legnth; i++){
			hArray[i] = new LinkedList();
		}
	}
	
	public void add(String word){
		//System.out.println(hCode);
		int index = word.length();
		//System.out.println(Math.abs(hashIndex));
		hArray[index].add(word);
	}
	
	public boolean hasLength(Integer key){
		return (key<=legnth);
	}
	
	public void printAllChainedIndexes(){
		for(int i = 0; i < hArray.length; i++){
			if(hArray[i].getCount() > 1){
				System.out.println(i + " " + hArray[i].getCount());
			}
		}
	}
	public LinkedList getLinkedList(int i) {
		return hArray[i];
	}

	public String generateRadomWord() throws Exception{
		FileReader file = new FileReader("C:/Users/raffa/Desktop/ALLWORDS2.txt");
		BufferedReader reader = new BufferedReader(file);
		String line = reader.readLine();
		
		Random rand = new Random();
		int  n = rand.nextInt((41238 - 1) + 1) + 1;
		String lineIWant = null;
		for(int i = 0; i < n ; i++){
			lineIWant = line;
			line = reader.readLine();
			
		}
		reader.close();
		return lineIWant;
	}
	

	public LinkedList[] gethArray() {
		return hArray;
	}
}
