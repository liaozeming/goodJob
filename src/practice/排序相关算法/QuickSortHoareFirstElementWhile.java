package practice.排序相关算法;

public class QuickSortHoareFirstElementWhile {

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex); // 注意这里是 `pivotIndex`
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[low]; // 选择第一个元素作为枢轴
        int left = low; // `left` 初始化为 `low`
        int right = high; // `right` 初始化为 `high`

        while (true) {
            // 使用 `while` 循环移动 `left`，找到不小于枢轴的元素
            while (left <= right && array[left] < pivot) {
                left++;
            }

            // 使用 `while` 循环移动 `right`，找到不大于枢轴的元素
            while (left <= right && array[right] > pivot) {
                right--;
            }

            // 当左右指针相遇时，返回 `right` 作为分区点
            if (left >= right) {
                return right;
            }

            // 交换 `left` 和 `right` 指向的元素
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // 移动指针以继续分区
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 8, 10, 1, 2, 1};
        System.out.println("排序前:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("排序后:");
        printArray(array);
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
