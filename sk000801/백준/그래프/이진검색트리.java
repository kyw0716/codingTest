package sk000801.백준.그래프;
import java.util.*;

//https://www.acmicpc.net/problem/5639
//전위 순회 -> 뿌리 먼저
//이진 트리에 대해 알아야 풀 수 있는 문제,,
public class 이진검색트리 {
    public static class Node {
        Node left, right;
        int key;
        Node(Node left, Node right, int key) {
            this.left = left;
            this.right = right;
            this.key = key;
        }
        void insert(int num) {
            if(num < this.key) {
                if(this.left == null) this.left = new Node(null, null, num);
                else this.left.insert(num);
            } else {
                if(this.right == null) this.right = new Node(null, null, num);
                else this.right.insert(num);
            }
        }
    }
    public static void postOrder(Node n) {
        if(n == null) return;

        postOrder(n.left);
        postOrder(n.right);
        System.out.println(n.key);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Node root = new Node(null, null, Integer.parseInt(in.nextLine()));
        while(in.hasNextLine()) {
            String input = in.nextLine();
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }
}
