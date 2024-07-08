package programmercarl.tree;

public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBSTTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildBSTTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBSTTree(nums, left, mid - 1);
        root.right = buildBSTTree(nums, mid + 1, right);
        return root;
    }
}
