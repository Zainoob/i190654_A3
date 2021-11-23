import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Driver {

	Driver() {

	}

	void menu() {
		System.out.println("Welcome to the menu\r\n" 
				+ "1) Displaying BST build from Vocabulary File.\r\n"
				+ "2) Displaying Vectors build from Input files.\r\n" 
				+ "3) Viewing Match words and its frequency\r\n"
				+ "4) Searching a query->It should display all the files query found in.\r\n"
				+ "5) Enter 5 for Exiting.\r\n" + "Enter your choice :");
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

	public static void main(String[] args) throws CustomException{
		Driver d = new Driver();
		BinarySearchTree Tree = new BinarySearchTree();
		FillTree vocabulary=new FillTree(args,Tree);
		
		vocabulary.start();
		
		Functions fun=new Functions(args,Tree);
		
		fun.start();
		
		
		Scanner S = new Scanner(System.in);
		int choice=1 ;
		while (choice != 5) {
			d.menu();
			choice = S.nextInt();
			if(choice <= 0 || choice >5)
			{
				throw new CustomException("Please enter valid input (1-5)\n");
			}
			if (choice == 1) {
				int files = args.length;
				System.out.println("Total File Number: " + files);
				for (int i=0;i<args.length;i++)
				{
					System.out.println("File "+(i+1)+" name : " + args[i]);
				}
				Tree.inOrder();
			} else if (choice == 2) {
				fun.displayVectors();
			} else if (choice == 3) {

				fun.MatchWords();
			} else if (choice == 4) {

				fun.SearchQuery();
			} else if (choice == 5) {
				System.out.println("Exiting");
				break;
			}
		}
	}

}
