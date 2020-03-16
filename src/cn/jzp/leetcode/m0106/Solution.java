package cn.jzp.leetcode.m0106;

public class Solution {
    public String compressString(String s) {
        if(s == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char last = '0';
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if(i == 0){
                last = s.charAt(i);
            }
            if(last == current){
                count ++;
            }else{
                sb.append(last);
                sb.append(count);
                count = 1;
                last = current;
            }
            if(sb.length() >= s.length()){
                break;
            }
        }
        sb.append(last);
        sb.append(count);
        if(sb.length() >= s.length()){
            return s;
        }
        return sb.toString();
    }
}