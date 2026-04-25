public class BinaryTree {

    static class TreeNode {
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode root;//当前二叉树的根节点

    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.right = H;
        C.left = F;
        C.right = G;

        return A;
    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static int countSize = 0;
    // 获取树中节点的个数  遍历思路 O(N)
    public void size(TreeNode root) {
        if (root == null) {
            return;
        }
        countSize++;
        size(root.left);
        size(root.right);
    }

    //子问题思路 整棵树的节点个数 = 左子树的节点个数 + 右子树的节点个数 + 1
    public int nodeSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return nodeSize(root.left) + nodeSize(root.right) + 1;
    }

    public static int leafCount = 0;
    // 获取叶子节点的个数
    public void getLeafNodeCount(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafCount++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
    }

    public int getLeafNodeCount2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    // 获取第K层节点的个数
    public int getKLevelNodeCount(TreeNode root,int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelNodeCount(root.left, k - 1) + getKLevelNodeCount(root.right,k - 1);
    }

    // 获取二叉树的高度
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = getHeight(root.left);
        int rightTreeHeight = getHeight(root.right);
        //return leftTreeHeight > rightTreeHeight ? leftTreeHeight + 1 : rightTreeHeight + 1;
        return Math.max(leftTreeHeight,rightTreeHeight) + 1;
    }

    // 检测值为value的元素是否存在
    public TreeNode find(TreeNode root, char val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode ret = find(root.left,val);
        if (ret != null) {
            return ret;
        }
        TreeNode ret2 = find(root.right,val);
        if (ret2 != null) {
            return ret2;
        }
        return null;
    }

}
