//给定两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
//
// 
//
// 注意：本题与主站 1122 题相同：https://leetcode-cn.com/problems/relative-sort-array/ 
// Related Topics 数组 哈希表 计数排序 排序 
// 👍 23 👎 0

package leetcode.editor.cn;

import java.util.*;

public class ZeroH97ZC{
    public static void main(String[] args){
        Solution solution = new ZeroH97ZC().new Solution();
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        solution.relativeSortArray(arr1,arr2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer,Integer> map = new HashMap<>();
            for(int i= 0;i < arr2.length;i++){
                if(!map.containsKey(arr2[i])){
                    map.put(arr2[i],i);
                }
            }
            List<Integer> listA = new ArrayList<>();
            for(int num:arr1){
                listA.add(num);
            }
            Collections.sort(listA, new Comparator<Integer>() {
                @Override
                public int compare(Integer x, Integer y) {
                    if(map.containsKey(x) || map.containsKey(y)){
                        return map.getOrDefault(x,1001) - map.getOrDefault(y,1001);
                    }else{
                        return x - y;
                    }
                }});
            int[] res = new int[arr1.length];
            for(int i =0;i < listA.size();i++){
                res[i] = listA.get(i);
            }
            return res;
        }

        public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        Map<Integer,Integer>map = new HashMap<>();
        List<Integer>listA = new ArrayList<>();
        List<Integer>listB = new ArrayList<>();
        for(int i= 0;i < arr2.length;i++){
            listB.add(arr2[i]);
        }
        for(int i= 0;i < arr1.length;i++){
            if(!listB.contains(arr1[i])){
                listA.add(arr1[i]);
            }
            map.put(arr1[i],map.getOrDefault(arr1[i],0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < arr2.length;i++){
            int count = map.get(arr2[i]);
            while (count > 0){
                res.add(arr2[i]);
                count--;
            }
        }
        Collections.sort(listA);
        for(int num:listA){
            res.add(num);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}