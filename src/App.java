import java.util.Arrays;
import java.util.Random; // this creates random for our program
public class App {

    private static int count = 0;
    private static int recursiveIndex = 0;
    private static int minValue = Integer.MAX_VALUE;



    /**
     * This method is used to find the minimum value in an array with the use of a loop.
     * @param arr Takes in an array of integers.
     * @return index Returns the index of the minimum value.
     */
    public static int minFinder(int[] arr){
        int index = 0;

        /** I first tried this code and it absolutely did not work, the logic was wrong.
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length; j++) {
//                if(arr[i]<arr[j]){
//                    index=i;
//                }
//            }
//        }
         * I then tried the code below and it worked.
         */
        if (arr == null || arr.length <= 1) {
            System.out.println("Array needs at least 2 elements to find a minimum.");
            return -1;
        }
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]< min) {
                min = arr[i];
                index=i;
            }
        }
        return index;
    }


    /**
     * This method is used to find the minimum value in an array with the use of recursion.
     * @param arr Takes in an array of integers.
     * @return recursiveIndex Returns the index of the minimum value.
     */
    public static int minFinder_recursive(int[] arr){
        if (arr == null || arr.length <= 1) {
            System.out.println("Array needs at least 2 elements to find a minimum.");
            return -1;
        }
        if (count == arr.length) {
            return recursiveIndex;
        }
        if (arr[count] < minValue) {
            minValue = arr[count];
            recursiveIndex = count;
        }
        count++;
        return minFinder_recursive(arr);

        /**
         * My first attempt at the recursive method is down below. It works, but it is not the most efficient.
         * It had too many if statements and it was not very readable.
         * I had a statement for each condition which was not necessary nor efficient.
         * I then tried to simplify it and it worked. See the code above.
         */

//        if (count != arr.length) {
//        }
//        return recursiveIndex;



//        if (count == 0) {
//            recursiveMin = arr[0];
////            System.out.println("First element is: "+recursiveMin); // For debugging purposes
//            recursiveIndex = count;
//            count++;
//            minFinder_recursive(arr);
//        }
//        if (arr[count]<recursiveMin){
//            if (count == arr.length-1) {
//                System.out.println("Array is sorted, count: "+count); // For debugging purposes
//                return recursiveIndex;
//            }
//            recursiveMin=arr[count];
////            System.out.println("New minimum is: "+recursiveMin+" at index: "+count); // For debugging purposes
//            recursiveIndex=count;
//            count++;
//            minFinder_recursive(arr);
//        }
//        if (arr[count] > recursiveMin) {
//            if (count == arr.length-1) {
//                System.out.println("Array is sorted, count: "+count); // For debugging purposes
//                return recursiveIndex;
//            }
//            count++;
//            minFinder_recursive(arr);
//        }
//        return recursiveIndex;
    }

    public static void main(String[] args) throws Exception {
        int[] myArr = new int[100];
        Random myRand = new Random(); // creating Random object
        // Range for random to select from
        int min = 5;
        int max = 1000;

        int indexMin=0;
        int recursiveIndexMin=0;

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myRand.nextInt(max-min+1) + min; // storing random integers in an array
        }
        // here we check the last item of array to see if it is full:
        System.out.println(myArr[ myArr.length-1]); // printing last element, not the biggest or smallest but just the last one
        System.out.println(Arrays.toString(myArr));
        //now we find the minimum calling the function you wrote:

        // loop
        Chronometer chrono = new Chronometer(); // creating Chronometer object
        chrono.start(); // starting the timer
        indexMin=minFinder(myArr);
        chrono.stop();  // stopping the timer
        System.out.println("Loop: The minimum is at location: "+indexMin+" The value is: "+myArr[indexMin] + " in " + chrono.getDuration() + " ns");

        // recursive
        chrono = new Chronometer(); // creating Chronometer object
        chrono.start(); // starting the timer
        recursiveIndexMin = minFinder_recursive(myArr);
        chrono.stop(); // stopping the timer
        System.out.println("Recursive: The minimum is at location: "+recursiveIndexMin+" The value is: "+myArr[recursiveIndexMin] + " in " + chrono.getDuration() + " ns");
    }
}

/**
 * This class is used to time the execution of a program.
 * It is used to compare the efficiency of the loop and recursive methods.
 * It has a start, stop, isRunning, and getDuration method.
 */
interface ChronometerInterface{
    void start();
    void stop();
    boolean isRunning();
    long getDuration();
}

class Chronometer implements ChronometerInterface {

    private long start;
    private long stop;
    private long duration;
    private boolean isRunning;

    @Override
    public void start() {
        if (isRunning) {
            return;
        }
        this.start = System.nanoTime();
        this.isRunning = true;
    }

    @Override
    public void stop() {
        if (!isRunning) {
            return;
        }
        this.stop = System.nanoTime();
        this.isRunning = false;
    }

    @Override
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override
    public long getDuration() {
        this.duration = this.stop - this.start;
        return this.duration;
    }
}