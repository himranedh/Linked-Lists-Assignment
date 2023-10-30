import java.util.Arrays;

public class LList {
    private Node firstNode; // refernce to first node of chain
    private int numberOfEntries;

    public LList() {
        initializeDataFields();
    } // end default constructor

    public void clear() {
        initializeDataFields();
    } // end clear

    public boolean isEmpty() {
        boolean result;
        if (numberOfEntries == 0) {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    } // end isEmpty

    public void add(char newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        }
        else { // add to end of nonempty list
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode); // make last node refernce new node
        } // end if
        numberOfEntries++;
    } // end add

    private void initializeDataFields() {
        firstNode = null;
        numberOfEntries = 0;
    } // end initializeDataFields

    private Node getNodeAt (int givenPosition) {
        Node currentNode = firstNode;
        // traverse the chain to locate the desired node
        // (skipped if given position is 1)
        for (int counter = 1; counter < givenPosition; counter++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    } // end getNodeAt

    private int numberOfEdges() {
        int numberOfEdges = numberOfEntries - 1;
        return numberOfEdges;
    } // end numberOfEdges

    // neighbor function for Task 2
    public char[] toArray() {
        @SuppressWarnings("unchecked")
        char[] result = new char[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            index++;
            currentNode = currentNode.getNextNode();
        } //end while
        return result;
    } // end toArray

    private class Node {
        private char data; // data entry
        private Node next; // link to next node

        private Node(char dataPortion) {
            data = dataPortion;
        } // end constructor

        private Node(char dataPortion, Node nextNode) { 
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private char getData() {
            return data;
        } // end getData

        private void setData(char newData) {
            data = newData;
        } // end setData

        private Node getNextNode() {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode) {
            next = nextNode;
        } // end setNextNode
    }

    public static void main(String[] args) {
        // linked lists for all 9 vertices
        LList A = new LList();
        LList B = new LList();
        LList C = new LList();
        LList D = new LList();
        LList E = new LList();
        LList F = new LList();
        LList G = new LList();
        LList H = new LList();
        LList I = new LList();

        // adding nodes to each linked list
        // A
        A.add('B');
        A.add('D');
        A.add('E');
        // B
        B.add('E');
        // C
        C.add('B');
        // D
        D.add('G');
        // E
        E.add('F');
        E.add('H');
        // F
        F.add('C');
        F.add('H');
        // G
        G.add('H');
        // H
        H.add('I');
        // I
        I.add('F');

        A.getNodeAt(1);

        // completed graph using adjacency lsit for Task 1
        System.out.println("\nVisual Representation of Graph:");
        System.out.println("A → → → D → → → G");
        System.out.println("↓ ↘             ↓");
        System.out.println("↓   ↘           ↓");
        System.out.println("↓     ↘         ↓");
        System.out.println("B → → → E → → → H");
        System.out.println("↑       ↓     ↗ ↓");
        System.out.println("↑       ↓   ↗   ↓");
        System.out.println("↑       ↓ ↗     ↓");
        System.out.println("C ← ← ← F ← ← ← I\n");
        
        // neighbor (toArray) function that returns an array containing the neighbors of each vertex
        System.out.println("Neighbor(s) of A:" + Arrays.toString(A.toArray()));
        System.out.println("Neighbor(s) of B:" + Arrays.toString(B.toArray()));
        System.out.println("Neighbor(s) of C:" + Arrays.toString(C.toArray()));
        System.out.println("Neighbor(s) of D:" + Arrays.toString(D.toArray()));
        System.out.println("Neighbor(s) of E:" + Arrays.toString(E.toArray()));
        System.out.println("Neighbor(s) of F:" + Arrays.toString(F.toArray()));
        System.out.println("Neighbor(s) of G:" + Arrays.toString(G.toArray()));
        System.out.println("Neighbor(s) of H:" + Arrays.toString(H.toArray()));
        System.out.println("Neighbor(s) of I:" + Arrays.toString(I.toArray()));
        System.out.println();
    }
}

