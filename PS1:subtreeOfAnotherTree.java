// -------------------------------------------------
// PS0:subtreeOfAnotherTree
// -------------------------------------------------

// LINK : https://leetcode.com/problems/subtree-of-another-tree/

// --------------------------------------
// P R O B L E M   S T A T E M E N T 

/* Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and 
false otherwise. A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. 
The tree tree could also be considered as a subtree of itself. 
Input is given as a list of integers, denoting the data of the nodes of the tree, level wise( srating from root) from left to right at each level.

Example 1:

Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:

Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
 

Constraints:
The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
*/



// --------------------------------------
// S O L U T I O N   I N   J A V A 


/* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    ArrayList <TreeNode> arr = new ArrayList<>();
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        findRoots(root,subRoot);
        // System.out.println(arr.size());
        for(int i=0;i<arr.size();i++){
            // System.out.println(arr.get(i).val);
            if(isSameTree(arr.get(i),subRoot)) return true;
        }
        return false;
    }
    
    public void findRoots (TreeNode root, TreeNode subRoot){
        if(root==null) return;
        if(root.val==subRoot.val) {
            // System.out.println("infoerng");
            arr.add(root);
        }
        findRoots(root.left,subRoot);
        findRoots(root.right,subRoot);
    }
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val!=root2.val) return false;
        // else return true;
        return isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
    }
}

// --------------------------------------
