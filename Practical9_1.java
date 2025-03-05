public class Practical9_1 {

    public static void main(String[] args) {
        int size = 0;
        if(args.length > 0){
            size = Integer.parseInt(args[0]);
        }
        int[] Elements = new int[size];

       
        for (int i = 0; i < size; i++) {
            Elements[i] = (int) (System.nanoTime() % 101); 
        }

        long TotalLoopingTime = 0;
        long TotalRecursionTime = 0;

       
        for (int i = 0; i < Elements.length; i++) {
            int number = Elements[i];

            // Measure time for iterative method
            long startTime = System.nanoTime();
            long TimeForloop = getFact1(number);
            long endTime = System.nanoTime();
            TotalLoopingTime += (endTime - startTime);

            // Measure time for recursive method
            startTime = System.nanoTime();
            long TimeForRecursion = getFact2(number);
            endTime = System.nanoTime();
            TotalRecursionTime += (endTime - startTime);
        }

        
        double AverageLoopingTime = TotalLoopingTime / (double) size;
        double AverageRecursionTime = TotalRecursionTime / (double) size;

        // Output results
        System.out.println("Random Numbers: ");
        for (int i = 0; i < Elements.length; i++) {
            System.out.print(Elements[i] + " ");
        }
        System.out.println("\n");

        System.out.println("Average time taken by Looping: " + AverageLoopingTime + " ns");
        System.out.println("Average time taken by Recursion: " + AverageRecursionTime + " ns");

        if (AverageLoopingTime < AverageRecursionTime) {
            System.out.println("Iterative method performs better.");
        } else if (AverageLoopingTime > AverageRecursionTime) {
            System.out.println("Recursive method performs better.");
        } else {
            System.out.println("Both methods perform equally.");
        }
    }

    // Iterative factorial method
    public static long getFact1(int number) {
        long ans = 1;
        for (int i = number; i > 0; i--) {
            ans *= i;
        }
        return ans;
    }

    // Recursive factorial method
    public static long getFact2(int number) {
        if (number == 0) {
            return 1;
        }
        return number * getFact2(number-1);
    }
}
