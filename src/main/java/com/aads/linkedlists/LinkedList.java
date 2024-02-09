package com.aads.linkedlists;


public class LinkedList {


    Node head = null;
    static LinkedList list = null;

    Node last = null;

    static class Node {

        Object data;
        Node next;
    }

    public static LinkedList createList(int[] inArray) {

        list = new LinkedList();

        int inArrLength = inArray.length;
        Node tempNode;


        Node headNode = new Node();
        headNode.data = inArray[0];
        headNode.next = null;

        list.head = headNode;

        list.last = list.head;

        for (int i = 1; i < inArrLength; i++) {

            tempNode = new Node();
            tempNode.data = inArray[i];
            tempNode.next = null;

            list.last.next = tempNode;
            list.last = tempNode;

        }


        return list;
    }

    public void add(int ele) {

        Node tempNode = new Node();
        tempNode.data = ele;
        tempNode.next = null;

        if (list.head == null) {

            list.head = tempNode;

        } else {
            list.last.next = tempNode;
            list.last = tempNode;
        }


    }

    public void displayList(LinkedList list) {

        Node cursorNode = list.head;

        while (cursorNode != null) {

            System.out.print(cursorNode.data + "  ");
            cursorNode = cursorNode.next;
        }


    }

    public void recursiveDisplayList(Node cursorNode) {

        if (cursorNode != null) {

            System.out.print(cursorNode.data + "  ");
            recursiveDisplayList(cursorNode.next);
        }
    }

    public void reverseRecursiveDisplayList(Node cursorNode) {

        if (cursorNode != null) {

            reverseRecursiveDisplayList(cursorNode.next);
            System.out.print(cursorNode.data + "  ");

        }
    }

    public int count(Node node) {

        int counter = 0;

        while (node != null) {

            counter++;
            node = node.next;

        }

        return counter;
    }

    public int recurresiveCount(Node node) {
        if (node == null)
            return 0;
        else
            return recurresiveCount(node.next) + 1;
    }

    public int sum(Node node) {

        int sum = 0;

        while (node != null) {

            sum = sum + (int) node.data;
            node = node.next;

        }

        return sum;
    }

    public int recurresiveSum(Node node) {

        if (node == null)
            return 0;
        else
            return recurresiveSum(node.next) + (int) node.data;

    }

    public int max(Node node) {

        int maxValue = Integer.MIN_VALUE;

        while (node != null) {

            if ((int) node.data > maxValue)
                maxValue = (int) node.data;

            node = node.next;
        }

        return maxValue;

    }

    public int recrrusiveMax(Node node) {

        int temp = 0;

        if (node == null)
            return Integer.MIN_VALUE;

        temp = recrrusiveMax(node.next);

        return temp > (int) node.data ? temp : (int) node.data;


    }

    public Node search(Node node, int key) {

        while (node != null) {

            if (key == (int) node.data)
                return node;

            node = node.next;

        }

        return null;
    }

    public Node recurrsiveSearch(Node node, int key) {

        if (node == null)
            return null;
        if (key == (int) node.data)
            return node;

        return recurrsiveSearch(node.next, key);

    }

    public Node improvedSearch(Node node, int key) {

        Node previousNode = null;

        while (node != null) {

            System.out.print(node.data + " ");

            if (key == (int) node.data) {

                if (node != head) {
                    previousNode.next = node.next;
                    node.next = head;

                    head = node;
                }
                return node;

            }

            previousNode = node;
            node = node.next;

        }

        return null;
    }


    public void insert(int position, int data) {

        Node newNode = new Node();
        newNode.data = data;

        if (position == 0) {

            newNode.next = head;
            head = newNode;

        } else {

            Node positionNode = head;

            for (int i = 0; i < position - 1 && positionNode != null; i++) {
                positionNode = positionNode.next;
            }

            newNode.next = positionNode.next;
            positionNode.next = newNode;

        }

    }


    public void insetInSortedLinkedList(int data) {

        Node node = head;
        Node tailerNode = null;

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            head = newNode;
        } else {
            while (node != null && (int) node.data < data) {

                tailerNode = node;
                node = node.next;

            }

            if (node == head) {

                newNode.next = head;
                head = newNode;

            } else {

                newNode.next = node;
                tailerNode.next = newNode;

            }
        }

    }

    public void deleteFromList(int position) {

        if (position == 0) {
            Node tempNode = head;
            head = head.next;
            tempNode = null;
        } else {

            Node node = head;
            Node tailerNode = null;

            for (int i = 0; i < position - 1; i++) {

                tailerNode = node;
                node = node.next;

            }

            tailerNode.next = node.next;
            node = null;

        }

    }

    public boolean isLinkedListSorted() {

        int min = Integer.MIN_VALUE;

        Node node = head;

        while (node != null) {

            if ((int) node.data < min)
                return false;

            min = (int) node.data;
            node = node.next;

        }

        return true;
    }

    public void removeDuplicates() {

        Node node = head;
        Node nextNode = head.next;

        while (nextNode != null) {

            if ((int) node.data != (int) nextNode.data) {
                //slide the poinetes to next nodes

                node = nextNode;
                nextNode = nextNode.next;

            } else {
                //remove the next node

                node.next = nextNode.next;
                nextNode = null;
                nextNode = node.next;
            }

        }
    }

    public void reverseLinkedListUsingAuxilaryArray() {

        Node node = head;
        int count = count(node);

        int i = 0;

        int[] auxiliaryArray = new int[count];

        while (node != null) {

            auxiliaryArray[i] = (int) node.data;
            i++;
            node = node.next;

        }

        i--; // as i goes out of index in auxiliaryArray
        node = head; //get node back to head for reverse coping

        while (node != null) {

            node.data = auxiliaryArray[i];
            i--;
            node = node.next;

        }
    }

    public void reverseLinkedListreversingLinks() {

        // using sliding pointers
        Node node = head;
        Node prevNode = null;
        Node prevPrevNode = null;

        while (node != null) {

            prevPrevNode = prevNode;
            prevNode = node;
            node = node.next;

            prevNode.next = prevPrevNode;

        }

        head = prevNode;
    }

    public void reverseLinkedListRecrussion(Node prevNode, Node node) {

        if (node != null) {

            reverseLinkedListRecrussion(node, node.next);
            node.next = prevNode;

        } else {
            head = prevNode;
        }


    }

    public void concatLinkedLists(LinkedList fList, LinkedList sList) {

        Node fNode = fList.head;
        Node sNode = sList.head;

        //   Node prevNode = null;

        while (fNode.next != null) {
            fNode = fNode.next;
        }

        fNode.next = sNode;
        // sList.head = null;
    }

    public void mergerSortedLinkedLists(LinkedList fList, LinkedList sList) {

        Node fNode = fList.head;
        Node sNode = sList.head;
        Node tNode = null; // will not intened to move but to use for new head node!

        Node lastNode = null;

        // to get the pointers on the right head
        if ((int)fNode.data < (int)sNode.data) {

            tNode = fNode;
            lastNode = fNode;
            fNode = fNode.next;
            lastNode.next = null;

        } else {

            tNode = sNode;
            lastNode = sNode;
            sNode = sNode.next;
            lastNode.next = null;
        }

        while (fNode != null && sNode != null){

            if ((int)fNode.data < (int)sNode.data) {

                lastNode.next = fNode;
                lastNode = fNode;
                fNode = fNode.next;
                lastNode.next = null;

            } else {

                lastNode.next = sNode;
                lastNode = sNode;
                sNode = sNode.next;
                lastNode.next = null;

            }
        }

        // One of the List is exhausted  , then point the remining nodes in the other list to new list
        if (fNode != null)
            lastNode.next = fNode;
        else
            lastNode.next = sNode;


        fList.head = tNode;

    }

    public boolean isLoopInLinkedlist(LinkedList list){

        Node head = list.head;

        Node slowPointer = head;
        Node fastPointer = head;

        do{
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;

            if(fastPointer != null)
                fastPointer = fastPointer.next;

        }while((slowPointer != null) && (fastPointer != null) && (slowPointer != fastPointer));


        if(slowPointer == fastPointer) {

            System.out.println(countNodesInLoop(slowPointer));

            return true;
        }
        else
            return false;


    }

    // Returns count of nodes present in loop.
    public int countNodesInLoop(Node node)
    {
        int res = 1;
        Node temp = node;
        while (temp.next != node) {
            res++;
            temp = temp.next;
        }
        return res;
    }

    public static void main(String[] args) {

        int[] inArray = {1, 2, 3, 4, 5, 6, 7};
        LinkedList list = LinkedList.createList(inArray);

        list.displayList(list);
        System.out.println();

        list.add(8);

        list.displayList(list);
        System.out.println();

        list.recursiveDisplayList(list.head);
        System.out.println();

        list.reverseRecursiveDisplayList(list.head);
        System.out.println();

        System.out.println("Count " + list.count(list.head));
        System.out.println("Count Recurresive " + list.recurresiveCount(list.head));

        System.out.println("Sum " + list.sum(list.head));
        System.out.println("Sum Recurresive " + list.recurresiveSum(list.head));

        System.out.println("max " + list.max(list.head));
        System.out.println("max Recurresive " + list.recrrusiveMax(list.head));

        System.out.println("search " + list.search(list.head, 7).data);
        System.out.println("search recurrsive " + list.recurrsiveSearch(list.head, 7).data);

        System.out.println("search improved " + list.improvedSearch(list.head, 7).data);
        System.out.println("search improved again " + list.improvedSearch(list.head, 8).data);

        System.out.println("insert at head 12");
        list.insert(0, 12);
        list.displayList(list);
        System.out.println();

        System.out.println("insert at position 4 and the data 12");
        list.insert(4, 12);
        list.displayList(list);
        System.out.println();

        int[] inArray1 = {1, 2, 3, 4, 5, 6, 8};
        LinkedList sortedList = LinkedList.createList(inArray1);
        sortedList.displayList(sortedList);
        sortedList.insetInSortedLinkedList(7);
        System.out.println();
        sortedList.displayList(sortedList);
        sortedList.insetInSortedLinkedList(12);
        System.out.println();
        sortedList.displayList(sortedList);

        list.deleteFromList(0);
        System.out.println();
        list.displayList(list);

        list.deleteFromList(4);
        System.out.println();
        list.displayList(list);

        int[] inArray2 = {1, 2, 3, 4, 5, 6, 8};
        System.out.println();
        LinkedList sortedList1 = LinkedList.createList(inArray2);
        System.out.println("is list sorted " + sortedList1.isLinkedListSorted());

        int[] inArray4 = {1, 2, 3, 4, 5, 5, 6, 8, 8, 8};
        System.out.println();
        LinkedList sortedList4 = LinkedList.createList(inArray4);
        sortedList4.displayList(sortedList4);
        sortedList4.removeDuplicates();
        System.out.println("\nafter removing duplicates");
        sortedList4.displayList(sortedList4);

        System.out.println("\nreversing Linkedlist using AuxiliaryArray");
        sortedList4.reverseLinkedListUsingAuxilaryArray();
        sortedList4.displayList(sortedList4);

        System.out.println("\nreversing Linkedlist using Reversing Links");
        sortedList4.reverseLinkedListreversingLinks();
        sortedList4.displayList(sortedList4);


        System.out.println("\nreversing Linkedlist using Recurssion");
        int[] inArray7 = {1, 2, 3, 4, 5, 6, 8};
        System.out.println();
        LinkedList sortedList7 = LinkedList.createList(inArray7);
        System.out.println("\nreversing Linkedlist using Recurssion");
        sortedList7.displayList(sortedList7);
        System.out.println();
        sortedList7.reverseLinkedListRecrussion(null, sortedList7.head);
        sortedList7.displayList(sortedList7);

        System.out.println("\nConcatinating Linkedlists");
        sortedList7.concatLinkedLists(sortedList4, sortedList7);
        sortedList7.displayList(sortedList4);

        int[] inArray8 = {2, 6, 8, 9};
        int[] inArray12 = {4, 5, 7, 8};
        LinkedList sortedList8 =LinkedList.createList(inArray8);
        LinkedList sortedList12 =LinkedList.createList(inArray12);
        System.out.println("\nmerging 2 linked lists");
        sortedList8.displayList(sortedList8);
        System.out.println();
        sortedList12.displayList(sortedList12);
        System.out.println();
        sortedList8.mergerSortedLinkedLists(sortedList8, sortedList12);
        sortedList8.displayList(sortedList8);

        System.out.println("\nIs Theare A Loop");
        //create loop

        LinkedList loopList1 = LinkedList.createList(new int[]{1,2,3,4,5,6,7});
        Node loopNode = loopList1.head.next.next.next;
        Node lastNode = loopNode.next.next.next;

        lastNode.next = loopNode;
        System.out.println(loopList1.isLoopInLinkedlist(loopList1));

    }
}
