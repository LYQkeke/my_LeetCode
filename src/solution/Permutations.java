package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KEKE on 2018/5/14
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        trackBack(list, new ArrayList<>(), nums);
        return list;
    }

    private void trackBack(List<List<Integer>> list, List<Integer> tempList, int[] nums){

        if (tempList.size() == nums.length)
            list.add(new ArrayList<>(tempList));
        else {
            for(int i=0;i<nums.length;i++){
                if (tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                trackBack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args){

        int[] arr = {1,2,3};
        System.out.println(new Permutations().permute(arr));
    }
}
