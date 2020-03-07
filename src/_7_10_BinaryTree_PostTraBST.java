/**
 * Created by ua28 on 3/7/20.
 */
public class _7_10_BinaryTree_PostTraBST implements TreeTest {

    public boolean verifySequenceBST(int[] sequence, int start, int length) {
        if (sequence == null || length < 0 || start < 0) {
            return false;
        }

        int root = sequence[length-1];

        int i = 0;
        for (; i < length-1; i++) {
            if (sequence[i] > root)
                break;
        }

        int j = i;
        for (; j < length-1; j++) {
            if (sequence[j] < root)
                return false;
        }

        boolean left = true;
        if (i > 0)
            left = verifySequenceBST(sequence, 0, start+1);

        boolean right = true;
        if (j < length-1)
            right = verifySequenceBST(sequence, i, length-i-1);

        return left && right;
    }

    @Override
    public BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node11 = new BinaryTreeNode(11);

        root.left = node6;
        root.right = node10;
        node6.left = node5;
        node6.right = node7;
        node10.left = node9;
        node10.right = node11;

        return root;
    }

    @Override
    public void test() {
        System.out.println(verifySequenceBST(new int[]{5, 7, 6, 9, 11, 10, 8}, 0, 7));
    }

    public static void main(String[] args) {
        new _7_10_BinaryTree_PostTraBST().test();
    }
}
