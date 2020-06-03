package playground;

public class JavaPlayground {
    public static void main(String[] args) {
        System.out.println("Hello, Java");
        factorialFunction(4);
    }

    public static void factorialFunction(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        System.out.println(factorial);

        /**
         * factorial = 1
         *
         * Step 1:
         * i = 1
         * 1 <= 4 == true
         * factorial = 1 * 1 == 1
         *
         * Step 2:
         * i is incremented to 2
         * 2 <= 4 == true
         * factorial = 1 * 2 == 2
         *
         * Step 3:
         * i is incremented to 3
         * 3 <= 4 == true
         * factorial = 2 * 3 == 6
         *
         * Step 4:
         * i is incremented to 4
         * 4 <= 4 == true
         * factorial = 6 * 4 == 24
         *
         * Step 5:
         * i is incremented to 5
         * 5 <= 4 == false
         * break
         */
    }

}
