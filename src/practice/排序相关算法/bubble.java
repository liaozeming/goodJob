package practice.排序相关算法;

public class bubble {
    public static void main(String[] args) {
        int[] temp = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        bubble bubble = new bubble();
        bubble.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");

        }
    }

    private void sort(int[] temp) {
        int length = temp.length;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length - i + 1; j++) {
                if (temp[j] < temp[j - 1]) {
                    int pre = temp[j - 1];
                    temp[j - 1] = temp[j];
                    temp[j] = pre;
                }
            }
        }
    }
}
