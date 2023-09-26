import java.util.Arrays;

public class SisyphusSort {

    private boolean isSorted(int[] array) {
        boolean sorted = true;
        for(int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }
    public SisyphusSort(int[] array) throws InterruptedException {

        if (isSorted(array)) {
            System.out.println("There is nothing I can do.");
            return;
        }

        int oneMustImagineAlgorithmHappy = 0;
        int[] copy = new int[array.length];

        System.arraycopy(array, 0, copy, 0, array.length);

        // start sorting the array...
        for (int i = 0; i < array.length; i++) {
            copy = Arrays.copyOf(array, array.length);

            for (int j = i; j < array.length; j++) {
                if (copy[j] < copy[i]) {
                    copy[j] = copy[i] + copy[j] - (copy[i] = copy[j]);
                }
            }

            // and when the array is almost sorted...
            if (isSorted(copy)) {
                i = -1;
                // mix it up again.
                while (isSorted(copy)) {
                    for (int j = 0; j < array.length; j++) {
                        int r1 = (int) (Math.random() * array.length);
                        int r2 = (int) (Math.random() * array.length);
                        copy[r2] = copy[r1] + copy[r2] - (copy[r1] = copy[r2]);
                    }
                }
            }

            System.arraycopy(copy, 0, array, 0, array.length);

            Thread.sleep(1000);

            System.out.println("Attempts taken to sort: " + oneMustImagineAlgorithmHappy++);
            System.out.println("Current array: " + Arrays.toString(array));
            System.out.println();

        }
    }
    public static void main(String[] args) {
        try {
            new SisyphusSort(new int[]{5, 8, 4, 1, 3, 15, 7, -3, 10});
        } catch (InterruptedException ignored) {}
    }
}
