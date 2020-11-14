package Day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * https://leetcode.com/problems/combination-sum/submissions/
 * @author amjain
 *
 */

public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum obj = new CombinationSum();
		System.out.println(obj.combinationSum(new int[]{2,3,6,7}, 7));
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinationsToTarget(candidates,target,new ArrayList<Integer>(),result,0);
        return result;
    }
    
    
    public void findCombinationsToTarget(int[] candidates,int target,ArrayList<Integer> combinations,List<List<Integer>> result,int startIndex){
    
        if(target==0){
            result.add(new ArrayList<>(combinations));
        }
        
        for(int i=startIndex;i<candidates.length;i++){
        	System.out.println("i = "+i+" combination = "+combinations.toString());
        	if(candidates[i]>target){
        		break;
        	}
        	combinations.add(candidates[i]);
        	findCombinationsToTarget(candidates,target-candidates[i],combinations,result,i);
        	combinations.remove(combinations.size()-1);
        }
        
    }
}
