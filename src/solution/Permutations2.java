package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KEKE on 2018/5/14
 */
public class Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        trackBack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void trackBack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used){

        if (tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i=0;i<nums.length;i++){
                if (used[i] == true || (i>0 && nums[i]==nums[i-1] && used[i-1]==false) )
                    continue;
                else {
                    used[i] = true;
                    tempList.add(nums[i]);
                    trackBack(list, tempList, nums, used);
                    used[i] = false;
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args){

        int[] arr = {1,1,2};
        int[] arr1 = {1,1,2,2};
        int[] arr2 = {3,3,0,3};
        System.out.println(new Permutations2().permuteUnique(arr));
        System.out.println(new Permutations2().permuteUnique(arr1));
        System.out.println(new Permutations2().permuteUnique(arr2));
    }
}
