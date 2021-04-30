//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。 
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + I
//I 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。 
//
// 
//
// 示例 1: 
//
// 
//输入: "III"
//输出: 3 
//
// 示例 2: 
//
// 
//输入: "IV"
//输出: 4 
//
// 示例 3: 
//
// 
//输入: "IX"
//输出: 9 
//
// 示例 4: 
//
// 
//输入: "LVIII"
//输出: 58
//解释: L = 50, V= 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 15 
// s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M') 
// 题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内 
// 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。 
// IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。 
// 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。 
// 
// Related Topics 数学 字符串 
// 👍 1300 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int romanToInt(String s) {

        int sum = 0;
        // 			试探法，查看是否是一 i x c开头，如果一icx 开头则先不计算值，看第二位
        //			执行耗时:16 ms,击败了5.70% 的Java用户
        //			内存消耗:39.4 MB,击败了5.00% 的Java用户
//        HashMap<String,Integer> storage = new HashMap<>(13);
//        storage.put("I",1);
//        storage.put("IV",4);
//        storage.put("V",5);
//        storage.put("IX",9);
//        storage.put("X",10);
//        storage.put("XL",40);
//        storage.put("L",50);
//        storage.put("XC",90);
//        storage.put("C",100);
//        storage.put("CD",400);
//        storage.put("D",500);
//        storage.put("CM",900);
//        storage.put("M",1000);
//        boolean flag = false;
//        char prev = 0;
//        for (int i = 0; i <s.length() ; i++) {
//            char c = s.charAt(i);
//            if(flag){
//                String str = prev +""+ c;
//                if(storage.containsKey(str)){
//                    sum += storage.get(str);
//                    flag =false;
//                }else{
//                    if(c =='I' || c =='X' ||c =='C'){
//                        sum += storage.get(prev+"");
//                        prev = c;
//                    }else{
//                        flag =false;
//                        sum +=  storage.get(prev+"") + storage.get(c+"");
//                    }
//                }
//
//            }else{
//                if(c =='I' || c =='X' ||c =='C'){
//                    flag =true;
//                    prev = c;
//                }else{
//                    sum += storage.get(c+"");
//                }
//            }
//        }
//        if(flag){
//            sum += storage.get(prev+"");
//        }




        // 思路依然是试探法 查看第一位是否是ixc,只不过利用数组来实现
        // 状态：通过
        //执行用时: 10 ms 击败17% java
        //内存消耗: 39.2 M 击败10% java
//        String[] s1 = {"CM","CD","XC","XL","IX","IV"};
//        int[] numbers1 = {900,400,90,40,9,4};
//        char[] s2 = {'M','D','C','L','X','V','I'};
//        int[] numbers2 = {1000,500,100,50,10,5,1};
//        boolean flag = false;
//        int prev = 0;
//        int start1 = 0;
//        int start2 = 0;
//        for (int i = 0; i <s.length() ; i++) {
//            char c = s.charAt(i);
//            if(flag){
//                String str = s2[prev] +""+ c;
//                boolean makeUp = false;
//                for(int j = start1;j<s1.length;j++){
//                    if(str.equals(s1[j])){
//                        makeUp = true;
//                        sum += numbers1[j];
//                        flag = false;
//                        start1 = j;
//                        break;
//                    }
//                }
//                if(!makeUp){
//                    sum += numbers2[prev];
//                    if(c =='I' || c =='X' ||c =='C'){
//                        for(int j = 0;j<s2.length;j++){
//                            if(c == s2[j]){
//                                prev = j;
//                                break;
//                            }
//                        }
//                    }else{
//                        flag = false;
//                        for(int j = start2;j<s2.length;j++){
//                            if(c == s2[j]){
//                                sum += numbers2[j];
//                                start2 = j;
//                                break;
//                            }
//                        }
//                    }
//                }
//
//            }else{
//                if(c =='I' || c =='X' ||c =='C'){
//                    flag =true;
//                    for(int j = 0;j<s2.length;j++){
//                        if(c == s2[j]){
//                            prev = j;
//                            break;
//                        }
//                    }
//                }else{
//                    for(int j = start2;j<s2.length;j++){
//                        if(c == s2[j]){
//                            sum += numbers2[j];
//                            start2 = j;
//                            break;
//                        }
//                    }
//                }
//            }
//
//        }
//        if(flag){
//            sum += numbers2[prev];
//        }
        //			解答成功:
        //			执行耗时:4 ms,击败了100.00% 的Java用户
        //			内存消耗:38.4 MB,击败了83.42% 的Java用户
        char[] storage = new char[]{'M','D','C','L','X','V','I'};
        int[] numbers = new int[]{1000,500,100,50,10,5,1};
        int prev = 1001;
        int now = 0;
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            for (int j = 0; j <storage.length ; j++) {
                if(c == storage[j]){
                    now = numbers[j];
                }
            }
            if(now <= prev){
                sum += prev;
            }else{
                sum -= prev;
            }
            prev = now;
        }
        return  sum + prev -1001;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
