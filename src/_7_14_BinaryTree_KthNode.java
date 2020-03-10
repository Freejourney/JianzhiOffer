import java.io.IOException;

/**
 * Created by ua28 on 3/10/20.
 */
public class _7_14_BinaryTree_KthNode implements TreeTest {

    private int t = 0;
    private BinaryTreeNode node = null;

    public void kthNode(BinaryTreeNode root, int k) {
        if (root == null)
            return;

        Inorder(root, k);
    }

    private void Inorder(BinaryTreeNode root, int k) {
        if (root == null || t == k)
            return;

        Inorder(root.left, k);
        t++;
        if (t == k) {
            this.node = root;
            return;
        }
        Inorder(root.right, k);
    }

    private int l = 0;
    private int testInorder(BinaryTreeNode root, int i) {

        if (root.left != null)
            i = testInorder(root.left, i) + 1;
        l++;
//        i++;
        if (root.right != null)
            i = testInorder(root.right, i) + 1;

        return i;
    }

    @Override
    public BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node8 = new BinaryTreeNode(8);

        root.left = node3;
        root.right = node7;
        node3.left = node2;
        node3.right = node4;
        node7.left = node6;
        node7.right = node8;

        return root;
    }

    @Override
    public void test() {
        kthNode(buildTree(), 3);
        System.out.println(this.node.val);

        int i = 0;
        i = testInorder(buildTree(), i) + 1;
        System.out.println(this.l+"----"+i);
    }

    public static void main(String[] args) {
        new _7_14_BinaryTree_KthNode().test();
    }
}
