import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ua28 on 3/5/20.
 */
public class _7_8_BinaryTree_PrintFromUpToDownWithLines implements TreeTest {

    /**
     * count the number of next level and print line feed when tobePrintedNum becomes 0
     * @param root
     */
    public void printFromUpToDownWithLines(BinaryTreeNode root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        int nextNum = 0;
        int tobePrintedNum = 1;

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            System.out.print(node.val);

            // count nextNum at first
            if (node.left != null) {
                queue.add(node.left);
                nextNum++;
            }

            if (node.right != null) {
                queue.add(node.right);
                nextNum++;
            }

            // then convey to tobePrintedNum
            tobePrintedNum--;
            if (tobePrintedNum == 0) {
                System.out.println();
                tobePrintedNum = nextNum;
                nextNum = 0;
            }
        }
    }

    @Override
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

    @Override
    public void test() {
        printFromUpToDownWithLines(buildTree());
    }

    public static void main(String[] args) {
        new _7_8_BinaryTree_PrintFromUpToDownWithLines().test();
    }
}
