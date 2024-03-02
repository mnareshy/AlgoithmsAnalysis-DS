package com.aads.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinrayTree {

    class Node {
        Node lChild;
        Object data;
        Node rChild;

    }


    Node pointerNode;
    Node tempNode;

    Node root = new Node();

    void createBinaryTree() {

        Queue queue = new LinkedList();

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter root node value");
        int rootVal = scanner.nextInt();

        root = new Node();
        root.lChild = null;
        root.rChild = null;
        root.data = rootVal;

        queue.offer(root);

        while (!queue.isEmpty()) {

            pointerNode = (Node) queue.poll();

            System.out.println("enter left child value for " + pointerNode.data + " Node");
            int lChildVal = scanner.nextInt();

            if (lChildVal != -1) {

                tempNode = new Node();
                tempNode.lChild = null;
                tempNode.rChild = null;
                tempNode.data = lChildVal;

                queue.offer(tempNode);

                pointerNode.lChild = tempNode;


            }
            System.out.println("enter right child value for " + pointerNode.data + " Node");
            int rChildVal = scanner.nextInt();

            if (rChildVal != -1) {

                tempNode = new Node();
                tempNode.lChild = null;
                tempNode.rChild = null;
                tempNode.data = rChildVal;

                queue.offer(tempNode);

                pointerNode.rChild = tempNode;


            }

        }

    }

    void preOrder(Node node) {

        if (node != null) {

            System.out.print(node.data + " ");
            preOrder(node.lChild);
            preOrder(node.rChild);

        }
    }


    void inOrder(Node node) {

        if (node != null) {

            inOrder(node.lChild);
            System.out.print(node.data + " ");
            inOrder(node.rChild);

        }
    }

    void postOrder(Node node) {

        if (node != null) {

            postOrder(node.lChild);
            postOrder(node.rChild);
            System.out.print(node.data + " ");

        }
    }

    public void preOrderIterative(Node node) {

        Stack stack = new Stack();

        while (node != null || !stack.isEmpty()) {

            if (node != null) {

                System.out.print(node.data + " ");
                stack.push(node);
                node = node.lChild;

            } else {

                node = (Node) stack.pop();
                node = node.rChild;

            }

        }

    }

    public void inOrderIterative(Node node) {

        Stack stack = new Stack();

        while (node != null || !stack.isEmpty()) {

            if (node != null) {

                stack.push(node);
                node = node.lChild;

            } else {

                node = (Node) stack.pop();
                System.out.print(node.data + " ");
                node = node.rChild;

            }

        }

    }

    public void postOrderIterative(Node node) {

        Stack stack = new Stack();

        while (node != null || !stack.isEmpty()) {

            if (node != null) {

                stack.push(node);
                stack.push(node);
                node = node.lChild;

            } else {

                node = (Node) stack.pop();


                if (!stack.isEmpty() && stack.peek() == node)
                    node = node.rChild;
                else {

                    System.out.print(node.data + " ");
                    node = null;

                }

            }
        }

       /*Stack<Node> stack = new Stack<>();
       while(true) {
           while(node != null) {
               stack.push(node);
               stack.push(node);
               node = node.lChild;
           }

           // Check for empty stack
           if(stack.empty()) return;
           node = stack.pop();

           if(!stack.empty() && stack.peek() == node) node = node.rChild;

           else {

               System.out.print(node.data + " "); node = null;
           }
       }
*/
    }

    public void levelOrder(Node node){

        Queue queue =  new LinkedList();

        System.out.print(node.data + " ");
        queue.offer(node);

        while(!queue.isEmpty()){

            node = (Node) queue.poll();

            if(node.lChild != null){

                System.out.print(node.lChild.data + " ");
                queue.offer(node.lChild);

            }

            if(node.rChild != null){

                System.out.print(node.rChild.data + " ");
                queue.offer(node.rChild);
            }

        }

    }


    int count(Node node){

        if(node != null)
            return count(node.lChild) + count(node.rChild) + 1;

        return 0;
    }

    int countLeafs(Node node){

        int x = 0;
        int y = 0;

        if(node != null){

            x = countLeafs(node.lChild);
            y = countLeafs(node.rChild);

            if(node.lChild ==null && node.rChild == null )
                return x+y+1;
            else
                return x+y;

        }

        return 0;
    }


    int height(Node node){

        int x = 0;
        int y = 0;

        if(node == null)
            return 0;

        x = height(node.lChild);
        y = height(node.rChild);

        if(x > y)
            return x + 1;
        else
            return y + 1;


    }

    public static void main(String[] args) {

        BinrayTree bTree = new BinrayTree();
        bTree.createBinaryTree();

        bTree.preOrder(bTree.root);
        System.out.println();
        bTree.inOrder(bTree.root);
        System.out.println();
        bTree.postOrder(bTree.root);

        System.out.println("\npreorder using itartatoin");
        bTree.preOrderIterative(bTree.root);

        System.out.println("\ninorder using itartatoin");
        bTree.inOrderIterative(bTree.root);

        System.out.println("\npostorder using itartatoin");
        bTree.postOrderIterative(bTree.root);

        System.out.println("\nlevelOrder Travese");
        bTree.levelOrder(bTree.root);

        System.out.println("\nNumber of nodes in the tree");
        System.out.println(bTree.count(bTree.root));

        System.out.println("\nNumber of Leaf nodes in the tree");
        System.out.println(bTree.countLeafs(bTree.root));

        System.out.println("\nheight of the tree");
        System.out.println(bTree.height(bTree.root));


    }
}
