import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class NumberOperations {
    public static void main(String[] args) {
        ArrayList<Number> list = new ArrayList<>();
        list.add(10.5f); list.add(20.3); list.add(30); list.add(40.7f); list.add(50.0); list.add(60.3f); list.add(70); list.add(80.1f); list.add(90.0); list.add(100.9);
        int a = 12;
        double b = 13.78;
        byte c = 123;
        short d = 32655;
        long e = 745787867;
        list.add(e); list.add(d); list.add(c); list.add(b); list.add(a);
        list.add(new BigInteger("12569788595096070"));
        list.add(new BigDecimal("14.999999999999999"));
        System.out.println("All numbers: " + list);
        System.out.print("Rounded numbers: [");
        for (int i = 0; i < list.size(); i++) {
            Number num = list.get(i);
            long rounded = 0;
            if (num instanceof Float || num instanceof Double) {
                rounded = Math.round(num.floatValue());
            } else if (num instanceof Integer || num instanceof Long || num instanceof Byte || num instanceof Short) {
                rounded = num.longValue();
            } else if (num instanceof BigInteger) {
                rounded = ((BigInteger) num).longValue();
            } else if (num instanceof BigDecimal) {
                rounded = ((BigDecimal) num).setScale(0, RoundingMode.HALF_UP).longValue();
            }

            System.out.print(rounded);
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\nAll numbers with two decimal places: [");
        for (int i = 0; i < list.size(); i++) {
            Number num = list.get(i);
            double value = num.doubleValue();

            if (num instanceof BigDecimal) {
                BigDecimal decimalnum = (BigDecimal) num;
                value = decimalnum.setScale(2, RoundingMode.DOWN).doubleValue();
            }
            System.out.printf("%.2f", value);
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        List<Integer> int_num = new ArrayList<>();
        List<Double> double_num = new ArrayList<>();
        List<Float> float_num = new ArrayList<>();
        List<BigInteger> BigInteger_num = new ArrayList<>();
        List<BigDecimal> BigDecimal_num = new ArrayList<>();

        for (Number num : list) {
            if (num instanceof Integer) {
                int_num.add((Integer) num);
            } else if (num instanceof Double) {
                double_num.add((Double) num);
            } else if (num instanceof Float) {
                float_num.add((Float) num);
            } else if (num instanceof BigInteger) {
                BigInteger_num.add((BigInteger) num);
            } else if (num instanceof BigDecimal) {
                BigDecimal_num.add((BigDecimal) num);
            }
        }
        System.out.println("Integer numbers: " + int_num);
        System.out.println("Double numbers: " + double_num);
        System.out.println("Float numbers: " + float_num);
        System.out.println("BigInteger: " + BigInteger_num);
        System.out.println("BigDecimal: " + BigDecimal_num);

        double sum_of_squares = 0;
        for (int i = 0; i < 10; i++) {
            Number num = list.get(i);
            double value = num.doubleValue();
            sum_of_squares += Math.pow(value, 2);
        }
        System.out.println("The sum of the squares of the first 10 numbers: " + sum_of_squares);
    }
}
