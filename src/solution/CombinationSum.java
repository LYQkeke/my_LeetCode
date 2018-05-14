package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KEKE on 2018/5/13
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target){

        List<List<Integer>> list = new ArrayList<>();

        trackBack(list, new ArrayList<>(),candidates, target, 0);
        return list;
    }

    private void trackBack(List<List<Integer>> list, List<Integer> tempList,int[] numBox, int target, int start){

        if (target < 0)
            return;
        if (target == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < numBox.length; i++){
                tempList.add(numBox[i]);
                trackBack(list, tempList, numBox, target - numBox[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args){

        int[] arr = {2,3,6,7};
        System.out.println(new CombinationSum().combinationSum(arr, 7));
    }
}
