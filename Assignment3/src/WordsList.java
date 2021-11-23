
class WordsList {

	Node head;

	  class Node {
	    int frequency;
	    String word;
	    Node next;

	    Node(int d,String w) {
	      frequency = d;
	      word=w;
	      next = null;
	    }
	  }

	  public void addWord(int f,String w) {
	    Node new_node = new Node(f,w);

	    if (head == null) {
	      head = new Node(f,w);
	      return;
	    }

	    new_node.next = null;

	    Node last = head;
	    while (last.next != null)
	      last = last.next;

	    last.next = new_node;
	    return;
	  }

	  boolean findWord(Node head, String key) {
	    Node current = head;
	    while (current != null) {
	      if (key.equals(current.word))
	        return true;
	      current = current.next;
	    }
	    return false;
	  }
	  void IncrementWordFrequency(Node head, String key) {
		    Node current = head;
		    while (current != null) {
		      if (key.equals(current.word))
		    	  ++current.frequency;
		      current = current.next;
		    }
		  }
	  public void printList() {
	    Node tnode = head;
	    while (tnode != null) {
	      System.out.print("Word: "+ tnode.word+ "    Frequency: " + tnode.frequency + "\n");
	      tnode = tnode.next;
	    }

	  }
   

}
