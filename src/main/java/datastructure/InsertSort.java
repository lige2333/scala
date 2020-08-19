package datastructure;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(mobileEncrypt("18702171092"));
    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i <arr.length ; i++) {
            int insertVal = arr[i];
            int insertIndex = i-1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if(insertIndex+1 != i){
                arr[insertIndex + 1] = insertVal;
            }
        }

    }

    public static String mobileEncrypt(String mobile) {
        if (mobile.equals("") || (mobile.length() != 11)) {
            return mobile;
        }
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }
}
