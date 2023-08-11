package sk000801.LEVEL3;
//이걸 내가 풀 수 있을까...
import java.util.*;
public class 길찾기게임 {
    int[][] answer;
    int idx = 0;
    class Node implements Comparable<Node> {
        int num, x, y;
        Node left;
        Node right;
        Node(int num, int x, int y, Node left, Node right) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
        @Override
        public int compareTo(Node n1) {
            if(this.y-n1.y == 0) return this.x-n1.x;
            return n1.y-this.y;
        }
    }
    public void insertNode(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if(parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    public void preOrder(Node root) { //전위순회(루트->왼쪽->오른쪽)
        if(root != null) {
            answer[0][idx++] = root.num;
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void postOrder(Node root) {//후위순회(왼쪽->오른쪽->루트)
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            answer[1][idx++] = root.num;
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null));
        }
        Collections.sort(list);
        
        Node root = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            insertNode(root, list.get(i));
        }
        
        preOrder(root);
        idx = 0;
        postOrder(root);
        
        return answer;
    }
}
