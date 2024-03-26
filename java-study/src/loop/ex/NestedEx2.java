package loop.ex;

public class NestedEx2 {
    public static void main(String[] args) {

        // 마름모 그리기
        int rows = 5;
        int maxWidth = rows *2 -1;

        for (int i = 0; i < rows; i++) {
            for (int j = rows -1; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i *2 +1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < rows -1; i++) {
            for (int j = 0; j < i +1; j++) {
                System.out.print(" ");
            }
            for (int k = maxWidth -2; k > i *2; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
