/*
 * Node class 구현 후, 전위, 중위, 후위 연산 메소드 작성
 */
import java.util.*;
import java.io.*;

public class q1991 {
    static Node head = new Node('A', null, null);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insertNode(head, root, left, right);
        }
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
        System.out.println();
    }

    static class Node {
        char data;
        Node left;
        Node right;
        Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void insertNode(Node node, char root, char left, char right) {
        if(node.data == root) { // 'A' == root('A')
            node.left = (left == '.' ? null : new Node(left, null, null)); // left node가 없으면 null, 있으면 노드 삽입
            node.right = (right == '.' ? null : new Node(right, null, null));
        }
        else {
            if(node.left != null) {
                insertNode(node.left, root, left, right);
            }
            if(node.right != null) {
                insertNode(node.right, root, left, right);
            }
        }
    }    

    public static void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
        else return;
    }

    public static void inOrder(Node node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }
        else return;  
    }

    public static void postOrder(Node node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);    
        }
        else return;
    }
}



