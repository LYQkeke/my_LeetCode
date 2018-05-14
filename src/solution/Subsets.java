package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KEKE on 2018/5/14
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());//添加空集
        trackBack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void trackBack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){

        if (start == nums.length)
            return;
        else {
            for (int i=start;i<nums.length;i++){
                tempList.add(nums[i]);
                list.add(new ArrayList<>(tempList));
                trackBack(list, tempList, nums, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args){

        int[] arr = {1,2,3};
        System.out.println(new Subsets().subsets(arr));
    }
}
