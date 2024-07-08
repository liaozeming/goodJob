package programmercarl.greedy;

public class jump {
    public int jump(int[] nums) {
        int maxJump = nums[0];
        int curMaxJump = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            boolean flag = false;
            if (i <= curMaxJump) {
                if (!flag) {
                    flag = true;
                    count++;
                }
                maxJump = Math.max(maxJump, nums[i] + i);
                if (maxJump >= nums.length - 1) {
                    return ++count;
                }
            }
            if (i == curMaxJump) {
                curMaxJump = maxJump;
                flag = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        jump jump = new jump();
        jump.jump(nums);
    }
}
