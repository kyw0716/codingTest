class Solution {
    public String[] solution(String[] quiz) {
        String answer = "";
        for(String s : quiz) {
            String[] sik = s.split(" ");
            int result = Integer.parseInt(sik[0]);
            for(int i = 0; i < sik.length; i++) {
                if(sik[i].equals("-")) result -= Integer.parseInt(sik[i+1]);
                if(sik[i].equals("+")) result += Integer.parseInt(sik[i+1]);
            }
            if (String.valueOf(result).equals(sik[sik.length-1])) answer += "O";
            else answer += "X";
        }
        return answer.split("");
    }
}