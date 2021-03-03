package Practice;

import java.util.Arrays;

public class PracticeTestDriver {

    public static void main(String[] args) {
	    // Question 1:

//        Node<String> n0 = new Node<String>("y");
//        Node<String> n1 = new Node<String>("k", n0);
//        Node<String> n2 = new Node<String>("c", n1);
//        Node<String> n3 = new Node<String>("i", n2);
//        Node<String> n4 = new Node<String>("p", n3);
//
//        Node<String> firstNode = n4;              // line 1     p->i->c->k->y; current: n/a
//        Node<String> current = firstNode;         // line 2     p->i->c->k->y; current: p
//        current = current.next;                   // line 3     p->i->c->k->y; current: i
//        firstNode = firstNode.next;               // line 4     i->c->k->y; current: i
//        current.next.data = "n";                  // line 5     i->n->k->y; current: i
//        current.next = current.next.next.next;    // line 6     i->y; current: i
//        firstNode.data = "b";                     // line 7     b->y; current: b
//        current = current.next;                   // line 8     b->y; current: y
//        firstNode.next = current.next;            // line 9     b; current: y

        // Question 2:

//        Node<Integer> n5 = new Node<Integer>(5);
//        Node<Integer> n4 = new Node<Integer>(4, n5);
//        Node<Integer> n6 = new Node<Integer>(6, n4);
//        Node<Integer> n1 = new Node<Integer>(1, n6);
//        Node<Integer> n7 = new Node<Integer>(7, n1);
//        Node<Integer> n0 = new Node<Integer>(0);
//
//        Node<Integer> firstNode = n7;                      // line 1        7->1->6->4->5
//        n0.next = n6;                                      // line 2        7->1->6->4->5
//        n1.next = n0;                                      // line 3        7->1->0->6->4->5
//        firstNode.next.next.next = firstNode.next.next.next.next; // line 4 7->1->0->4->5
//        System.out.println(firstNode.next.data);           // line 5        1
//        firstNode = firstNode.next;                        // line 6        1->0->4->5
//        System.out.println(firstNode.next.next.next.next); // line 7        null
//        firstNode.next = firstNode.next.next;              // line 8        1->4->5
//        System.out.println(firstNode.next.next.next.data); // line 9        exception thrown

        // Question 3:

        /*
        public static int mysteryMethod(Node<String> node, String target) {
            int count = 0;
            int pos = -1;
            Node<String> current = node;
            while(current!=null) {
                if(current.data.equalsIgnoreCase(target)) {
                    pos = count;
                }
                current = current.next;
                count++;
            }
            return pos;
        }

        mysteryMethod returns the last position of the link that contains the target string, ignoring case; otherwise,
        it returns -1.
         */

        // Question 4:

        /*
        Node currentNode = firstNode;
        while(currentNode.next!=null) {
           System.out.println(currentNode.data);
           currentNode = currentNode.next;
        }

        Will crash with empty list since .next cannot be invoked. Also won't print for singleton as well as last
        element.

        Node<Integer> currentNode = firstNode;
        while(currentNode!=null) {
           currentNode.data = currentNode.data * 2;
        }

        Infinite loop as it doesn't advance to the next node.
         */

        // Question 5:

//        Node<String> s1 = new Node<>("Hello ");
//        Node<String> s2 = new Node<>("World! ");
//        Node<String> s3 = new Node<>("Goodnight!");

//        Node<String> firstNode = s1;
//        firstNode.next = s2;
//        firstNode.next.next = s3;
//        System.out.println(concatenateStrings(firstNode));

        // Question 6:
//        firstNode = moveLast(firstNode);
//        System.out.println(concatenateStrings(firstNode));


        // Question 7:

//        LinkedBag<Integer> nums = new LinkedBag<>();
//        nums.add(1);
//        nums.add(3);
//        nums.add(4);
//        nums.add(1);
//
//        nums.replaceAll(1, 2);
//
//        System.out.println(Arrays.toString(nums.toArray()));

        // Question 10:

        /*
        Linked nodes doesn't waste memory for unused capacity; however, it takes a bit more memory in order to link the
        location of the next node. For one with head and tail, it also may be more efficient in order to add or remove
        items from one end or the other whereas array may require to traverse through entire array to remove an element
        at the beginning.
         */

        // Question 11:

        Node<Integer> firstNode = new Node<Integer>(Integer.valueOf(1), new Node<Integer>(Integer.valueOf(2),
                new Node<Integer>(Integer.valueOf(3), new Node<Integer>(Integer.valueOf(4)))));
        // test with other length chains
		/*
		firstNode = null;
		firstNode = new Node<Integer>(Integer.valueOf(1));
		firstNode = new Node<Integer>(Integer.valueOf(1), new Node<Integer>(Integer.valueOf(2)));
		firstNode = new Node<Integer>(Integer.valueOf(1), new Node<Integer>(Integer.valueOf(2), new Node<Integer>(Integer.valueOf(3))));
		firstNode = new Node<Integer>(Integer.valueOf(1), new Node<Integer>(Integer.valueOf(2),
				new Node<Integer>(Integer.valueOf(3),new Node<Integer>(Integer.valueOf(4),new Node<Integer>(Integer.valueOf(5))))));
		*/

        System.out.println("Third from last: " + findThirdFromLast(firstNode));

        // Question 12:
        System.out.println("Middle element: " + findMiddleElement(firstNode));


    }

    // Question 5:

    public static String concatenateStrings(Node<String> firstNode) {
        String combined = firstNode.data;
        Node<String> current = firstNode.next;

        while(current != null) {
            combined += current.data;
            current = current.next;
        }

        return combined;
    }

    // Question 6:

    public static Node moveLast(Node firstNode) {
        Node current = firstNode;
        Node secondLastNode = null;
        Node lastNode = null;

        if (current != null && current.next != null) {
            while (current.next != null) {

                if (current.next.next == null) {
                    secondLastNode = current;
                    lastNode = current.next;
                }
                current = current.next;
            }

            secondLastNode.next = null;
            lastNode.next = firstNode;
            firstNode = lastNode;
        }

        return firstNode;
    }

    // Question 11:

    public static <T> T findThirdFromLast(Node<T> firstNode) {
        Node<T> current = firstNode;
        T target = null; // Assert: if less than 3 items (current, current.next and current.next.next)

        if (current != null && current.next != null && current.next.next != null) {

            while (current.next.next != null) {
                if (current.next.next.next == null) {
                    target = current.data;
                }
                current = current.next;
            }
        }

        return target;
    }

    // Question 12:

    public static <T> T findMiddleElement(Node<T> firstNode) {
        T target = null; // Assert: if firstNode is null
        Node<T> left = firstNode;
        Node<T> right = firstNode;

        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            target = left.data;
        }

        return target;
    }

    /*
    QUESTION 13 (Didn't do but answer key):

    public static DoubleNode<Integer> insert(DoubleNode<Integer> firstNode, int elementToAdd, int positionToAdd) {
        // invalid index
        if(positionToAdd<0 ) {
            throw new IllegalArgumentException("Invalid position.");
        }

        DoubleNode<Integer> nodeToInsert = new DoubleNode<Integer>(elementToAdd);

        // case 1: empty list (valid position to add: 0)
        if(firstNode==null && positionToAdd==0) {
            return nodeToInsert;
        } else if(firstNode==null) { // && positionToAdd!=0
            throw new IllegalArgumentException("Invalid position.");
        }

        // case 2: singleton list (valid positions to add: 0 and 1)
        if(firstNode.next==null) {
            if(positionToAdd==0) {
                nodeToInsert.next = firstNode;
                firstNode.previous = nodeToInsert;
                return nodeToInsert;
            } else if(positionToAdd==1) {
                firstNode.next = nodeToInsert;
                return firstNode;
            } else {
                throw new IllegalArgumentException("Invalid position.");
            }
        }

        // case 3: adding to the beginning of the list (we know the list has 2 or more elements)
        if(positionToAdd==0) {
            firstNode.previous = nodeToInsert;
            nodeToInsert.next = firstNode;
            return nodeToInsert;
        }

        // case 4, 5, and 6: adding to the middle or end of a list with 2 or more elements
        DoubleNode<Integer> current = firstNode.next;
        DoubleNode<Integer> previous = firstNode;
        int currentPosition = 0;
        while(currentPosition < positionToAdd && current!=null) {
            current = current.next;
            previous = previous.next;
            currentPosition++;
        }
        // invalid position
        if(positionToAdd>currentPosition+1) {
            throw new IllegalArgumentException("Invalid position.");
        }

        // case 4: adding to the end of the list
        if(current==null && currentPosition+1==positionToAdd) {
            previous.next = nodeToInsert;
            nodeToInsert.previous = previous;
            return firstNode;
        }

        // case 5: adding to the middle of the list
        else {
            nodeToInsert.previous = previous.previous;
            nodeToInsert.next = previous;
            previous.previous.next = nodeToInsert;
            previous.previous = nodeToInsert;
            return firstNode;
        }
    }
     */
}
