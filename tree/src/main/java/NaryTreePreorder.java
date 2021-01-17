import model.Node;

import java.util.*;

public class NaryTreePreorder {
    public List<Integer> preorder(Node root) {
        List<Integer> results = new ArrayList<>();

        Deque<Node> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);

            Node n;
            while (stack.size() > 0) {
                n = stack.pop();
                results.add(n.val); // consume root
                for (int i = n.children.size() - 1; i >=0 ; i--) {
                    stack.push(n.children.get(i));
                }
            }
        }
        return results;
    }
}
