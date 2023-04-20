package sk000801.복습;
import java.util.*;

//40분...
//LinkedHashMap에서 벗어나지 못했고
//그냥 악보를 최대 시간 1439에서 길이만큼 나눠 곱했더니
//악보가 길어져 원래 안돼야 하는 것도 됐나보다
//원래 풀이를 다시 보니 내가 해시맵을 너무 남발한 거 같다 왜 시간이 갈수록 못해지는 거 같지
public class 방금그곡 {
    public static String solution(String m, String[] musicinfos) {
        String[] before = {"C#", "D#", "F#", "G#", "A#"};
        String[] shap = {"a", "b", "c", "d", "e"};
        for(int i = 0; i < shap.length; i++) {
            m = m.replaceAll(before[i], shap[i]);
        }
        LinkedHashMap<String, Integer> time = new LinkedHashMap<>();
        LinkedHashMap<String, String> song = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> answer = new LinkedHashMap<>();
        for(int i = 0; i < musicinfos.length; i++) {
            String[] s = musicinfos[i].split(",");
            for(int j = 0; j < shap.length; j++) {
                s[3] = s[3].replaceAll(before[j], shap[j]);
            }
            int time1 = Integer.parseInt(s[0].split(":")[0])*60+Integer.parseInt(s[0].split(":")[1]);
            int time2 = Integer.parseInt(s[1].split(":")[0])*60+Integer.parseInt(s[1].split(":")[1]);
            time.put(s[2], time2-time1);
            String songs = "";
            for(int j = 0; j < time2-time1; j++) {
                songs += Character.toString(s[3].charAt(j%s[3].length()));
            }
            song.put(s[2], songs);
            if(song.get(s[2]).contains(m)) answer.put(s[2], time.get(s[2]));
        }

        String ans = "";
        if(answer.size() == 0) return "(None)";
        List<Integer> times = new ArrayList<>(answer.values());
        Collections.sort(times, Comparator.reverseOrder());
        for(String s : answer.keySet()) {
            if(times.get(0) == answer.get(s)) {
                ans = s;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String m1 = "ABCDEFG";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m3 = "ABC";
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m1, musicinfos1));
    }
}
