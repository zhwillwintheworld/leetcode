//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1583 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String commonPrefix = strs[0];
        String temp;
        int length;
        for(int i =1;i<strs.length;i++){
            temp = strs[i];
            if(!temp.startsWith(commonPrefix)){
                length = Math.min(temp.length(),commonPrefix.length());
                for (int j = 0; j <length ; j++) {
                    if(temp.charAt(j)!=commonPrefix.charAt(j)){
                        length = j;
                        break;
                    }
                }
                if(length==0){
                    return "";
                }else{
                    commonPrefix = commonPrefix.substring(0,length);
                }
            }
        }
        return commonPrefix;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
