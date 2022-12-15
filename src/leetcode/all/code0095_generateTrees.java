package leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * 不同的二叉搜索树
 */
public class code0095_generateTrees {

    public static void main(String[] args) {
        code0095_generateTrees demo = new code0095_generateTrees();
        demo.generateTrees(4);
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n < 1) {
            return ans;
        }
        return help(1, n);
    }

    private List<TreeNode> help(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = help(start, i - 1);

            List<TreeNode> rightTree = help(i + 1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
