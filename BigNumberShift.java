import java.util.Scanner;

public class BigNumberShift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a big number: ");
        String bigNumber = scanner.nextLine();

        System.out.print("enter a shift amount: ");
        int shiftAmount = scanner.nextInt();
        while (shiftAmount < 0) {
            System.out.print("this number must be positive");
            shiftAmount = scanner.nextInt();
        }
        String shiftedLeft = shiftLeft(bigNumber, shiftAmount);
        System.out.println("left shift:" + shiftedLeft);

        String shiftedRight = shiftRight(bigNumber, shiftAmount);
        System.out.println("right shift:" + shiftedRight);

        scanner.close();
    }

    public static String shiftLeft(String number, int shiftAmount) {
        for (int i = 0; i < shiftAmount; i++) {
            number = number + '0';
        }
        return number;
    }
    public static String shiftRight(String number, int shiftAmount) {
        for (int i = 0; i < shiftAmount; i++) {
        number = '0' + number.substring(0, number.length() - 1);
    }
    return number;
}
    }

