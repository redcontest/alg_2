import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class task_2 {
    private static void bucketSort(double[] numbers) {
        int size = numbers.length;
        if (size == 0) {
            return;
        }

        List<List<Double>> buckets = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            buckets.add(new ArrayList<>());
        }

        for (double number : numbers) {
            if (!Double.isFinite(number) || number < 0.0 || number >= 1.0) {
                throw new IllegalArgumentException("Числа должны принадлежать интервалу [0, 1)");
            }
            int bucketIndex = (int) (number * size);
            buckets.get(bucketIndex).add(number);
        }

        int index = 0;
        for (List<Double> bucket : buckets) {
            bucket.sort(Double::compare);
            for (double number : bucket) {
                numbers[index++] = number;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        if (!scanner.hasNextInt()) {
            return;
        }

        int size = scanner.nextInt();
        if (size < 0) {
            throw new IllegalArgumentException("Размер массива не может быть отрицательным");
        }

        double[] numbers = new double[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextDouble();
        }

        bucketSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
