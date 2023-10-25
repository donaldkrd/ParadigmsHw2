import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Условие На вход подается число n.
 * Задача Написать скрипт в любой парадигме, который выводит на экран таблицу умножения всех чисел от 1 до n.
 * Обоснуйте выбор парадигм.
 * Пример вывода:
 * 1 * 1 = 1
 * 1 * 2 = 2
 * 1 * 3 = 3
 * 1 * 4 = 4
 * 1 * 5 = 5
 * 1 * 6 = 6
 * ..
 * 1 * 9 = 9
 */
public class Main {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        /**
         * Парадигмы: Структурная - использовал в методе получения значения n,
         * и для вывода таблицы умножения на экран - есть цикл, нет goto.
         * Процедурная - так как запрашиваемое значение может быть не корректно введено,
         * решил это выделить в отдельную функцию, и распечатывание таблицы умножения.
         */
        int n = getN();
        printTableMultiplying(n);
    }
    public static int getN() {
        System.out.print("Введите число n: ");
        int n;
        if (scan.hasNextInt()) {
            n = scan.nextInt();
        } else if (scan.hasNextDouble()) {
            n = (int) scan.nextDouble();
        }else {
            throw new InputMismatchException("Вы ввели не число");
        }
        if (n < 0) n = n * (-1);
        return n;
    }
    public static void printTableMultiplying(int n){
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (j == n) {
                    System.out.printf("%d * %d = %d", i, j, i * j);
                } else {
                    if (i * j > 9) {
                        System.out.printf("%d * %d = %d |  ", i, j, i * j);
                    } else {
                        System.out.printf("%d * %d = %d  |  ", i, j, i * j);
                    }
                }
            }
            System.out.println();
        }
    }
}