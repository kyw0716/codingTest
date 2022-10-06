package sk000801;

import java.util.*;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^ a-z | 0-9 | [-] | [_] | [.] ]","");

        new_id = new_id.replaceAll("[.]+", ".");
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        System.out.println(new_id);
        
        if(new_id.equals("")) new_id = "a";
        if(new_id.length() >= 16) new_id = new_id.substring(0, 15);
        new_id = new_id.replaceAll("^[.]|[.]$", "");
        if(new_id.length() <= 2) {
            while(new_id.length() < 3) {
                new_id += new_id.substring(new_id.length()-1);
            }
        }
        return new_id;
        }
}

