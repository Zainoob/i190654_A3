import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Functions extends Thread {
	
	BinarySearchTree Tree = new BinarySearchTree();
	String[] args;
	String[] linetokens1;
	String[] linetokens2;
	Vector<String> v1;
	Vector<String> v2;
	
	public Functions(String[] aru,BinarySearchTree tree)
	{
		args=aru;
		Tree=tree;
		linetokens1=vectortokens(args[1]);
		linetokens2= vectortokens(args[2]);
		v1 = new Vector<String>(linetokens1.length);
		v2 = new Vector<String>(linetokens2.length);
	}
	public void run()
	{
		for (int j = 0; j < linetokens1.length; j++) {
			v1.add(linetokens1[j]);
		}
		for (int j = 0; j < linetokens2.length; j++) {
			v2.add(linetokens2[j]);
		}
		
	}
	public String[] vectortokens(String filename) {
		int i = 0;
		String dummy = "";
		String delimiter = " ";
		try {
			Scanner scanner = new Scanner(new File(filename));

			while (scanner.hasNextLine()) {
				dummy += scanner.nextLine();
				dummy += " ";
			}

			scanner.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		String[] linetokens = dummy.split(delimiter);
		return linetokens;

	}
	public void displayBST() {
		System.out.println("Displaying BST build from Vocabulary File.\r");
		Tree.inOrder();
	} 
	public void displayVectors(){
		System.out.println("Displaying Vectors build from Input file 1.\r");
		for (int i = 0; i < v1.size(); i++) {
			System.out.print(v1.get(i) + "\n");
		}
		System.out.println("Displaying Vectors build from Input file 2.\r");
		for (int i = 0; i < v2.size(); i++) {
			System.out.print(v2.get(i) + "\n");
		}
	} 
	public void MatchWords() {

		String Word;
		System.out.println("Viewing Match words and its frequency\r\n");
		WordsList words = new WordsList();
		for (int i = 0; i < linetokens1.length; i++) {
			//Word = "";
			Word = linetokens1[i];
			if (Tree.Search(Word,Tree.root)) {
				if (words.findWord(words.head, Word)) {
					words.IncrementWordFrequency(words.head, Word);
				} else {
					words.addWord(1, Word);
				}
			} else {
				System.out.println("fails");
			}
		}
		for (int i = 0; i < linetokens2.length; i++) {
			//Word = "";
			Word = linetokens2[i];
			if (Tree.Search(Word,Tree.root)) {
				if (words.findWord(words.head, Word)) {
					words.IncrementWordFrequency(words.head, Word);
				} else {
					words.addWord(1, Word);
				}
			} else {
				System.out.println("fails");
			}
		}
		words.printList();
	} 
	public void SearchQuery(){

		Scanner S = new Scanner(System.in);
		String query;
		int file1 = 0;
		int file2 = 0;
		System.out.println("Searching a query->It should display all the files query found in.\r\n");
		System.out.println("Enter the word you want to search:");
		query = S.next();
		for (int i = 0; i < linetokens1.length; i++) {
			if (query.equals(linetokens1[i])) {
				file1 = 1;

			}
		}
		for (int i = 0; i < linetokens2.length; i++) {
			if ( query.equals(linetokens2[i])) {
				file2 = 1;

			}
		}
		if (file1 == 1) {
			System.out.println("Query found in file: " + args[1]);
		}
		if (file2 == 1) {
			System.out.println("Query found in file: " + args[2]);
		} if(file1==0 && file2==0) {
			System.out.println("Query not found! ");
		}
	}

}
