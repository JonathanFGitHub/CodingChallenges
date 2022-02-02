import java.util.HashMap;
import java.util.Map;

public class MissingNumber {

    /*
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

    Input: nums = [3,0,1]
    Output: 2

    Input: nums = [0,1]
    Output: 2

    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
    */
    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();

        System.out.println("3,0,1");
        int[] arr1 = new int[] {3,0,1};
        System.out.println(mn.missingNumberWithEquation(arr1));

        System.out.println("0,1");
        int[] arr2 = new int[] {0,1};
        System.out.println(mn.missingNumberWithEquation(arr2));

        System.out.println("9,6,4,2,3,5,7,0,1");
        int[] arr3 = new int[] {9,6,4,2,3,5,7,0,1};
        System.out.println(mn.missingNumberWithEquation(arr3));
    }

    /*
        Steps:
        1. Initialize a Map w. an Integer Key and a Boolean Value.
        2. Set value to true if key exists in array.
        3. Figure out which key has a value set to false.
        4. Return that value.
    */

    public int missingNumber(int[] nums) {
        Map<Integer, Boolean> myMap = new HashMap<Integer, Boolean>();

        for (int i = 0; i < nums.length + 1; i++) {
            myMap.put(i, false);
        }

        for(int i : nums) {
            myMap.replace(i, true);
        }

        for(Map.Entry<Integer,Boolean> entry : myMap.entrySet()) {
            if(!entry.getValue()) {
                return entry.getKey();
            }
        }

        return 1;
    }

    // BEST:

    public int missingNumberWithEquation(int[] nums) {
        /* If the length of the array is 5, then we are expecting to find an array 0,1,2,3,4,5.
        * The below equation gives us the sum of a list of 0-5 ie. 0+1+2+3+4+5 = 15 == (5 (5+1))/2 = 15 */
        int sum = (nums.length * (nums.length + 1))/2;

        for (int i : nums) {
            sum -= i;
        }

        return sum;
    }
}
