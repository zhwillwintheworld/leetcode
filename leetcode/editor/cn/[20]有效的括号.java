//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2381 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        if(length%2 == 1){
            return false;
        }
        char[] storage = new char[length];
        int current = 0;
        char c;
        char compare;
        for (int i = 0; i <length ; i++) {
            c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                storage[current++] = c;
            }else{
                if(current == 0){
                    return false;
                }
                compare = storage[current-1];
                if(c-compare==1||c-compare==2){
                    current--;
                }else{
                    return false;
                }
            }
        }
        return current==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
