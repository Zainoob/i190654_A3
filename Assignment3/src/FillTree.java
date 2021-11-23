import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FillTree extends Thread{

	BinarySearchTree Tree = new BinarySearchTree();
	String[] args;
	//
	public FillTree(String[] aru,BinarySearchTree tree)
	{
		args=aru;
		Tree=tree;
	}
	public void run()
	{
		int i = 0;
		String dummy = "";
		String delimiter = ",";
		try {
			Scanner scanner = new Scanner(new File(args[0]));

			while (scanner.hasNextLine()) {
				dummy += scanner.nextLine();
			}

			scanner.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		String[] linetokens = dummy.split(delimiter);
		for(int j=0;j<linetokens.length;j++)
		{
			Tree.insert(linetokens[j]);
		}
	}

}
