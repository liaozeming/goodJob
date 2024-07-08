package practice.排序相关算法;

public class heap {
    public static void main(String[] args) {
        int[] temp = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        heap heap = new heap();
        heap.heapSort(temp);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }

    public static void heapSort(int[] arr) {
        //1.构建初始堆，arr[0]为最大元素
        buildMaxHeap(arr);
        // 注意这里是i>1 只有三个元素时----最后一次执行
        for (int i = arr.length - 1; i >= 1; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }
    }


    /**
     * 构建最大堆，arr[0] 是最大值
     *
     * @param arr
     */
    public static void buildMaxHeap(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
    }

    /**
     * 调整堆，k 父节点的编号 length: 需要调整的数组的范围的长度从1到length
     *
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && arr[left] > arr[i]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            adjustHeap(arr, largest, length);
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
