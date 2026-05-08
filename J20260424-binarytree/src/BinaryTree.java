import java.util.*;

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

    //最近公共祖先 - 方法一
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }
        TreeNode leftRet = lowestCommonAncestor(root.left,p,q);
        TreeNode rightRet = lowestCommonAncestor(root.right,p,q);
        if(leftRet != null && rightRet != null) {
            return root;
        }else if(leftRet != null) {
            return leftRet;
        }else {
            return rightRet;
        }
    }

    //找到root这个节点到node这个节点的路径上的所有节点，存储在栈中
    public boolean getPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null) {
            return false;
        }
        stack.push(root);
        if (root == node) {
            return true;
        }
        boolean flg = getPath(root.left,node,stack);
        if (flg) {
            return true;
        }
        flg = getPath(root.right,node,stack);
        if (flg) {
            return true;
        }
        stack.pop();
        return false;
    }

    //- 方法二
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();
        getPath(root,p,stackP);
        getPath(root,q,stackQ);
        int sizeP = stackP.size();
        int sizeQ = stackQ.size();
        int size = sizeP - sizeQ;
        if (size > 0) {
            while (size != 0) {
                stackP.pop();
                size--;
            }
        }else {
            size = sizeQ - sizeP;
            while (size != 0) {
                stackQ.pop();
                size--;
            }
        }
        //此时，两个栈的大小是一样的
        while (!stackP.isEmpty() && !stackQ.isEmpty()) {
            if (stackP.peek().equals(stackQ.peek())) {
                return stackP.peek();
            }
            stackP.pop();
            stackQ.pop();
        }
        return null;
    }

    //二叉树的层序遍历(自下而上)
    public List<List<Character>> levelOrderBottom(TreeNode root) {
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
            ret.add(0,curRow);
        }
        return ret;
    }

    //从前序与中序遍历序列构造二叉树
    /*public int preIndex = 0;

    public int findVal(int[] inorder, int inBegin, int inEnd, int key) {
        for(int i = inBegin;i <= inEnd;i++) {
            if(inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int inBegin, int inEnd) {
        //没有子树
        if(inBegin > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex]);
        //在中序遍历当中，找到当前根节点的位置
        int rootIndex = findVal(inorder,inBegin,inEnd,preorder[preIndex]);
        preIndex++;
        //确定左树和右树
        root.left = buildTreeChild(preorder,inorder,inBegin,rootIndex - 1);
        root.right = buildTreeChild(preorder,inorder,rootIndex + 1,inEnd);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeChild(preorder,inorder,0,inorder.length - 1);
    }*/


    //从中序与后序遍历序列构造二叉树
    /*public int postIndex = 0;

    public int findVal(int[] inorder, int inBegin, int inEnd, int key) {
        for(int i = inBegin;i <= inEnd;i++) {
            if(inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTreeChild(int[] inorder, int[] postorder, int inBegin, int inEnd) {
        //没有子树
        if(inBegin > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        //在中序遍历当中，找到当前根节点的位置
        int rootIndex = findVal(inorder,inBegin,inEnd,postorder[postIndex]);
        postIndex--;
        //确定右树和左树
        root.right = buildTreeChild(inorder,postorder,rootIndex + 1,inEnd);
        root.left = buildTreeChild(inorder,postorder,inBegin,rootIndex - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        return buildTreeChild(inorder,postorder,0,inorder.length - 1);
    }*/

    //根据二叉树创建字符串
    public String tree2str(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        tree2strChild(root,stringBuilder);
        return stringBuilder.toString();
    }

    public void tree2strChild(TreeNode root,StringBuilder stringBuilder) {
        if(root == null) {
            return;
        }
        stringBuilder.append(root.val);
        //root的左子树
        if(root.left != null) {
            stringBuilder.append("(");
            tree2strChild(root.left,stringBuilder);
            stringBuilder.append(")");
        }else{
            if(root.right == null) {
                //左边为空 && 右边也为空
                return;
            }else{
                //左边为空 && 右边不为空
                stringBuilder.append("()");
            }
        }
        //root的右子树
        if(root.right != null) {
            stringBuilder.append("(");
            tree2strChild(root.right,stringBuilder);
            stringBuilder.append(")");
        }else{
            return;
        }
    }

    //二叉树前序递归遍历实现(利用返回值)
    public List<Character> preorderTraversal(TreeNode root) {
        List<Character> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        ret.add(root.val);
        List<Character> listLeft = preorderTraversal(root.left);
        ret.addAll(listLeft);
        List<Character> listRight = preorderTraversal(root.right);
        ret.addAll(listRight);
        return ret;
    }

    //非递归
    public List<Character> preorderTraversalNon(TreeNode root) {
        List<Character> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        TreeNode cur = root;
        TreeNode top = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                //打印
                ret.add(cur.val);
                cur = cur.left;
            }
            top = stack.pop();
            cur = top.right;
        }
        return ret;
    }

    //二叉树中序递归遍历实现(利用返回值) && 非递归
    public List<Character> inorderTraversalNon(TreeNode root) {
        // List<Character> ret = new ArrayList<>();
        // if(root == null) {
        //     return ret;
        // }
        // List<Character> listLeft = inorderTraversalNon(root.left);
        // ret.addAll(listLeft);
        // ret.add(root.val);
        // List<Character> listRight = inorderTraversalNon(root.right);
        // ret.addAll(listRight);
        // return ret;
        // ===============================
        //非递归
        List<Character> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        TreeNode cur = root;
        TreeNode top = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            //打印
            ret.add(top.val);
            cur = top.right;
        }
        return ret;
    }

    //二叉树后序递归遍历实现(利用返回值) && 非递归
    public List<Character> postorderTraversalNon(TreeNode root) {
        // List<Character> ret = new ArrayList<>();
        // if(root == null) {
        //     return ret;
        // }
        // List<Character> listLeft = postorderTraversalNon(root.left);
        // ret.addAll(listLeft);
        // List<Character> listRight = postorderTraversalNon(root.right);
        // ret.addAll(listRight);
        // ret.add(root.val);
        // return ret;
        // ============================================
        //非递归
        List<Character> ret = new ArrayList<>();
        if(root == null) {
            return ret;
        }
        TreeNode cur = root;
        TreeNode top = null;
        TreeNode prev = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.peek();
            if(top.right == null || top.right == prev) {
                stack.pop();
                ret.add(top.val);
                prev = top;
            }else {
                cur = top.right;
            }
        }
        return ret;
    }

}
