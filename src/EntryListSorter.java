import java.util.List;
import java.util.Map.Entry;

public class EntryListSorter {

	private List<Entry<String, Integer>> eList;
	
	public List<Entry<String, Integer>> getSortedList() {
		return eList;
	}

	public void seteList(List<Entry<String, Integer>> eList) {
		this.eList = eList;
		sortEntryList();
	}

	public EntryListSorter(List<Entry<String, Integer>> eList){
		seteList(eList);
	}
	
	public void swap(int i, int j){
		Entry<String, Integer> eTemp = eList.get(i);
		eList.set(i, eList.get(j));
		eList.set(j, eTemp);
	}
	
	public void sortEntryList(){
		
		for(int i = 0; i<eList.size(); i++){
			for(int j = i+1; j<eList.size(); j++){
				if (eList.get(i).getValue() < eList.get(j).getValue()){
					swap(i,j);
				}
			}
		}
	}
}
