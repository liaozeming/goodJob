package programmercarl.other;

public class validMountainArray {
    public boolean validMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                left = i;
            } else {
                break;
            }
        }
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i - 1] > arr[i]) {
                right = i - 1;
            } else {
                break;
            }
        }
        if (left != 0 && right != arr.length - 1 && left == right) {
            return true;
        }
        return false;
    }
}
