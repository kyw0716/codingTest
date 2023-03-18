package sk000801.LEVEL2;
import java.util.*;

class Solution {
    //compareToIgnoreCase()나중에 써보기 대소문자 구별 안하고 글자 그 자체로 비교해줌
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {

                String head1 = s1.split("[0-9]")[0];
                String head2 = s2.split("[0-9]")[0];
                
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                
                if (result == 0) { // 같은 문자일 경우 숫자로 비교
                    result = convert(s1, head1) - convert(s2, head2);
                }
                
                return result;
            }
        });
        
        return files;
    }
    
    public int convert(String str, String head) {
        str = str.substring(head.length()); // head 길이만큼 잘라서 숫자부터 시작하게 만들어줌
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) && result.length() < 5) // 숫자인지 그리고 result 길이가 5가 안 넘는지 확인
                result += c;
            else
                break;
        }
        return Integer.valueOf(result);
    }
}

//내가 틀린 풀이
// Arrays.sort(files, new Comparator<String>() {
//     @Override
//      public int compare(String s1, String s2) {
//          s1 = s1.toLowerCase();
//          s2 = s2.toLowerCase();
//          String head1 = s1.split("[0-9]")[0];
//          String head2 = s2.split("[0-9]")[0];
//          if(head1.compareTo(head2) != 0) return head1.compareTo(head2);
         
//          String rem = s1.substring(head1.length());
//          String rem2 = s2.substring(head2.length());
//          int num1 = -1;
//          int num2 = -1;
//          if(!rem.equals("") && !rem2.equals("")) {
//              int n = rem.length();
//              if(rem.length() >= 5) n = 5;
//              for(int i = 0; i <= n-1; i++) {
//                  if(!Character.toString(rem.charAt(i)).replaceAll("[0-9]", "").equals("")) {
//                      num1 = Integer.parseInt(rem.substring(0, i));
//                      break;
//                  }
//              }
//              n = rem2.length();
//              if(rem2.length()>=5) n = 5;
//              for(int i = 0; i <= n-1; i++) {
//                  if(!Character.toString(rem2.charAt(i)).replaceAll("[0-9]", "").equals("")) {
//                      num2 = Integer.parseInt(rem2.substring(0, i));
//                      break;
//                  }
//              }
//          }
//          System.out.println(num1+" "+num2);
//          if(num1 != -1 && num2 != -1) {
//              return num1-num2;
//          }
//          return 0;
//      }
//  });
//  return files;