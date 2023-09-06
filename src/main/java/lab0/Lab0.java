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
     */
    public String ifTask(double a, double b, double c) {
        double[] numbers = new double[]{a, b, c};

        Arrays.sort(numbers);

        return numbers[0] + ", " + numbers[2];
    }

    public static void main(String[] args) {

    }
}
