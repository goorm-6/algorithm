/*
You are given a 0-indexed array nums consisting of positive integers.

There are two types of operations that you can apply on the array any number of times:

Choose two elements with equal values and delete them from the array.
Choose three elements with equal values and delete them from the array.
Return the minimum number of operations required to make the array empty, or -1 if it is not possible.
*/


class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();

            if(count == 1) return -1;
            result += count / 3;
            if(count % 3 != 0) result++;
        }

        return result;
    }
}


/* Time Limit

class Solution {
    public int minOperations(int[] nums) {
        int result = 0;
        int count = 0;
        List<Integer> done = new ArrayList();

        for(int i = 0; i < nums.length; i++){
            List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
            count = Collections.frequency(numsList, nums[i]);

            if(!done.contains(nums[i])){
                if(count == 1) {
                    return -1;
                } else if(count % 3 == 0){
                    result += count / 3;
                } else {
                    result += count / 3 + 1; 
                }
            }
            done.add(nums[i]);
        }
        return result;
    }
} 
*/
