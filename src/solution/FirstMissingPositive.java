package solution;

/**
 * Created by KEKE on 2018/5/15
 *
 * Description: Given an unsorted integer array, find the smallest missing positive integer.
 * Note: Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        if (nums==null || nums.length==0)
            return 1;
        for (int i=0;i<nums.length;i++){
            // 大于0 小于等于n
            // 把元素放回本身应该在的位置
            // 注意，一定要先检查nums[i]的范围，否则可能会出现数组越界
            while (nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i] ){
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
        }
        for (int i=0;i<nums.length;i++)
            if (nums[i]!=i+1)
                return i+1;
        return nums.length+1;
    }

    public static void main(String[] args){

        int[] arr = {3,4,1,-1};
        int[] arr1 = {7,8,9,10,11,12};
        System.out.println(new FirstMissingPositive().firstMissingPositive(arr));
        System.out.println(new FirstMissingPositive().firstMissingPositive(arr1));
    }

}
