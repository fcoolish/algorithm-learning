import java.util.*;

/**
 * Created by admin on 2020/6/13.
 */
public class LeetCodeUtil {


    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length ==0 ){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
            int search = target - nums[i];
            if(map.containsKey(search)){
                return new int[]{i,map.get(search)};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
