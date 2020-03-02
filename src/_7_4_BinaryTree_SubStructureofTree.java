/**
 * Created by ua28 on 3/2/20.
 */
public class _7_4_BinaryTree_SubStructureofTree {

    class BinaryTreeNode {
        double val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (Equal(root1.val, root2.val))
                result = DoesTree1HaveTree2(root1, root2);
            if (!result)
                result = hasSubtree(root1.left, root2);
            if (!result)
                result = hasSubtree(root1.right, root2);
        }

        return result;
    }

    public boolean DoesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;

        if (!Equal(root1.val, root2.val))
            return false;

        return DoesTree1HaveTree2(root1.left, root2.left) && DoesTree1HaveTree2(root1.right, root2.right);
    }

    public boolean Equal(double num1, double num2) {
        if ((num1 - num2 > -1E-7)&&(num1 - num2) < 1E-7 ) {
            return true;
        } else {
            return false;
        }
    }

    public BinaryTreeNode buildTree1() {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(7);
        BinaryTreeNode node3 = new BinaryTreeNode(9);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        return root;
    }

    public BinaryTreeNode buildTree2() {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node1 = new BinaryTreeNode(9);
        BinaryTreeNode node2 = new BinaryTreeNode(2);

        root.left = node1;
        root.right = node2;

        return root;
    }

    public void test() {
        System.out.print(hasSubtree(buildTree1(), buildTree2()));
    }

    public static void main(String[] args) {
        new _7_4_BinaryTree_SubStructureofTree().test();
    }
}
