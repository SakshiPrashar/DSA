public class assignment {
    public static void main(String[] args) {
       

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left;       
        TreeNode q = root.left.right;  

        LCA lcaSolver = new LCA();
        TreeNode lca = lcaSolver.lowestCommonAncestor(root, p, q);

        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode copy1 = root;
        TreeNode copy2 = root;

        String pathP = path(copy1, p, "");
        String pathQ = path(copy2, q, "");

        int i = 0;
        while (i < pathP.length() && i < pathQ.length() && pathP.charAt(i) == pathQ.charAt(i)) {
            if (pathP.charAt(i) == 'L') {
                root = root.left;
            } else {
                root = root.right;
            }
            i++;
        }

        return root;
    }

    private String path(TreeNode root, TreeNode reach, String x) {
        if (root == null) return "";

        if (root == reach) return "F";

        String left = path(root.left, reach, "L" + x);
        if (left.contains("F")) {
            return "L" + left;
        }

        String right = path(root.right, reach, "R" + x);
        if (right.contains("F")) {
            return "R" + right;
        }

        return "";
    }
}
