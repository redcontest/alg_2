import java.util.Arrays;
import java.util.Scanner;

public class task_3 {
    private static void countingSort(int[] ages) {
        int[] counts = new int[121];

        for (int age : ages) {
            if (age < 0 || age > 120) {
                throw new IllegalArgumentException("Возраст должен быть в диапазоне от 0 до 120");
            }
            counts[age]++;
        }

        int index = 0;
        for (int age = 0; age < counts.length; age++) {
            for (int count = counts[age]; count > 0; count--) {
                ages[index++] = age;
            }
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

        int[] ages = new int[size];
        for (int i = 0; i < size; i++) {
            ages[i] = scanner.nextInt();
        }

        countingSort(ages);
        System.out.println(Arrays.toString(ages));
    }
}
