class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map = new String[n];
        String[] arr11 = new String[n];
        String[] arr22 = new String[n];
        for(int i=0; i<arr1.length; i++) {
            int l1 = Integer.toBinaryString(arr1[i]).length();
            int l2 = Integer.toBinaryString(arr2[i]).length();
            if(l1 < n) {
                for(int j=0; j<n-l1; j++) {
                    if(j==0) arr11[i] = "0";
                    else arr11[i] += "0";
                }
                arr11[i] += Integer.toBinaryString(arr1[i]);
            }
            else arr11[i] = Integer.toBinaryString(arr1[i]);
            if(l2 < n) {
                for(int j=0; j<n-l2; j++) {
                    if(j==0) arr22[i] = "0";
                    else arr22[i] += "0";
                }
                arr22[i] += Integer.toBinaryString(arr2[i]);
            }
            else  arr22[i] = Integer.toBinaryString(arr2[i]);

        }
        for(int i=0; i<n; i++) {
            map[i] = "";
            for(int j=0; j<n; j++) {
                if(arr11[i].charAt(j)=='1' || arr22[i].charAt(j) == '1') {
                    map[i] += "#";
                }
                else map[i] += " ";
            }
        }
        return map;
    }
}