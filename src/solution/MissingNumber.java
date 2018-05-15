package solution;

/**
 * Created by KEKE on 2018/5/15
 *
 * Description: Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * Note: Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {

        int n = nums.length;
        if (nums==null || n==0)
            return 0;
        for (int i=0;i<n;i++)
            while (nums[i]<n&&nums[nums[i]]!=nums[i]){
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        for (int i=0;i<n;i++)
            if (nums[i]!=i)
                return i;
        return n;
    }

    public static void main(String[] args){

        int[] arr = {3,2,1};
        int[] arr1 = {9,6,7,4,3,5,2,1,0};
        System.out.println(new MissingNumber().missingNumber(arr));
        System.out.println(new MissingNumber().missingNumber(arr1));
    }
}
