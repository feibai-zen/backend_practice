package com.feibai.study.demos.leetcode;

import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。不要使用额外的数组空间，你必须仅使
 * 用 O(1) 额外空间并 原地 修改输入数组。元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 示例 2:
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Lc_27_RemoveElement {

  public static void main(String[] args) {
    Lc_27_RemoveElement instance = new Lc_27_RemoveElement();

    int[] test_case1 = {3, 2, 2, 3};
    System.out.println(instance.removeElementByDoublePointer(test_case1, 3));
    System.out.println(Arrays.toString(test_case1));

    int[] test_case2 = {0, 1, 2, 2, 3, 0, 4, 2};
    System.out.println(instance.removeElementByDoublePointer(test_case2, 2));
    System.out.println(Arrays.toString(test_case2));
  }

  //官方：双指针题解
  private int removeElementByDoublePointer(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != val) {
        nums[i] = nums[j];
        i++;
      }
    }

    return i;
  }
}