import java.util.Scanner;

public class PerulanganBintang {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan Input: ");
        int a = input.nextInt();

        for (int b = 1; b <= a; b++) {
            for (int c = a; c >= b; c--) {
                System.out.print(' ');
            }
            for (int d = 1; d <= b; d++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}
