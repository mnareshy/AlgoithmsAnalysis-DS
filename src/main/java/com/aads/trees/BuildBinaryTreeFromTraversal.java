package com.aads.trees;

public class BuildBinaryTreeFromTraversal {

    class Node {

        Node lChild;
        Object data;
        Node rChild;

    }

    static int preIndex = 0;

    Node buidlBinaryTree(int[] pre, int[] in, int start, int end) {


        if (start > end)
            return null;

        Node node = new Node();
        node.lChild = null;
        node.rChild = null;
        node.data = pre[preIndex];
        preIndex++;

        if (start == end)
            return node;

        int inIndex = findTheNodeDataIndexinInirder(start, end, in, (int) node.data);

        node.lChild = buidlBinaryTree(pre, in, start, inIndex - 1);
        node.rChild = buidlBinaryTree(pre, in, inIndex + 1, end);


        return node;
    }

    private int findTheNodeDataIndexinInirder(int start, int end, int[] in, int data) {

        int inIndex = start;
        for (int i = start; i <= end; i++) {

            if (in[i] == data) {
                inIndex = i;
                break;
            }
        }
        return inIndex;
    }


    void inorder(Node node) {

        if (node == null)
            return;

        inorder(node.lChild);
        System.out.print(node.data + " ");
        inorder(node.rChild);

    }


    public static void main(String[] args) {

        BuildBinaryTreeFromTraversal tree = new BuildBinaryTreeFromTraversal();
        int in[] = new int[]{7, 4, 2, 14, 12, 17};
        int pre[] = new int[]{14, 4, 7, 2, 17, 12};

        int len = in.length;
        Node root = tree.buidlBinaryTree(pre, in, 0, len - 1);

        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.inorder(root);

    }

}
