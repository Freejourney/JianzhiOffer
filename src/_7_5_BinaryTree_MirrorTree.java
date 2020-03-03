import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ua28 on 3/3/20.
 */
public class _7_5_BinaryTree_MirrorTree {

    public void mirrorRecursively(BinaryTreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            return;

        BinaryTreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        if (root.left != null)
            mirrorRecursively(root.left);

        if (root.right != null)
            mirrorRecursively(root.right);
    }


    public void showTree(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        int expectedNum = 1;
        int currentLevelNum = 0;
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.remove();
            System.out.print(node.val+" ");
            currentLevelNum ++;

            if (currentLevelNum == expectedNum) {
                System.out.println();
                currentLevelNum = 0;
                expectedNum *= 2;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    public BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node1 = new BinaryTreeNode(6);
        BinaryTreeNode node2 = new BinaryTreeNode(10);
        BinaryTreeNode node3 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        return root;
    }

    public void test() {
        BinaryTreeNode root = buildTree();

        showTree(root);

        mirrorRecursively(root);

        showTree(root);
    }

    public static void main(String[] args) {
        new _7_5_BinaryTree_MirrorTree().test();
    }
}

