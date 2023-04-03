package sk000801.복습;
import java.util.*;

//23분+15분
public class 뉴스클러스터링 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();

        if(str1.equals("") && str2.equals("")) {System.out.println(65536); return;}

        String[] s1 = str1.toLowerCase().split("");
        String[] s2 = str2.toLowerCase().split("");

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < s1.length-1; i++) {
            if(s1[i].matches("[a-z]") && s1[i+1].matches("[a-z]")) {
                String s = s1[i]+s1[i+1];
                set.add(s);
                map1.put(s, map1.getOrDefault(s, 0)+1);
            }
        }
        for(int i = 0; i < s2.length-1; i++) {
            if(s2[i].matches("[a-z]") && s2[i+1].matches("[a-z]")) {
                String s = s2[i]+s2[i+1];
                set.add(s);
                map2.put(s, map2.getOrDefault(s, 0)+1);
            }
        }

        int hap = 0;
        int gyog = 0;
        for(String s : set) {
            hap += Math.max(map1.getOrDefault(s, 0), map2.getOrDefault(s, 0));
        }
        for(String s : map1.keySet()) {
            if(map2.keySet().contains(s)) {
                gyog += Math.min(map1.get(s), map2.get(s));
            }
        }
        if(hap == 0) {System.out.println(65536); return;}
        int val = (int) Math.floor((double)(gyog*65536/hap));
        System.out.println(val);
    }
}

//테케1 FRANCE french
//테케2 handshake shake hands
//테케3 aa1+aa2 AAAA12
//테케4 E=M*C^2 e=m*c^2
