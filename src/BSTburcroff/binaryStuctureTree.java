package BSTburcroff;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

/*
 * This class is called comparator.
 */

class MyComp implements Comparator<Integer>
{
   public int compare(Integer x, Integer y)
   {
        return y-x;//return the y -x.
   }
}

/*
 * This is a class that goes along with all of the BST needs to
 * be able to do with in the class.
 */

public class binaryStuctureTree <T extends Comparable<T>> implements Iterable<T>
{
   private Node<T> root;//initailizing a node root as a parameter.
   private Comparator<T> comparator;//initailizing a node comparator as a parameter.

   public binaryStuctureTree()
   {
      root = null;//Setting the root to equal null
      comparator = null;//Setting the comparator to null.
   }

   public binaryStuctureTree(Comparator<T> compare)
   {
      root = null;//Setting the root to null for the comparator part.
      comparator = compare;//Setting the comparator to the pass
   }

   /*
    * This is private comparsion going on here with the using a and b.
    */
   private int compare(T a, T b)
   {
      if(comparator == null)//if statement to see comparator is null
      {
    	  return a.compareTo(b);//return the compared to y
      }
      else{
    	  return comparator.compare(a,b);//return two the parameters
      }
   }

   /*
    * This method will insert the new node into the root.
    */
   
   public void insert(T data)
   {
      root = insert(root, data);//the root to insert the root with data
   }
   
   /*
    * This method will insert the node with two parameters by determining where it 
    * should go based on the corrsponding with the nodes avaiblity to put one in on the 
    * right or left based on if is empty or has one it in.  
    */
   
   private Node<T> insert(Node<T> leaf, T add)
   {
      if (leaf == null)//if statement is equal to null
      {
         return new Node<T>(add);//return insert the node
      }
      if (compare(add, leaf.data) == 0)//if statement the insert to the data if equal to zero{
      {
      	return leaf;//return statement
      }
      if (compare(add, leaf.data) < 0)//if statement the insert to the data is less then to zero 
      {
         leaf.left = insert(leaf.left, add);//insert the node to the left
      }
      else
         leaf.right = insert(leaf.right, add);//insert the node to the right
      return leaf;//return statement
   }

   /*
    * This method will search the root by calling the other search method with two parameters.
    */

   public boolean search(T look)
   {
      return search(root, look);//return statement for the root with the method
   }
   
   /*
    * This method will determine what to search the 
    */
   
   private boolean search(Node<T> leaf, T look)
   {
      if (leaf == null)//if statement if p equal to null
      {
         return false;//return false
      }
      else if (compare(look, leaf.data) == 0)//if statement to compare the search data is equal to 0
      {
      	return true;//Return true
      }
      else if (compare(look, leaf.data) < 0)//if statement to compare the search data is less than 0.
      {
         return search(leaf.left, look);//return statement for the left part and the method
      }
      else
         return search(leaf.right, look);//return statement for the right part and the method
   }
   
   /*
    * This method calls the the delete method with two parameters be called in.
    */
   
   public void delete(T remove)
   {
      root = delete(root, remove);//setting the root of delete the root
   }
   
   /*
    * This method will compare the different nodes and deteremine whether to
    * delete what certian element we need to delete based on the the determining what to
    * do with the value of the node.
    */
   
   public Node<T> delete(Node<T> leaf, T remove)//private????
   {
	  if (leaf == null) //if statement for p is null
	   {
		   System.out.println("This item does not exist or has been already removed from the tree");//Print statement
	   }
      else if (compare(remove, leaf.data) < 0)//if statement if the delete of data is greater than 0.
      {
      leaf.left = delete (leaf.left, remove);//delete the left node of the left node
      }
      else if (compare(remove, leaf.data)  > 0)//if statement if the delete of data is less than 0.
      {
      leaf.right = delete (leaf.right, remove);//delete the right node of the right node
      }
      else
      {
         if (leaf.left == null)
         {
        	return leaf.right;//return the statement on the right. 
         }
         else if (leaf.right == null)
         	{
         		return leaf.left;//return the statement on the left
         	}
         else
         {
            leaf.data = retrieveData(leaf.left);//Data from the right most node on the left
            leaf.left =  delete(leaf.left, leaf.data);//Delete the right most node on the left
         }
      }
      return leaf;
   }
  
   /*
    * This is a private part to get the data necessary for the algorithims to if the spot on 
    * the right is not null the set the node to a the right.
    */
  
   private T retrieveData(Node<T> leaf)
   {
      while (leaf.right != null){ 
    	  leaf = leaf.right;//setting th leaf to the leaf of the right
      }
      return leaf.data;//return the leaf data.
   }

   /*
    * This will return the data as a string.
    * @return the to string 
    */
   
   public String toString()
   {
	  String end;//Initailize a stirng end.
      StringBuffer read = new StringBuffer();//setting the buffer to the new string
      for(T data : this) {
    	  read.append(data.toString());//readerthisline to the to data of the string
      }
      end = read.toString();//setting the readerthisline to end
      return end;//return end
   }

   /*
    * This method will call the mehtod after for getting the preordertraversal.
    */
   
   public void preOrderTraversal()
   {
      preOrder(root);//ordering the root by preorder
   }
   
   /*
    * This method will determine if the node out is not null then set the node to the left or 
    * right.
    */
   
   public void preOrder(Node out)
   {
      if (out != null)
      {
         System.out.print(out + " ");//Printing out the node out and space
         preOrder(out.left);//order the out of left
         preOrder(out.right);//order the out of right
      }    	 
   }
   
   /*
    * This method will call the in order of the traversal of the order and then use that of the 
    * root to control it.
    */

   public void inOrderTraversal()
   {
      inOrder(root);//command for the method of the root.
   }
   
   /*
    * This method will determine if the node in is not null otherwise exit. Then order in the left and then
    * the right of the node in.
    */
   
   private void inOrder(Node in)
   {
      if (in != null)
      {
         inOrder(in.left);//order the node in of left
         System.out.print(in + " ");//print the node in but a space
         inOrder(in.right);//order the ndoe in of the right
      }
   }
   
   /*
    * This method will call the in order of the traversal of the order and then use that of the 
    * root to control it.
    */

  
   public void postOrderTraversal()
   {
      postOrder(root);
   }
   
   /*
    * This method will determine if the node in is not null otherwise exit. Then order in the left and then
    * the right of the node in.
    */
   
   private void postOrder(Node in)
   {
      if (in != null)
      {
    	  postOrder(in.left);//order the node in of left
          System.out.print(in + " ");//print the node in but a space
          postOrder(in.right);//order the ndoe in of the right
      }
   }
   
   /*
    * This method is dealing with iterator
    * @iterator
    */
   
   public Iterator<T> iterator()
   {
      return new MyIterator();//return statement
   }
   
   /*
    * This is the iterator classfor the algoritms that impact this 
    * type of node.
    */
  
   public class MyIterator implements Iterator<T>
   {
      Stack<Node<T>> list = new Stack<Node<T>>();//new constructer for this class
      
      public MyIterator()
      {
         if(root != null) 
        	 list.push(root);//push the root to the list
      }
      
      public boolean hasNext()
      {
         return !list.isEmpty();//return the list is not empty
      }

      public T next()
      {
         Node<T> current = list.peek();//the node current to the list at peeking at it
         if(current.left != null)
         {
            list.push(current.left);//push the current to the left of the list
         }
         else
         {
            Node<T> temp = list.pop();//setting a temp which is the list of the 
            while(temp.right == null)
            {
               if(list.isEmpty()) {
            	   return current.data;//return the current of data
               }
               temp = list.pop();//setting the temp  equal to the list and pop it 
            }
            list.push(temp.right);//list push of the temp of the right node
         }

         return current.data;//return the current
      }

      public void remove()
      {

      }
   }

   /*
    * This is a public class for the node.
    */

   public class Node<T>
   {
      private T data;//private constuctor passed through
      private Node<T> left;//private constcutor passed through
      private Node<T> right;//Private constuctor passed through

      /*
       * This method has 3 parameters passed  with one being the data, left and right.
       */
      
      public Node(T data, Node<T> leftnode, Node<T> rightnode)
      {
         left = leftnode;//left equals to the left node
         right = rightnode;//right equals to the right node
         this.data = data;//this data is equal to data
      }

      /*
       * This node will set the data with node of data, left and right.
       */
      
      public Node(T data)
      {
         this(data, null, null);//data, left and right= null 
      }
      
      /*
       * This method will convert data to string
       */

      public String toString()
      {
         return data.toString();//data to string
      }
   } 
}


