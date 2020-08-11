/*
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
假设输入的前序遍历和中序遍历的结果都不含重复的数字。
*/

public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}

class Solution{
    //递归求解，根据子树特点，每轮可确定三个节点(根节点，左子树根节点，右子树根节点)的关系
    public TreeNode buildTree(int[] preorder,int[] inorder){
        if(preorder == null || preorder.length == 0){
            return null;
        }
        Map<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
        int length = preorder.length;
        //通过Map存储中序遍历的每个元素及其对应的下标
        //目的是为了快速获得每一个元素在中序遍历中的位置
        for(int i = 0;i < length;i++){
            indexMap.put(inorder[i],i);//对应下标的值，下标
        }
        TreeNode root = buildTree(preorder,0,length - 1,inorder,0,length - 1,indexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder,int preorderStart,int preorderEnd,int[] inorder,int inorderStart,int inorderEnd,Map<Integer,Integer> indexMap) {
        if(preorderStart > preorderEnd){
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if(preorderStart == preorderEnd){
            return root;
        }else {
            int rootIndex = indexMap.get(rootVal);//在中序遍历中得到根节点的位置
            //得到左子树和右子树各自的下标范围和节点数量
            int leftNodes = rootIndex - inorderStart;
            int rightNodes = inorderEnd - rootIndex;
            //递归重建左子树和右子树
            TreeNode leftSubTree = buildTree(preorder,preorderStart + 1,preorderStart + leftNodes,inorder,inorderStart,rootIndex - 1,indexMap);
            TreeNode rightSubTree = buildTree(preorder,preorderEnd - rightNodes + 1,preorderEnd,inorder,rootIndex + 1,inorderEnd,indexMap);
            //将左右子树的根节点分别作为当前根节点的左右子节点
            root.left = leftSubTree;
            root.right = rightSubTree;
            return root;
        }
    }
}