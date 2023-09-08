package lab0;

import java.util.Arrays;

public class Lab0 {

    /**
     * Task: Integer14. Дано трехзначное число. В нем зачеркнули первую справа цифру и
     * приписали ее слева. Вывести полученное число.
     *
     * @param number three-digit number (<code>int</code>)
     * @return number where second and third digits were first and second.
     * The third digit becomes the first
     */
    public int integerNumberTask(int number) {
        int rightDigit = (number % 100) % 10;

        number /= 10;

        return rightDigit * 100 + number;
    }

    /**
     * Task: Boolean14. Даны три целых числа: A, B, C. Проверить истинность высказывания:
     * «Ровно одно из чисел A, B, C положительное».
     *
     * @param a integer number
     * @param b integer number
     * @param c integer number
     * @return true, if <font color="red">ONLY ONE</font> number is negative
     */
    public boolean booleanTask(int a, int b, int c) {
        return (String.valueOf(a) + b + c).split("-").length == 2;
    }

    /**
     * Task: If14. Даны три числа. Вывести вначале наименьшее, а затем наибольшее из данных чисел.
     *
     * @param a float number (<code>double</code>)
     * @param b float number (<code>double</code>)
     * @param c float number (<code>double</code>)
     * @return the smallest and the biggest number
     */
    public String ifTask(double a, double b, double c) {
        double[] numbers = new double[]{a, b, c};

        Arrays.sort(numbers);

        return numbers[0] + ", " + numbers[2];
    }

    /**
     * Task: Case14. Элементы равностороннего треугольника пронумерованы следующим образом:
     * 1 — сторона a, 2 — радиус R1 вписанной окружности (R1 = a·(3)1/2/6),
     * 3 — радиус R2 описанной окружности (R2 = 2·R1), 4 — площадь S = a2·(3)1/2/4.
     * Дан номер одного из этих элементов и его значение. Вывести значения остальных
     * элементов данного треугольника (в том же порядке).
     *
     * @param number number of the variable which the user wants to enter
     * @param value value of the selected variable
     * @return triangle side, R1, R2, S
     */
    public String switchTask(int number, int value) {
        double a, r1, r2, s;

        switch (number) {
            case (1) -> {
                a = value;
            }
            case (2) -> {
                r1 = value;
                a = 6 / (r1 * Math.sqrt(3));
            }
            case (3) -> {
                r2 = value;
                a = 6 / ((r2 / 2) * Math.sqrt(3));
            }
            case (4) -> {
                s = value;
                a = Math.sqrt(4 / (s * Math.sqrt(3)));
            }
            default -> {
                a = 0;
            }
        }

        r1 = a * Math.sqrt(3)/ 6;
        r2 = 2 * r1;
        s = Math.pow(a, 2) * Math.sqrt(3) / 4;

        return "a: " + a + "; R1: " + r1 + "; R2: " + r2 + "; S: " + s + ";";
    }

    public static void main(String[] args) {

    }
}
