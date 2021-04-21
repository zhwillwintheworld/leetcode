//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 
// 👍 1110 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        // 第一版的做法 耗时好几天 思路是这样的 先算出各个层所拥有字符的数量
        // 计算出每一层第一个的offset
        // 迭代 字符串中每一个字符 ，根据index 算出这是第几层的第几个字符
        //          解答成功:
        //			执行耗时:3 ms,击败了98.04% 的Java用户
        //			内存消耗:38.5 MB,击败了93.68% 的Java用户
      /*  if(numRows == 1){
            return s;
        }
        int level = 2 * numRows -2;
        int loop = s.length()/level;
        int remainder = s.length() % level;
        int[] numbers = new int[numRows];
        for(int i=0;i<numRows;i++){
            if(i==0 || i == numRows -1){
                numbers[i] = loop;
            }else{
                numbers[i] = 2* loop;
            }
        }
        for (int i = 1; i <= remainder ; i++) {
            if(i <= numRows){
                numbers[i -1] =  numbers[i -1]+ 1;
            }else{
                numbers[2*numRows -i -1] = numbers[2*numRows -i -1]+1;
            }
        }
        int[] offset = new int[numRows];
        for (int i = 1; i < numRows; i++) {
            offset[i] = numbers[i-1] + offset[i-1];
        }
        char[] storage = new char[s.length()];
        int recuise ;
        int current;
        for (int i = 0; i < s.length() ; i++) {
            recuise = i % level;
            current = i / level;
            if(recuise == 0 || recuise == numRows-1){
                storage[offset[recuise]+current] = s.charAt(i);
            }else{
                if(recuise< numRows -1){
                    storage[offset[recuise]+2*current] = s.charAt(i);
                }else{
                    storage[offset[level-recuise]+2*current+1] = s.charAt(i);
                }
            }
        }

        return  String.valueOf(storage);*/
    }

}
//leetcode submit region end(Prohibit modification and deletion)
