import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    //翻转二叉树
    public BinaryTree.TreeNode invertTree(BinaryTree.TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        BinaryTree.TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }

    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree) {
        if(leftTree == null && rightTree != null || leftTree != null && rightTree == null) {
            return false;
        }
        if(leftTree == null && rightTree == null) {
            return true;
        }
        if(leftTree.val != rightTree.val) {
            return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right) &&
                isSymmetricChild(leftTree.right,rightTree.left);
    }

    //平衡二叉树 时间复杂度：O(N)
    public int getHeight2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTreeHeight = getHeight2(root.left);
        if(leftTreeHeight < 0) {
            return -1;
        }
        int rightTreeHeight = getHeight2(root.right);
        if(leftTreeHeight >= 0 && rightTreeHeight >= 0
                && Math.abs(leftTreeHeight - rightTreeHeight) <= 1) {
            return Math.max(leftTreeHeight,rightTreeHeight) + 1;
        }else {
            return -1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return getHeight2(root) >= 0;
    }

    //创建二叉树
    public int i = 0;
    public TreeNode createTree(String str) {
        char ch = str.charAt(i);
        TreeNode root = null;
        if(ch != '#') {
            root = new TreeNode(ch);
            i++;
            root.left = createTree(str);
            root.right = createTree(str);
        }else {
            i++;
        }
        return root;
    }

    //层序遍历
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    public List<List<Character>> levelOrder2(TreeNode root) {
        List<List<Character>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Character> curRow = new ArrayList<>();
            int size = queue.size();
            while (size != 0) {
                TreeNode cur = queue.poll();
                curRow.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                size--;
            }
            ret.add(curRow);
        }
        return ret;
    }

    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else {
                break;
            }
        }
        //判断队列中剩余的元素是否全为空
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            if (cur != null) {
                return false;
            }else {
                queue.poll();
            }
        }
        return true;
    }

}
