import java.util.Scanner;



public class BigNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first big number(If you want to perform the subtract operator, be sure to put the negative): ");

        String num1 = scanner.nextLine();

        System.out.print("Enter the second big number(If you want to perform the subtract operator, be sure to put the negative): ");

        String num2 = scanner.nextLine();
        boolean isNegative1 = num1.startsWith("-");
        boolean isNegative2 = num2.startsWith("-");
        if (isNegative1) {
            num1 = num1.substring(1);
        }
        if (isNegative2) {
            num2 = num2.substring(1);
        }

        int[] arr1 = stringToArr(num1);
        int[] arr2 = stringToArr(num2);
        if (isNegative1 && isNegative2) {
            System.out.print("The result is: -");
            int[] result1 = addArrays(arr1, arr2);
            printArray(result1);

        }
        if (!isNegative1 && !isNegative2) {
            System.out.print("The result is: +");
            int[] result1 = addArrays(arr1, arr2);
            printArray(result1);

        }
        if (!isNegative1 && isNegative2) {
            System.out.println("The result is:");
            int[] result2 = subtractArrays(arr1, arr2);
            printArray(result2);

        }
        if (isNegative1 && !isNegative2) {
            System.out.println("The result is:");
            int[] result2 = subtractArrays(arr2, arr1);
            printArray(result2);

        }
    }

    public static int[] stringToArr(String num) {

        int[] arr = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {

            arr[i] = num.charAt(i) - '0';

        }
        return arr;

    }

    public static int[] addArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[Math.max(n1, n2) + 1];
        int i = n1 - 1, j = n2 - 1, k = result.length - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {

            int sum = carry;

            if (i >= 0) sum += arr1[i];
            if (j >= 0) sum += arr2[j];
            result[k] = sum % 10;
            carry = sum / 10;
            i--;
            j--;
            k--;
        }

        if (carry > 0) {
            result[k] = carry;

        }
        return result;

    }

    public static int[] subtractArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[Math.max(n1, n2)];
        int i = n1 - 1, j = n2 - 1, k = result.length - 1;
        int borrow = 0;

        if (isSmaller(arr1, arr2)) {
            System.out.print("-");
            return subtractArrays(arr2, arr1);

        }
        while (i >= 0 || j >= 0) {

            int diff = borrow;

            if (i >= 0) diff += arr1[i];

            if (j >= 0) diff -= arr2[j];

            if (diff < 0) {

                diff += 10;

                borrow = -1;

            } else {

                borrow = 0;

            }

            result[k] = diff;

            i--;

            j--;

            k--;

        }


        return result;

    }

    public static boolean isSmaller(int[] arr1, int[] arr2) {

        int n1 = arr1.length, n2 = arr2.length;

        if (n1 < n2) return true;

        if (n1 > n2) return false;

        for (int i = 0; i < n1; i++)

            if (arr1[i] < arr2[i])

                return true;

            else if (arr1[i] > arr2[i])

                return false;

        return false;

    }


    public static void printArray(int[] arr) {
        if (arr[0] == 0) {
            for (int i = 1; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            if (arr[0] != 0) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i]);
                }
            }

            System.out.println();

        }
    }
}



