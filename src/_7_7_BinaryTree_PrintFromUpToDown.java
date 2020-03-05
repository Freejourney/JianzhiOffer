import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ua28 on 3/5/20.
 */
public class _7_7_BinaryTree_PrintFromUpToDown {

    /**
     * Classical Level-Sequence Traverse
     * @param root
     */
    public void printFromUpToDown(BinaryTreeNode root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            System.out.print(node.val);

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(0);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(1);
        BinaryTreeNode node3 = new BinaryTreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;

        return root;
    }

    public void test() {
        printFromUpToDown(buildTree());
    }

    public static void main(String[] args) {
        new _7_7_BinaryTree_PrintFromUpToDown().test();
    }
}
