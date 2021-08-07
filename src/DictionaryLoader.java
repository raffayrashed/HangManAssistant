import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryLoader {

	private MyArrayLinkedList dictionary = new MyArrayLinkedList();
	
	public DictionaryLoader (String dictFileName)throws Exception{
		
		FileReader file = new FileReader(dictFileName);
		BufferedReader reader = new BufferedReader(file);
		while(true){
			String word = reader.readLine();
			if ( word == null ) break;
			//System.out.println(word);
			dictionary.add(word.toLowerCase().replace("'", ""));
		}
		reader.close();
	}
	
	
	public List<String> getWordListOfLengthMatchingRegEx(String regex){
		Integer len = regex.length();
		if(dictionary.hasLength(len)){
			LinkedList wordList = dictionary.getLinkedList(len);
			List<String> matchedWordList = new ArrayList<String>();			
			Node currentNode = wordList.getFirst();
			while(currentNode != null){
				String word = currentNode.getWord();
				if(word.matches(regex)){
					matchedWordList.add(word);
					// System.out.println(word);
				}
				currentNode = currentNode.getNext();
			}
			return matchedWordList;
		}
		return new ArrayList<String>();
	}
	
	// This function should take the regex string and 
	// get the word list matching it internally 
	// A character should only be counted if it appears on a position 
	// where the regex has a dot
	public Map<String, Integer> countCharacters(String regex){
		
		// get all the words that match to the regex
		List<String> wordList = getWordListOfLengthMatchingRegEx(regex);
		
		// Make list of the locations where there is a DOT in the regex
		ArrayList<Integer> dotIndices = new ArrayList<Integer>();
		for (int i = 0; i < regex.length(); i++){
			if (regex.charAt(i) == '.') {
				dotIndices.add(i);
				// System.out.println(i);
			}
		}
		
		// This is where we would be collecting the statistics of characters 
		Map<String, Integer> chCounter = new HashMap<String, Integer>();
				
		// Loop over all the words the matched the regex
		for(String word : wordList){
			// loop over the the locations where there is a DOT in the regex
			for(Integer i : dotIndices){
				// Character at index j 
				String ch = String.valueOf(word.charAt(i));
				// if the counter does not have it already then create one
				if (! chCounter.containsKey(ch) ) {
					chCounter.put(ch, new Integer(0));
				}
				// increment the counter 
				Integer count = chCounter.get(ch);
				count++;
				chCounter.put(ch, count);
			}
		}
		
		return chCounter;
	}
	
}
