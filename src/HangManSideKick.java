import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;

public class HangManSideKick {

	private JFrame frame;
	private JTextArea possibleWordsBox = new JTextArea();
	private JTextArea vowelsBox = new JTextArea();
	private JTextPane wordBox = new JTextPane();
	private JTextArea ConsonantsBox = new JTextArea();
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangManSideKick window = new HangManSideKick();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HangManSideKick() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setBounds(100, 100, 610, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to your Hangman SideKick call me SideMan ( \u0361\u00B0 \u035C\u0296 \u0361\u00B0)");
		lblNewLabel.setBounds(10, 11, 496, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel);
		
		wordBox.setBounds(95, 58, 222, 53);
		wordBox.setFont(new Font("Courier New", Font.PLAIN, 25));
		wordBox.setText("........");
		wordBox.setBackground(Color.WHITE);
		frame.getContentPane().add(wordBox);
		
		JLabel lblNewLabel_1 = new JLabel("Word:");
		lblNewLabel_1.setBounds(33, 70, 50, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton updateWordButton = new JButton("Click once Word is updated");
		updateWordButton.setBounds(191, 342, 197, 45);
		updateWordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String dictionaryFileName = "wordList/ALLWORDS.txt";
				String matchString = wordBox.getText();

				try {
					// Load the dictionary from the file 
					DictionaryLoader myDictionary = new DictionaryLoader(dictionaryFileName);
					
					String listOfPossibleWords = "";
					for (String word : myDictionary.getWordListOfLengthMatchingRegEx(matchString) ) {
						listOfPossibleWords = listOfPossibleWords + word + "\n";
					}
					possibleWordsBox.setText(listOfPossibleWords);
					
					Map<String, Integer> chCounter = myDictionary.countCharacters(matchString);
					List<Entry<String, Integer>> entryList = new ArrayList<Entry<String, Integer>>(chCounter.entrySet());
					List<Entry<String, Integer>> vowelList = new ArrayList<Entry<String, Integer>>();
					List<Entry<String, Integer>> consList = new ArrayList<Entry<String, Integer>>();
					
					
					for(Entry<String, Integer> e: entryList){
						if(e.getKey().equals("a") || e.getKey().equals("e") || e.getKey().equals("i") || e.getKey().equals("o") || e.getKey().equals("u")) {
							vowelList.add(e);
						} else {
							consList.add(e);
						}
					}

					EntryListSorter vowelSorter = new EntryListSorter(vowelList);
					EntryListSorter consSorter = new EntryListSorter(consList);

					String vowelsList = "";
					String consonantsList = "";
					for(Entry<String, Integer> e: vowelSorter.getSortedList()){
						if( ! textField.getText().matches(".*"+e.getKey()+".*") ){
							vowelsList = vowelsList + (e.getKey() + " = " + e.getValue()+"\n");
						}
					}

					for(Entry<String, Integer> e: consSorter.getSortedList()){
						if( ! textField.getText().matches(".*"+e.getKey()+".*") ){
							consonantsList = consonantsList + (e.getKey() + " = " + e.getValue() + "\n");
						}
					}
					vowelsBox.setText(vowelsList);
					ConsonantsBox.setText(consonantsList);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
		});
		frame.getContentPane().add(updateWordButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 143, 159, 173);
		frame.getContentPane().add(scrollPane);
		possibleWordsBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		scrollPane.setViewportView(possibleWordsBox);
		
		possibleWordsBox.setEditable(false);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 143, 159, 173);
		frame.getContentPane().add(scrollPane_1);
		vowelsBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		scrollPane_1.setViewportView(vowelsBox);
		
		
		vowelsBox.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("Vowels");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(60, 108, 63, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblPossibleWords = new JLabel("Possible Words");
		lblPossibleWords.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblPossibleWords.setBounds(437, 108, 110, 24);
		frame.getContentPane().add(lblPossibleWords);
		
		JLabel lblConsonants = new JLabel("Consonants");
		lblConsonants.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblConsonants.setBounds(264, 108, 110, 25);
		frame.getContentPane().add(lblConsonants);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(220, 143, 159, 173);
		frame.getContentPane().add(scrollPane_2);
		ConsonantsBox.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		
		scrollPane_2.setViewportView(ConsonantsBox);
		ConsonantsBox.setEditable(false);
		
		JLabel lblGuessedLetters = new JLabel("Guessed Letters:");
		lblGuessedLetters.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGuessedLetters.setBounds(329, 58, 134, 45);
		frame.getContentPane().add(lblGuessedLetters);
		
		textField = new JTextField();
		textField.setFont(new Font("Courier New", Font.PLAIN, 13));
		textField.setBounds(475, 67, 105, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
