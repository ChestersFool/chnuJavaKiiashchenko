package lab0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lab0 {

    /**
     * Task: Integer14. Дано трехзначное число. В нем зачеркнули первую справа цифру и
     * приписали ее слева. Вывести полученное число.
     *
     * @param number three-digit number (<code>int</code>)
     * @return number where second and third digits were first and second.
     * The third digit becomes the first
     */
    public static int integerNumberTask(int number) {
        int rightDigit = (number % 100) % 10;

        return rightDigit * 100 + number / 10;
    }

    /**
     * Task: Boolean14. Даны три целых числа: A, B, C. Проверить истинность высказывания:
     * «Ровно одно из чисел A, B, C положительное».
     *
     * @param a integer number
     * @param b integer number
     * @param c integer number
     * @return true, if <font color="red">ONLY ONE</font> number is positive
     */
    public static boolean booleanTask(int a, int b, int c) {
        return (String.valueOf(a) + b + c).split("-").length == 3;
    }

    /**
     * Task: If14. Даны три числа. Вывести вначале наименьшее, а затем наибольшее из данных чисел.
     *
     * @param a float number (<code>double</code>)
     * @param b float number (<code>double</code>)
     * @param c float number (<code>double</code>)
     * @return the smallest and the biggest number
     */
    public static double[] ifTask(double a, double b, double c) {
        double[] numbers = new double[]{a, b, c};

        Arrays.sort(numbers);

        return new double[]{numbers[0], numbers[2]};
    }

    /**
     * //Task: Case14. Элементы равностороннего треугольника пронумерованы следующим образом:
     * 1 — сторона a, 2 — радиус R1 вписанной окружности (R1 = a·(3)1/2/6),
     * 3 — радиус R2 описанной окружности (R2 = 2·R1), 4 — площадь S = a2·(3)1/2/4.
     * Дан номер одного из этих элементов и его значение. Вывести значения остальных
     * элементов данного треугольника (в том же порядке).
     *
     * @param number number of the variable which the user wants to enter
     * @param value  value of the selected variable
     * @return triangle side, R1, R2, S
     */
    public static double[] switchTask(int number, double value) {
        double a, r1, r2, s;

        switch (number) {
            case (1) -> {
                a = value;
                r1 = a * Math.sqrt(3) / 6;
                r2 = 2 * r1;
                s = Math.pow(a, 2) * Math.sqrt(3) / 4;
            }
            case (2) -> {
                r1 = value;
                a = 6 / Math.sqrt(3) * r1;
                r2 = 2 * r1;
                s = Math.pow(a, 2) * Math.sqrt(3) / 4;
            }
            case (3) -> {
                r2 = value;
                r1 = r2 / 2;
                a = 6 / Math.sqrt(3) * r1;
                s = Math.pow(a, 2) * Math.sqrt(3) / 4;
            }
            case (4) -> {
                s = value;
                a = Math.sqrt(4 / Math.sqrt(3) * s);
                r1 = a * Math.sqrt(3) / 6;
                r2 = 2 * r1;
            }
            default -> {
                a = 0;
                r1 = 0;
                r2 = 0;
                s = 0;
            }
        }
        return new double[]{a, r1, r2, s};
    }

    /**
     * Task: For14. Дано целое число N (> 0). Найти квадрат данного числа, используя для его вычисления
     * следующую формулу: N2 = 1 + 3 + 5 + … + (2·N – 1).
     * После добавления к сумме каждого слагаемого выводить текущее значение суммы
     * (в результате будут выведены квадраты всех целых чисел от 1 до N).
     *
     * @param n is integer number
     * @return n raised to power of two
     */
    public static List<Integer> forTask(int n) {
        assert n > 0 : "Argument should be more than zero";
        int sum = 0;
        ArrayList<Integer> powers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            sum += 2 * i - 1;
            powers.add(sum);
        }

        return powers;
    }

    /**
     * Task: While14. Дано число A (> 1). Вывести наибольшее из целых чисел K,
     * для которых сумма 1 + 1/2 + … + 1/K будет меньше A, и саму эту сумму.
     *
     * @param a float number (<code>double</code>)
     * @return the biggest number K and the sum of 1 + 1/2 + … + 1/K
     */
    public static double[] whileTask(double a) {
        assert a > 1 : "Argument should be more than one";

        int i = 1;
        double sum = 0;

        //noinspection StatementWithEmptyBody
        while ((sum += (double) 1 / i++) < a) {
//            sum += 1 / i++;
        }

        return new double[]{(i - 1), sum};
    }

    /**
     * //Task: Minmax14. Дано число B (> 0) и набор из десяти чисел. Вывести минимальный из тех элементов набора,
     * которые больше B, а также его номер. Если чисел, больших B, в наборе нет, то дважды вывести 0.
     */
    public static String minmaxTask(double b, double[] numbers) {
        assert b > 0 : "Argument should be more than zero";
        assert numbers.length == 10 : "Array need to contains 10 numbers";
        double minmax = numbers[0];
        int minmaxIndex = 0;

        for (int i = 1, size = numbers.length; i < size; i++) {
            if (numbers[i] > b && minmax > numbers[i]) {
                minmax = numbers[i];
                minmaxIndex = i;
            }
        }

        if (minmax < b) {
            return "0, 0";
        }

        return "minmax: " + minmax + "; index: " + minmaxIndex;
    }

    /**
     * Task: Array14. Дан массив A размера N. Вывести вначале его элементы с четными номерами
     * (в порядке возрастания номеров), а затем — элементы с нечетными номерами (также в порядке возрастания номеров):
     * A2,    A4,    A6,    …,    A1,    A3,    A5,    … .
     * Условный оператор не использовать.
     */
    public static double[] arrayTask(double[] a) {
        int size = a.length;
        int j = 0;
        double[] res = new double[size];

        for (int i = 1; i < size; i += 2) {
            res[j++] = a[i];
        }

        for (int i = 0; i < size; i += 2) {
            res[j++] = a[i];
        }

        return res;
    }

    /**
     * Task: Matrix14. Дана квадратная матрица A порядка M. Начиная с элемента A[1,1],
     * вывести ее элементы следующим образом ("уголками"): все элементы первого столбца; элементы последней строки,
     * кроме первого (уже выведенного) элемента; оставшиеся элементы второго столбца;
     * оставшиеся элементы предпоследней строки и т. д.; последним выводится элемент A[1,M].
     *
     * @param array
     * @return
     */
    public static String twoDimensionArrayTask(int[][] array) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length - i; j++) {
                System.out.print(array[j][i] + ", ");
            }

            System.out.println();

            for (int j = i + 1; j < array[0].length; j++) {
                System.out.print(array[array[0].length - 1 - i][j] + ", ");
            }

            System.out.println();
        }

        return "";
    }

    public static void main(String[] args) {
        twoDimensionArrayTask(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
