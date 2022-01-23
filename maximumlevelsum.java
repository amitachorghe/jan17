
import java.util.LinkedList;
import java.util.Queue;

class maximumlevelsum {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    };

    static int maxLevelSum(Node root) {

        if (root == null)
            return 0;

        int result = root.data;

        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {

            int count = q.size();

            int sum = 0;
            while (count-- > 0) {

                Node temp = q.poll();

                sum = sum + temp.data;

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }

            result = Math.max(sum, result);
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(10);

        /*
         * Constructed Binary tree is:
         * 1
         * / \
         * 2 5
         * / \ \
         * 4 9 8
         * / \
         * 6 10
         */
        System.out.println("Maximum level sum is " +
                maxLevelSum(root));
    }
}
