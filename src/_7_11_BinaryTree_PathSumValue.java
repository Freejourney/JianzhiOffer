import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ua28 on 3/8/20.
 */
public class _7_11_BinaryTree_PathSumValue implements TreeTest {

    public List<List<Integer>> findEqualValuePath(int expectedSum, BinaryTreeNode root) {
        if (root == null)
            return null;

        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int sum = 0;

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            BinaryTreeNode node = stack.pop();
            path.add(node.val);
            sum += node.val;
            if (node.right == null && node.left == null) {
                if (sum == expectedSum) {
                    paths.add(new ArrayList<>(path));
                }
                path.remove(path.size()-1);
                sum -= node.val;
            }
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return paths;
    }

    /**
     * initial work
     * @param root
     * @param expectedSum
     */
    public void FindPath(BinaryTreeNode root, int expectedSum) {
        if (root == null)
            return;

        List<Integer> path = new ArrayList<>();
        int currentSum = 0;
        FindPath(root, expectedSum, path, currentSum);
    }

    /**
     * For recurisive method, fallback is not necessary.
     * Same initial parameters are transferred into functions, and in the following recurisively transfers, currentSum
     * will gradually increase from small to big for every situation
     * @param root
     * @param expectedSum
     * @param path
     * @param currentSum
     */
    private void FindPath(BinaryTreeNode root, int expectedSum, List<Integer> path, int currentSum) {
        currentSum += root.val;
        path.add(root.val);

        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum == expectedSum && isLeaf) {
            System.out.print("A path is found: ");
            for (int e : path) {
                System.out.print(e+" ");
            }
            System.out.println();
        }

        if (root.left != null)
            FindPath(root.left, expectedSum, path, currentSum);
        if (root.right != null)
            FindPath(root.right, expectedSum, path, currentSum);

        path.remove(path.size()-1);
    }

    @Override
    public BinaryTreeNode buildTree() {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node12 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        root.left = node5;
        root.right = node12;
        node5.left = node4;
        node5.right = node7;

        return root;
    }

    @Override
    public void test() {
        List<List<Integer>> paths = findEqualValuePath(22, buildTree());

        for (int i = 0; i < paths.size(); i++) {
            for (int j = 0; j < paths.get(i).size(); j++) {
                System.out.print(paths.get(i).get(j)+" ");
            }
            System.out.println();
        }

        FindPath(buildTree(), 22);
    }

    public static void main(String[] args) {
        new _7_11_BinaryTree_PathSumValue().test();
    }
}
