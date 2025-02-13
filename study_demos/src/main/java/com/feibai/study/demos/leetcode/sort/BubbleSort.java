package com.feibai.study.demos.leetcode.sort;

import java.util.Arrays;

/**
 * @author feibai
 * @Time 2019年8月21日
 * 时间复杂度：O(n^2)
 */
public class BubbleSort {

  public static void main(String[] args) {
    int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  private static int[] bubbleSort(int[] arr) {
    int len = arr.length;
    // 外层循环控制的是次数，比数组的长度少1次
    for (int i = 0; i < len; i++) {
      // 内层循环就是实际循环比较的
      // 优化点：如果一轮循环下来发现没有交换过位置，说明已经有序了，就可以结束循环了
      boolean flag = false;
      for (int j = 1; j < len - i; j++) {
        if (arr[j - 1] > arr[j]) {
          int tmp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = tmp;
          flag = true;
        }
      }
      if (!flag) {
        break;
      }
    }
    return arr;
  }

}
