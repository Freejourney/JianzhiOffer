/**
 * Created by ua28 on 3/11/20.
 */
public class _7_16_BinaryTree_IsBalanced implements TreeTest {

    /**
     * Balanced Binary Tree
     *
     * get depth of nodes from root to leaves
     *
     * @param root
     * @return
     */
    public boolean isBalanced_Up2Down(BinaryTreeNode root) {
        if (root == null)
            return false;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left - right) > 1)
            return false;

        return isBalanced_Up2Down(root.left) && isBalanced_Up2Down(root.right);
    }


    private boolean res = true;
    /**
     * Balanced Binary Tree
     *
     * get depth of nodes from leaves to root
     *
     * @param root
     * @return
     */
    public boolean isBalanced_Down2Up(BinaryTreeNode root) {
       if (root == null)
           return false;

        isBalancedHelper(root);

        return res;
    }

    /**
     * fuse getDepth method with comparing depth process
     * the function can compare left depth with right depth
     * when nodes calculate depth from leaves to root
     * @param root
     * @return
     */
    private int isBalancedHelper(BinaryTreeNode root) {
        if (root == null)
            return 0;

        int left = isBalancedHelper(root.left) + 1;
        int right = isBalancedHelper(root.right) + 1;

        if (Math.abs(left - right) > 1)
            res = false;

        return left > right ? left : right;
    }

    public int getDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;

        int left = getDepth(root.left) + 1;
        int right = getDepth(root.right) + 1;

        return left > right ? left : right;
    }

    @Override
    public BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);

        root.left = node2;
        node2.right = node3;

        return root;
    }

    @Override
    public void test() {
        System.out.println(isBalanced_Up2Down(buildTree()));
        System.out.println(isBalanced_Down2Up(buildTree()));
    }

    public static void main(String[] args) {
        new _7_16_BinaryTree_IsBalanced().test();
    }
}
