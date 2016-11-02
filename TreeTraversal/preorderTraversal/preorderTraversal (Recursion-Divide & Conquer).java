public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();

		if (root == null) {
			return res;
		}

		// preorder traversal: root -> left -> right
		
		// Divide
		List<Integer> left = preorderTraversal(root.left);
		List<Integer> right = preorderTraversal(root.right);

		// Conquer
		res.add(root.val);
		res.addAll(left);
		res.addAll(right);
		return res;
	}
}