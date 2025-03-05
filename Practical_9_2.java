public class Practical_9_2 {
    public static void main(String[] args) {
        int arraySize = 10;
        if (args.length > 0) {
            try {
                arraySize = Integer.parseInt(args[0]);
                if (arraySize <= 0) {
                    System.out.println("Array size must be greater than 0. Using default size: 10");
                    arraySize = 10;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer. Using default size: 10");
            }
        }

        String[] strings = new String[arraySize];

        for (int i = 0; i < arraySize; i++) {
            strings[i] = "Str" + (Math.abs(System.nanoTime()) % 51);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long startTime, endTime, totalStringTime = 0, totalStringBufferTime = 0, totalStringBuilderTime = 0;

        for (String s : strings) {
            String str = "";
            startTime = System.nanoTime();
            str += s;
            endTime = System.nanoTime();
            totalStringTime += (endTime - startTime);
        }
        double avgStringTime = (double) totalStringTime / arraySize;

        for (String s : strings) {
            StringBuffer stringBuffer = new StringBuffer();
            startTime = System.nanoTime();
            stringBuffer.append(s);
            endTime = System.nanoTime();
            totalStringBufferTime += (endTime - startTime);
        }
        double avgStringBufferTime = (double) totalStringBufferTime / arraySize;

        for (String s : strings) {
            StringBuilder stringBuilder = new StringBuilder();
            startTime = System.nanoTime();
            stringBuilder.append(s);
            endTime = System.nanoTime();
            totalStringBuilderTime += (endTime - startTime);
        }
        double avgStringBuilderTime = (double) totalStringBuilderTime / arraySize;

        System.out.println("Array Size: " + arraySize);
        System.out.println("Average time taken by String (+): " + avgStringTime + " ns");
        System.out.println("Average time taken by StringBuffer (append): " + avgStringBufferTime + " ns");
        System.out.println("Average time taken by StringBuilder (append): " + avgStringBuilderTime + " ns");

        if (avgStringTime < avgStringBufferTime && avgStringTime < avgStringBuilderTime) {
            System.out.println("String (+) is more efficient.");
        } else if (avgStringBufferTime < avgStringTime && avgStringBufferTime < avgStringBuilderTime) {
            System.out.println("StringBuffer is more efficient.");
        } else {
            System.out.println("StringBuilder is more efficient.");
        }
    }
}
