package practice.美团.美团2024届秋招笔试第一场编程真题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class first {
    private static int num = 0;
    private static List<Double[]> priceList = new ArrayList<>();
    private static Double[] subtraction = new Double[2];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        for (int i = 0; i < num; i++) {
            priceList.add(new Double[]{in.nextDouble(), in.nextDouble()});
        }
        subtraction[0] = in.nextDouble();
        subtraction[1] = in.nextDouble();
        AtomicReference<Double> sum = new AtomicReference<>(0D);
        AtomicReference<Double> pay = new AtomicReference<>(0D);
        for (int i = 0; i < priceList.size(); i++) {
            Double[] c = priceList.get(i);
            if (c[0].compareTo(0d) < 0 || c[1].compareTo(0d) < 0 || c[0] < c[1]) {
                System.out.println("error");
                return;
            }
            sum.updateAndGet(v -> v + c[0]);
            pay.updateAndGet(v -> (v + c[1]));
        }

        if (subtraction[0].compareTo(0d) < 0 || subtraction[1].compareTo(0d) < 0 || subtraction[0].compareTo(subtraction[1]) < 0) {
            System.out.println("error");
            return;
        }

        Double sumValue = sum.get();
        Integer times = (int) (sumValue / subtraction[0]);
        double fullReduction = sumValue - (times > 1 ? 1 : times) * subtraction[1];
        double res = pay.get().compareTo(fullReduction) < 0 ? pay.get() : fullReduction;
        System.out.println(String.format("%.2f", res));
    }
}
