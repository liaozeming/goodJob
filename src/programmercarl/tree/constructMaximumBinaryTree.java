package programmercarl.tree;

public class constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        return constructBinaryTree(nums, left, right);
    }

    private TreeNode constructBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        // 最大值
        int index = left;
        int max = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] >= max) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructBinaryTree(nums, left, index - 1);
        root.right = constructBinaryTree(nums, index + 1, right);
        return root;
    }
}
