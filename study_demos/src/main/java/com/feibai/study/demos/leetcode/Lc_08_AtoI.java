package com.feibai.study.demos.leetcode;

import com.feibai.study.demos.leetcode.beans.ListNode;

/**
 *
 */
public class Lc_08_AtoI {
    public static void main(String[] args) {
        Lc_08_AtoI instance = new Lc_08_AtoI();
        System.out.println(instance.myAtoi("4193 with words"));
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0)
            return 0;

        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }

}
