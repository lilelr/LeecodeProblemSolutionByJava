package note.recursive.LetterCombiantionsOfaPhoneNumber17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuxiao on 4/24/16.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }

        Map<Character,String> dict = new HashMap<>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");

        char[] buffer = new char[digits.length()];
        backtracking(dict,res,digits,buffer,0);
        return  res;

    }

    private void backtracking(Map<Character,String> map,List<String> res,String digits ,char[] buffer,int index){
        if(index == digits.length()){
            StringBuffer tmp  = new StringBuffer();
            for(char c: buffer){
                tmp.append(c);
            }
            res.add(tmp.toString());
            return;
        }

        for(int i=0;i<map.get(digits.charAt(index)).length();i++){
            buffer[index] =map.get(digits.charAt(index)).charAt(i);
            backtracking(map,res,digits,buffer,index+1);
        }
    }


}
