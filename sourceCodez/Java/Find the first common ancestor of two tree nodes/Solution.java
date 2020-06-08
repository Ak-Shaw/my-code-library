import java.util.*;
import crio.ds.Tree.TreeNode;

/*
// Definition of TreeNode
public class TreeNode {
    public long val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode (long x) {
        val = x;
        left = null;
        right = null;
    }
}
*/
public class Solution {

    TreeNode ans = null;

    TreeNode commonAncestor(TreeNode root, TreeNode p , TreeNode q) {

        recurseTree(root, p, q);

        return ans;
    }

    boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false

        if (currentNode == null)
            return false;

        // Left recursion. If left recursion returns true, set left = 1 else 0

        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right recursion

        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q

        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // If any two of the flags left, right or mid become true
        if (mid + left + right >= 2)
            this.ans = currentNode; // ans is storing the LCA node

        // Return true if any one of the three bool values is True

        return (mid + left + right > 0);
    }
}
