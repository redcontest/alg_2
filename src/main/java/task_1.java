import java.util.Arrays;
import java.util.Scanner;

public class task_1 {
    private static void countingSortByDigit(int[] numbers, int exponent) {
        int[] counts = new int[10];
        int[] output = new int[numbers.length];

        for (int number : numbers) {
            counts[(number / exponent) % 10]++;
        }

        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        for (int i = numbers.length - 1; i >= 0; i--) {
            int digit = (numbers[i] / exponent) % 10;
            output[--counts[digit]] = numbers[i];
        }

        System.arraycopy(output, 0, numbers, 0, numbers.length);
    }

    private static void radixSort(int[] numbers) {
        if (numbers.length == 0) {
            return;
        }

        int maximum = 0;
        for (int number : numbers) {
            if (number < 0 || number > 99_999_999) {
                throw new IllegalArgumentException("Числа должны быть неотрицательными и содержать не более 8 цифр");
            }
            maximum = Math.max(maximum, number);
        }

        for (int exponent = 1; maximum / exponent > 0; exponent *= 10) {
            countingSortByDigit(numbers, exponent);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int size = scanner.nextInt();
        if (size < 0) {
            throw new IllegalArgumentException("Размер массива не может быть отрицательным");
        }

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        radixSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
