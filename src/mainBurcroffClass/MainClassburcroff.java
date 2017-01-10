package mainBurcroffClass;

import java.io.*;
import java.util.Scanner;
import BSTburcroff.binaryStuctureTree;

public class MainClassburcroff{

	public static void main(String[] args) throws FileNotFoundException, IOException {
		binaryStuctureTree<String> andrew = new binaryStuctureTree<String>();//Starts the new BST of a string.
		File filename = new File("hw5cs3310F16data.txt");
		Scanner kb = new Scanner(filename);//Add the file scanner of the file.
		System.out.println("This is what is happening to the search tree:");//Print statement
		System.out.println();
		while (kb.hasNext()){//start of while loop
			String burcroff = kb.next();//Initializing the file scanner to the next 
			System.out.println(burcroff);//stored in this might need this later
			if(burcroff.equals("Insert:")){//if the this is equal to insert.
				String add = kb.nextLine();
				String[] parts = add.split(",");
				System.out.println(parts[0]);//need to get rid of this
				andrew.insert(parts[0]);
				System.out.println();
			}
			else if(burcroff.equals("Search:")){//search should work once stuff is added
				String search = kb.nextLine();//Print line with the string to the filescanner.
				System.out.println(search);
				System.out.println("If it says True, we found it or it says false which means we did not find it");//print line statement
				System.out.println(andrew.search(search));//prints the search of this to find it.
				System.out.println();
			}
			else if(burcroff.equals("Delete:")){//if this is equal to delete
				String remove = kb.nextLine();//Print line with the string to the filescanner.
				System.out.println(remove);
				andrew.delete(remove);//delete that one
				System.out.println();
			}
			else if(burcroff.equals("Preorder")){//if this is equal to preorder
				System.out.println();
				andrew.preOrderTraversal();//it does the pre order traversal to andrew 
				System.out.println();//Prints a line
			}
			else if(burcroff.equals("Inorder")){//if this is equal to in order
				System.out.println();
				andrew.inOrderTraversal();//it does the in order traversal to andrew
				System.out.println();//Print line
			}
			else if(burcroff.equals("Postorder")){//if the this is equal to the postorder
				System.out.println();
				andrew.preOrderTraversal(); //it does the pre order traversal to andrew
				System.out.println();//prints a line
			}	
		}
		System.out.println();//Print line
		System.out.println("Here is the Tree so far:");//print statement
		System.out.println(andrew.toString());//Prints the tree to string.
	}	
}

	