import java.util.Stack;

/**
 * Created by ua28 on 3/5/20.
 */
public class _7_9_BinaryTree_PrintFromUpToDownLRRL implements TreeTest {

    /**
     * Two Stacks to implement from left to right traverse alternates with from right to left traverse
     * @param root
     */
    public void printFromUpToDownLRRL(BinaryTreeNode root) {
        if (root == null)
            return;

        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();

        stack1.push(root);

        // used for println()
        int nextLevelNum = 0;
        int tobePrintedNum = 1;

        // flag used to judge odd-even
        boolean flag = true;

        // stacks take turns to work, one works, another saves nodes;
        while (!stack1.empty() || !stack2.empty()) {
            if (flag) {
                BinaryTreeNode node = stack1.pop();
                System.out.print(node.val);

                if (node.left != null) {
                    stack2.push(node.left);
                    nextLevelNum++;
                }
                if (node.right != null) {
                    stack2.push(node.right);
                    nextLevelNum++;
                }

                if (stack1.empty()) {
                    flag = false;
                }
            } else {
                BinaryTreeNode node = stack2.pop();
                System.out.print(node.val);;

                if (node.right != null) {
                    stack1.push(node.right);
                    nextLevelNum++;
                }
                if (node.left != null) {
                    stack1.push(node.left);
                    nextLevelNum++;
                }

                if (stack2.empty()) {
                    flag = true;
                }
            }

            tobePrintedNum--;
            if (tobePrintedNum == 0) {
                System.out.println();
                tobePrintedNum = nextLevelNum;
                nextLevelNum = 0;
            }
        }
    }

    @Override
    public BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node11 = new BinaryTreeNode(11);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;
        node4.left = node8;
        node4.right = node9;

        node9.right = node10;
        node10.left = node11;

        return root;
    }

    @Override
    public void test() {
        printFromUpToDownLRRL(buildTree());
    }

    public static void main(String[] args) {
        new _7_9_BinaryTree_PrintFromUpToDownLRRL().test();
    }
}
