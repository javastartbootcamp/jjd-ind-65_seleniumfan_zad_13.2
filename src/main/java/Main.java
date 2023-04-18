import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run(new Scanner(System.in));
    }

    public void run(Scanner scanner) {
        List<Integer> numbers = addReadFromUserNumbersToList(scanner);
        printRevertList(numbers);
        printCalculatedSum(numbers);
        printMinNumber(numbers);
        printMaxNumber(numbers);
    }

    private List<Integer> addReadFromUserNumbersToList(Scanner scanner) {
        List<Integer> numbers = new ArrayList<>();
        int number;
        System.out.println("Podaj liczbę całkowitą dodatnią, albo zakończ program podając liczbę ujemną:");
        while ((number = scanner.nextInt()) > 0) {
            numbers.add(number);
            System.out.println("Podaj kolejną liczbę całkowitą dodatnią, albo zakończ program podając liczbę ujemną:");
        }
        checkPreconditions(numbers);
        return numbers;
    }

    private void printRevertList(List<Integer> numbers) {
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (i != 0) {
                System.out.print(numbers.get(i) + ", ");
            } else {
                System.out.println(numbers.get(i));
            }
        }
    }

    private void printCalculatedSum(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int actualNumber = numbers.get(i);
            sum += actualNumber;

            if (i == numbers.size() - 1) {
                System.out.print(actualNumber + " = " + sum);
            } else {
                System.out.print(actualNumber + " + ");
            }
        }
    }

    private void checkPreconditions(List<Integer> numbers) {
        if (numbers.size() == 0) {
            throw new RuntimeException("Podana lista jest pusta. Nie ma sensu wykonywać dalszych obliczeń");
        }
    }

    private void printMinNumber(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (Integer number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        System.out.print("\nNajmniejsza liczba w liście to " + min);
    }

    private void printMaxNumber(List<Integer> numbers) {
        int max = 0;
        for (Integer number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        System.out.print("\nNajwiększa liczba w liście to " + max);
    }
}
