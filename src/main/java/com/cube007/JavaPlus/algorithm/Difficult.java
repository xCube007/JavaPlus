package com.cube007.JavaPlus.algorithm;

/**
 * @ClassName: Difficult
 * @Description: 困难
 * @Author: Liu Xiaonan
 * @Date: 2021/7/5 16:31
 */
public class Difficult {

    /**
     *
     * 功能描述: 4. 寻找两个正序数组的中位数
     *
     * @param nums1:
     * @param nums2:
     * @author Liu Xiaonan
     * @return double
     * @date 2021/7/5 18:07
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Sort sort = new Sort();
        int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        sort.quickSort(nums, 0, nums.length-1);
        if (nums.length % 2 == 0) {
            return (double)(nums[nums.length/2-1] + nums[nums.length/2])/2;
        } else {
            return nums[(nums.length-1)/2];
        }
    }



}
