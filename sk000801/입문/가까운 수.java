import java.util.*;
class Solution {
    public int solution(int[] array, int n) {
        int[] arr = new int[array.length+1];
        int index = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i==arr.length-1) arr[i] = n;
            else arr[i] = array[i];
        }
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == n) {index = i;break;}
        }
        if(index == 0) return arr[1];
        else if (index == arr.length-1) return arr[arr.length-2];
        else return n-arr[index-1] <= arr[index+1]-n ? arr[index-1] : arr[index+1];
    }
}