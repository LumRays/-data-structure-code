public class Test {

    //两棵树是否相同
    public boolean isSameTree(BinaryTree.TreeNode p, BinaryTree.TreeNode q) {
        if((p != null && q == null) || (p == null && q != null)) {
            return false;
        }
        //两个都为空 || 两个都不为空
        if(p == null && q == null) {
            return true;
        }
        //两个都不为空
        if(p.val != q.val) {
            return false;
        }
        //两个都不为空 && 值一样
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    //另一棵树的子树
    public boolean isSubtree(BinaryTree.TreeNode root, BinaryTree.TreeNode subRoot) {
        if(root == null) {
            return false;
        }
        if(isSameTree(root,subRoot)) {
            return true;
        }
        if(isSubtree(root.left,subRoot)) {
            return true;
        }
        if(isSubtree(root.right,subRoot)) {
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        System.out.print("前序遍历：");
        binaryTree.preOrder(root);
        System.out.println();
        System.out.print("中序遍历：");
        binaryTree.inOrder(root);
        System.out.println();
        System.out.print("后序遍历：");
        binaryTree.postOrder(root);
        System.out.println();
        System.out.print("节点个数：");
        binaryTree.size(root);
        System.out.println(BinaryTree.countSize);
        System.out.print("节点个数：");
        System.out.println(binaryTree.nodeSize(root));
        System.out.print("叶子节点的个数：");
        binaryTree.getLeafNodeCount(root);
        System.out.println(BinaryTree.leafCount);
        System.out.print("叶子节点的个数：");
        System.out.println(binaryTree.getLeafNodeCount2(root));
        System.out.print("第三层的节点个数：");
        System.out.println(binaryTree.getKLevelNodeCount(root, 3));
        System.out.print("树的高度：");
        System.out.println(binaryTree.getHeight(root));
        System.out.print("是否存在字符'F'：");
        BinaryTree.TreeNode node = binaryTree.find(root,'F');
        System.out.println(node.val);
    }

}
