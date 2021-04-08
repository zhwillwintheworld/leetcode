//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5271 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 最终版 借鉴别人的想法 实现的，无论写什么方法都要考虑是否可以优化
        //	执行耗时:2ms,击败了100.00% 的Java用户

        int[] storage = new int[128];
        int start = 0,maxLength = 0;
        for (int i = 1; i <= s.length() ; i++) {
            int current = s.charAt(i-1);
            start = Math.max(start,storage[current]);
            maxLength = Math.max(maxLength,i-start);
            storage[current] = i;
        }
        return maxLength;

        // 整合别人的一些想法，解决的思路就是算所有的字符相隔的区间，最大就是最长的字串
        //	执行耗时:3ms,击败了81.00% 的Java用户

        /*
        //  ascii 值 128 用char来做下标 用值来记录该字符上次出现的位置
        int[] storage = new int[128];
        int start = 0,end=0 ,maxLength = 0;
        char current;
        for (int i = 1; i <= s.length() ; i++) {
            current = s.charAt(i-1);
            // 之前不存在
            end = i;
            if(storage[current]!=0){
                int length = end - start -1  ;
                if(length > maxLength){
                    maxLength = length;
                }
                // start只能往后移，不能往前移 例如 abba 等到第二个a，不能将start变为1 而应该是2
                start = Math.max(storage[current], start);
            }
            storage[current] = i ;
        }
        return Math.max(maxLength,end-start);
        */
    }
}
//leetcode submit region end(Prohibit modification and deletion)
