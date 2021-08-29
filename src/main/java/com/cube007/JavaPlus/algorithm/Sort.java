package com.cube007.JavaPlus.algorithm;

/**
 * @ClassName: Sort
 * @Description: 排序算法
 * @Author: Liu Xiaonan
 * @Date: 2021/7/5 17:51
 */
public class Sort {


    public static void main(String[] args) {
        int[] a = {6,8,1,4,7,10,9};
        quickSort01(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(i);
        }

    }

    /**
     * 功能描述:冒泡排序
     * @param arr:
     * @author Liu Xiaonan
     * @date 2021/7/5 17:54
     */
    public void bubbleSort(int[] arr) {
        //冒泡
        for (int i = 0; i < arr.length; i++) {
            //外层循环，遍历次数
            for (int j = 0; j < arr.length - i - 1; j++) {
                //内层循环，升序（如果前一个值比后一个值大，则交换）
                //内层循环一次，获取一个最大值
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 功能描述:选择排序
     * @param arr:
     * @author Liu Xiaonan
     * @date 2021/7/5 17:54
     */
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //默认第一个是最小的。
            int min = arr[i];
            //记录最小的下标
            int index = i;
            //通过与后面的数据进行比较得出，最小值和下标
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            //然后将最小值与本次循环的，开始值交换
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
            //说明：将i前面的数据看成一个排好的队列，i后面的看成一个无序队列。每次只需要找无需的最小值，做替换
        }
    }

    /**
     * 功能描述:插入排序
     * @param arr:
     * @author Liu Xiaonan
     * @date 2021/7/5 17:54
     */
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //外层循环，从第二个开始比较
            for (int j = i; j > 0; j--) {
                //内存循环，与前面排好序的数据比较，如果后面的数据小于前面的则交换
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }
        }
    }

    /**
     * 功能描述:希尔排序
     * @param arr:
     * @author Liu Xiaonan
     * @date 2021/7/5 17:54
     */
    public void shellSort(int[] arr) {
        for (int i = arr.length / 2; i > 0; i /= 2) {
            //i层循环控制步长
            for (int j = i; j < arr.length; j++) {
                //j控制无序端的起始位置
                for (int k = j; k > 0  && k - i >= 0; k -= i) {
                    if (arr[k] < arr[k - i]) {
                        int temp = arr[k - i];
                        arr[k - i] = arr[k];
                        arr[k] = temp;
                    } else {
                        break;
                    }
                }
            }
            //j,k为插入排序，不过步长为i
        }
    }

    /**
     * 功能描述:快速排序
     * @param arr:
     * @param low: 起始位置
     * @param high: 结束位置
     * @author Liu Xiaonan
     * @date 2021/7/5 17:52
     */
    public static void quickSort(int[] arr,int low,int high){
        int i, j, temp, t;
        if(low > high){
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i< j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    /**
     * 
     * @param arr:
     * @param low:
     * @param high:
     * @author Cube007
     * @date 2021/8/29 22:12
     */
    public static void quickSort01(int[] arr, int low, int high) {

        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;
        int temp = arr[low];
        int t;

        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[low] = arr[i];
        arr[i] = temp;
        quickSort01(arr, low , j - 1);
        quickSort01(arr, j + 1 , high);

    }



    /**
     * 功能描述:归并排序
     * @param arr:
     * @param start: 起始位置
     * @param end: 结束位置
     * @author Liu Xiaonan
     * @date 2021/7/5 18:25
     */
    public static void mergeSort(int[] arr, int start, int end) {
        //判断拆分的不为最小单位
        if (end - start > 0) {
            //再一次拆分，知道拆成一个一个的数据
            mergeSort(arr, start, (start + end) / 2);
            mergeSort(arr, (start + end) / 2 + 1, end);
            //记录开始/结束位置
            int left = start;
            int right = (start + end) / 2 + 1;
            //记录每个小单位的排序结果
            int index = 0;
            int[] result = new int[end - start + 1];
            //如果查分后的两块数据，都还存在
            while (left <= (start + end) / 2 && right <= end) {
                //比较两块数据的大小，然后赋值，并且移动下标
                if (arr[left] <= arr[right]) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                //移动单位记录的下标
                index++;
            }
            //当某一块数据不存在了时
            while (left <= (start + end) / 2 || right <= end) {
                //直接赋值到记录下标
                if (left <= (start + end) / 2) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                index++;
            }
            //最后将新的数据赋值给原来的列表，并且是对应分块后的下标。
            if (end + 1 - start >= 0)
                System.arraycopy(result, 0, arr, start, end + 1 - start);
        }
    }

}
