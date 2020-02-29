/**
 * Created by ua28 on 2/29/20.
 */
public class _7_2_BinaryTree_RebuildTree {

    /**
     * master
     * @param preorder
     * @param inorder
     * @param length
     * @return
     * @throws Exception
     */
    public BinaryTreeNode Construct(int[] preorder, int[] inorder, int length) throws Exception {
        if (preorder == null || inorder == null || length <= 0)
            return null;

        return ConstructCore(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    /**
     * core
     * @param preorder
     * @param preStartIndex
     * @param preEndIndex
     * @param inorder
     * @param inStartIndex
     * @param inEndIndex
     * @return
     * @throws Exception
     */
    public BinaryTreeNode ConstructCore(int[] preorder, int preStartIndex, int preEndIndex, int[] inorder, int inStartIndex, int inEndIndex) throws Exception {
        int rootValue = preorder[preStartIndex];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);

        if (preStartIndex == preEndIndex) {
            if (inStartIndex == inEndIndex && preorder[preStartIndex] == inorder[inStartIndex])
                return root;
            else
                throw new Exception("Invalid input");
        }

        int rootInorderIndex = inStartIndex;
        while (rootInorderIndex <= inEndIndex && inorder[rootInorderIndex] != rootValue)
            rootInorderIndex++;

        if (rootInorderIndex == inEndIndex && inorder[rootInorderIndex] != rootValue)
            throw new Exception("Invalid input");

        int leftLength = rootInorderIndex - inStartIndex;
        int leftPreEndIndex = preStartIndex + leftLength;

        if (leftLength > 0) {
            root.left = ConstructCore(preorder, preStartIndex+1, leftPreEndIndex, inorder, inStartIndex, rootInorderIndex-1);
        }
        if (leftLength < preEndIndex - preStartIndex) {
            root.right = ConstructCore(preorder, leftPreEndIndex+1, preEndIndex, inorder, rootInorderIndex+1, inEndIndex);
        }

        return root;
    }

    public void preOrder(BinaryTreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(BinaryTreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public void postOrder(BinaryTreeNode root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public void test() {
        try {
            BinaryTreeNode root = Construct(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6}, 8);

            preOrder(root);
            System.out.println();
            inOrder(root);
            System.out.println();
            postOrder(root);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new _7_2_BinaryTree_RebuildTree().test();
    }
}
