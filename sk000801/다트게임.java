import java.util.Arrays;
class Solution {
    public int solution(String dartResult) {
        int count = 0;
        String[] multiple = new String[3];
        String[] option = new String[3];
        int[] num = new int[3];
        int[] result = new int[3];
        
        String onlyInt = dartResult.replaceAll("[^\\d]", "");
        String rest = dartResult.replaceAll("[\\d]", "");
        StringBuffer makeSet = new StringBuffer(rest);

        for(int i=0; i<makeSet.length(); i++) {
            if(i % 2 == 1) {
                 if(makeSet.charAt(i) != '#' && makeSet.charAt(i) != '*') {
                    makeSet.insert(i, '&');
                  }
            }      
       }
       if(makeSet.length() % 2 == 1) {
           makeSet.insert(makeSet.length(), '&');
       }  //여기까지 makeSet 길이 6으로 정해놓음

        
        for(int i=0;i<6; i++) {
            if(i%2 == 1) {
                option[i/2] = String.valueOf(makeSet.charAt(i)); 
            }
            else {
                multiple[i/2] =  String.valueOf(makeSet.charAt(i));
            }
        }

        
        if(onlyInt.length()>multiple.length) {
                for(int i=0; i<onlyInt.length()-1; i++) {
                if(onlyInt.charAt(i) == '1' && onlyInt.charAt(i+1) == '0') {
                   num[count] = 10; //10이 1,0으로 따로 들어간 경우
                    i++;
               }
               else {num[count] = Character.getNumericValue(onlyInt.charAt(i));}
                    count++;
            }
        }
        else {
            for(int i=0; i<onlyInt.length(); i++) {
        num[i] = Character.getNumericValue(onlyInt.charAt(i));
        }
        }
        
        
      for(int i=0; i<3; i++) {
          if(multiple[i].equals("D")) {result[i] = (int)(Math.pow(num[i],2));}
          else if(multiple[i].equals("T")) {result[i] = (int)(Math.pow(num[i],3));}
          else {result[i] = num[i];}
          
          if(i == 0) {
                  if(option[i].equals("*")) {
                      result[i] *= 2;
                  } 
                  else if(option[i].equals("#")) {
                      result[i] *= (-1);
                  }  
         }  
          else {
                if(option[i].equals("*")) {
                      result[i-1] *= 2;
                      result[i] *= 2;
                }
                else if (option[i].equals("#")) {
                  result[i] *= (-1);
                }
         }
          System.out.println(result[i]);
      }  
                int sum =  Arrays.stream(result).sum();
                return sum;
}


}
    