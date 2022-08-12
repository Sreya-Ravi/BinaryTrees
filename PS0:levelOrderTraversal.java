// -------------------------------------------------
// PS0:levelOrderTraversal
// -------------------------------------------------

// LINK: https://leetcode.com/problems/binary-tree-level-order-traversal/

// --------------------------------------
// P R O B L E M   S T A T E M E N T 

/* Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> al = new ArrayList<>();
        if(root==null) return al;
        lot_post(root,0,al);
        return al;
        
    }
    
    public void lot_post(TreeNode root, int level, List<List<Integer>> al){ // A recursive function for level order traversal using postorder traversal of the tree
        if(root==null) return;
        
        if(!(level<al.size())) al.add(new ArrayList<Integer>()); // Adding a new sub-arrayList to the main arrayList: al, if a new level is encountered.
        lot_post(root.left,level+1,al);
        lot_post(root.right,level+1,al);
        al.get(level).add(root.val);
        return;
    }
}

