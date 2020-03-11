/**
 * Created by ua28 on 3/11/20.
 */
public class _7_16_BinaryTree_IsBalanced implements TreeTest {

    public boolean isBalanced_Up2Down(BinaryTreeNode root) {
        if (root == null)
            return false;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        if (Math.abs(left - right) > 1)
            return false;

        return isBalanced_Up2Down(root.left) && isBalanced_Up2Down(root.right);
    }

    public boolean isBalanced_Down2Up(BinaryTreeNode root) {
        return false;
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
        return null;
    }

    @Override
    public void test() {
        isBalanced_Up2Down(buildTree());
    }

    public static void main(String[] args) {
        new _7_16_BinaryTree_IsBalanced().test();
    }
}
