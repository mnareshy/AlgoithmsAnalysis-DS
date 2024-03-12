package com.aads.trees;

public class BinarySearchTree {

    class Node {

        Node lchild;
        Object data;
        Node rChild;

    }

    public Node search(Node node, int key) {

        while (node != null) {

            if ((int) node.data == key)
                return node;

            if (key < (int) node.data)
                node = node.lchild;
            else
                node = node.rChild;

        }

        return null;

    }

    public Node recursiveSearch(Node node, int key) {

        if (node == null)
            return null;

        if (key == (int) node.data)
            return node;

        if (key < (int) node.data)
            return recursiveSearch(node.lchild, key);
        else
            return recursiveSearch(node.rChild, key);

    }

    public Node insert(Node node, int key) {

        Node tempNode;
        Node tailerPointer = null;


        tempNode = new Node();
        tempNode.data = key;
        tempNode.lchild = null;
        tempNode.rChild = null;

        if (node == null)
            return tempNode;

        while (node != null) {

            tailerPointer = node;

            if (key == (int) node.data)
                return node;

            if (key < (int) node.data)
                node = node.lchild;
            else
                node = node.rChild;

        }

        if (key < (int) tailerPointer.data)
            tailerPointer.lchild = tempNode;
        else
            tailerPointer.rChild = tempNode;


        return tempNode;
    }

    public Node recurrsiveInsert(Node node, int key) {

        Node tempNode = new Node();
        tempNode.data = key;
        tempNode.lchild = null;
        tempNode.rChild = null;

        if (node == null)
            return tempNode;

        if (key < (int) node.data)
            node.lchild = recurrsiveInsert(node.lchild, key);
        else if((key > (int) node.data))
            node.rChild = recurrsiveInsert(node.rChild, key);

        return node;

    }

    public Node createBST(int[] inArray) {

        Node root = insert(null, inArray[0]);

        for (int i = 1; i < inArray.length; i++) {

            insert(root, inArray[i]);

        }

        return root;
    }

    public void preOrder(Node node) {

        if (node == null)
            return;

        System.out.print(node.data +" ");
        preOrder(node.lchild);
        preOrder(node.rChild);


    }

    public void inOrder(Node node) {

        if (node == null)
            return;

        inOrder(node.lchild);
        System.out.print(node.data + " ");
        inOrder(node.rChild);


    }


    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        int[] inArray = {4, 12, 2, 6, 7, 8, 16, 17, 20};

        Node node = bst.createBST(inArray);

        bst.inOrder(node);
        System.out.println();
        bst.preOrder(node);

        System.out.println();

        System.out.println(bst.search(node,20).data);
        System.out.println(bst.recursiveSearch(node,12).data);

    }
}
