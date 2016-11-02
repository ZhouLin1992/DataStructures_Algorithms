// Definsition of TreeNode:
// public class TreeNode {
// 	public int val;
// 	public TreeNode left, right;
// 	public TreeNode(int val) {
// 		this.val = val;
// 		this.left = this.right = null;
// 	}
// }

// recursion
public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		preorderTraversal(root, res);
		return res;
	}

	private void preorderTraversal(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}

		// pre-order traversal: root -> left -> right
		res.add(root.val);
		preorderTraversal(root.left, res);
		preorderTraversal(root.right, res);
	}
}