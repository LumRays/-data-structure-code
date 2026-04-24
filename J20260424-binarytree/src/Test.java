public class Test {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();
        System.out.print("前序遍历：");
        binaryTree.preOrder(root);
        System.out.println();
    }

}
