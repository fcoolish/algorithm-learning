//给你两个数组，arr1 和 arr2，arr2 中的元素各不相同，arr2 中的每个元素都出现在 arr1 中。 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 示例 2: 
//
// 
//输入：arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
//输出：[22,28,8,6,17,44]
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
// Related Topics 数组 哈希表 计数排序 排序 
// 👍 207 👎 0

package leetcode.editor.cn;

import java.util.*;

public class RelativeSortArray{
    public static void main(String[] args){
        Solution solution = new RelativeSortArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            Map<Integer,Integer> map = new HashMap<>();
            List<Integer> listA = new ArrayList<>();
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