import java.util.Stack;

/**
 * Created by ua28 on 3/16/20.
 */
public class _11_TwoStackToMakeAQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    /**
     *  case 1: stack2 is empty
     *  case 2: stack2 is not empty
     *  case 3: stack1 and stack2 is empty
     * @return
     */
    public int deleteHead() {
        if (!stack2.empty()) {
            return stack2.pop();
        }

        while (!stack1.empty()) {
            int t = stack1.pop();
            stack2.push(t);
        }

        if (stack2.empty())
            return -1;

        return stack2.pop();
    }

    /**
     * Since we only remove elements in Stack2, so we don't need to make any operates with Stack1
     * @param element
     */
    public void appendTail(int element) {
        stack1.push(element);
    }

    public void test() {
        appendTail(1);
        appendTail(2);
        appendTail(3);

        System.out.println(deleteHead());
        System.out.println(deleteHead());

        appendTail(4);

        System.out.println(deleteHead());
        System.out.println(deleteHead());
    }

    public static void main(String[] args) {
        new _11_TwoStackToMakeAQueue().test();
    }
}
