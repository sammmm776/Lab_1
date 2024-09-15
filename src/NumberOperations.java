import java.util.ArrayList;

public class NumberOperations {

    public static void main(String[] args) {
        ArrayList <Float> list = new ArrayList<>();
        list.add(10f); list.add(20.5f); list.add(30f); list.add(40.7f); list.add(50f); list.add(60.3f); list.add(70f); list.add(80.1f); list.add(90f); list.add(100.9f);
        ArrayList<Float> originalList = new ArrayList<>(list);
        System.out.println("All numbers: " +list);
        System.out.print("Rounded numbers: [");
        double sum = 0;
        for (int i = 0; i < list.size(); i++){
            int rounded  = Math.round(list.get(i));
            System.out.print(rounded);
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\nFractional numbers with 2 decimal places: [");
        for (int i = 0; i < list.size(); i++){
            String fractional  = String.format("%.2f", list.get(i));
            System.out.print(fractional);
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\nInt numbers: [");
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) % 1 == 0) {
                Float removed = list.remove(i);
                i--;
                System.out.print(removed);
                if (i < list.size() - i - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println("]\nFloat numbers: " + list);
        list = new ArrayList<>(originalList);
        for (int i = 0; i < list.size(); i++){
            double square = Math.pow(list.get(i), 2);
            sum += square;
            }
        System.out.printf("The sum of the squares of all numbers: %.2f%n", sum);
        }
    }