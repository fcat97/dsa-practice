package book.goodrich.dsa.ch3;

import java.util.Random;

/**
 *  Write a Java method that repeatedly selects and removes a
 *  random entry from an array until the array holds no more
 *  entities.
 */
public class R_3_2 {
    public static void main(String[] args) {
        R_3_2 r32 = new R_3_2();

        try {
            for (int i = 0; i < 100; i++) {
                r32.solution();
            }
            System.out.println("test passed");
        } catch (Exception e) {
            System.out.println("test failed!");
            throw e;
        }
    }

    private void solution() {
        Random random = new Random();
        int[] array = new int[random.nextInt(1, 100)];

        // add items to array.
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        // print original array
        printArray(array);

        // remove one item randomly in each iteration.
        while (array.length > 0) {
            int[] modifiedArray = new int[array.length - 1];

            // get a random index for deletion
            int randIndex = 0;
            if (array.length > 1) randIndex = random.nextInt(array.length - 1);

            int j = 0;
            for (int i = 0; i < array.length; i++) {
                // take all the element except the index marked for deletion
                if (i != randIndex) {
                    modifiedArray[j] = array[i];
                    j++;
                }
            }
            array = modifiedArray;
            printArray(array);
        }
    }

    private void printArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            stringBuilder.append(", ");
        }
        if (stringBuilder.length() > 1) stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        if (stringBuilder.length() > 1) stringBuilder.deleteCharAt( stringBuilder.length() - 1);
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }
}
