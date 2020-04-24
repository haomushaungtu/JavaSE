package m_algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * #1给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 </br>
 * 示例:</br>
 * 给定 nums = [2, 7, 11, 15], target = 9 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回
 * [0, 1]
 * 
 * @author huanghao
 *
 */
public class A_SumSolution {
    public int[] twoSum(int[] nums, int target) {
        int[] resultNum = { 0, 0 };
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(nums[i])) {
                resultNum[0] = resultMap.get(nums[i]);
                resultNum[1] = i;
                return resultNum;
            }
            resultMap.put(target - nums[i], i);
        }
        return resultNum;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 4, 3, 0 };
        int target = 0;
        A_SumSolution s1 = new A_SumSolution();
        System.out.println(s1.twoSum(nums, target)[0]);
        System.out.println(s1.twoSum(nums, target)[1]);
    }
}