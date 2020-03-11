/**
 * Created by ua28 on 3/11/20.
 */
public class _7_15_BinaryTree_Depth implements TreeTest {

    public int treeDepth(BinaryTreeNode root) {
        if (root == null)
            return 0;

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left > right ? left+1 : right+1;
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
        System.out.println("Depth of Tree: "+treeDepth(buildTree()));
    }

    public static void main(String[] args) {
        new _7_15_BinaryTree_Depth().test();
    }
}
