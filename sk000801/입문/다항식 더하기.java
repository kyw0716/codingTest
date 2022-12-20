class Solution {
    public String solution(String polynomial) {
        String poly = polynomial.replaceAll(" ", "");
        poly = poly.replaceAll("[+]", ",");
        String[] hang = poly.split(",");
        int[] real = new int[2];
        for(String s : hang) {
            if(s.contains("x")) {
                if(s.equals("x")) real[0] += 1;
                else real[0] += Integer.parseInt(s.replaceAll("x",""));
            }
            else real[1] += Integer.parseInt(s);
        }
        if(real[0] == 0) return String.valueOf(real[1]);
        else if(real[0] == 1) return real[1] == 0 ? "x" : "x + " + real[1];
        else if(real[1] == 0) return real[0]+"x";
        else return real[0] + "x + " + real[1];
    }
}