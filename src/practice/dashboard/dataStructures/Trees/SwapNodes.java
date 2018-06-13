package practice.dashboard.dataStructures.Trees;

import java.util.Scanner;

/**
 * Created by PDeb on 12/27/2017.
 */
public class SwapNodes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfNodes = in.nextInt();

    }

    class Node{
        int val;
        Node left;
        Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
