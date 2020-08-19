package datastructure.search;

import java.util.ArrayList;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000,1000,1000,1234};
        ArrayList<Integer> resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println(resIndex);
    }

    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resultIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resultIndexList.add(temp);
                temp--;
            }
            resultIndexList.add(mid);
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resultIndexList.add(temp);
                temp++;
            }
            return resultIndexList;
        }
    }
}
