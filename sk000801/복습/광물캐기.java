package sk000801.복습;

//23분
public class 광물캐기 {
    //순서대로 다이아몬드, 철, 돌
    static int[] dia = {1,1,1};
    static int[] iron = {5,1,1};
    static int[] stone = {25,5,1};
    static int min = Integer.MAX_VALUE;
    public static boolean isValid(int[] res, int[] picks) {
        int dia = 0;
        int iron = 0;
        int stone = 0;
        for(int i = 0; i < res.length; i++) {
            if(res[i] == 0) dia++;
            if(res[i] == 1) iron++;
            if(res[i] == 2) stone++;
            if(dia > picks[0] || iron > picks[1] || stone > picks[2]) return false;
        }
        return true;
    }
    public static int cal(int[] res, String[] minerals) {
        int result = 0;
        for(int i = 0; i < res.length; i++) {
            int[] value = new int[3];
            if(res[i] == 0) value = dia.clone();
            if(res[i] == 1) value = iron.clone();
            if(res[i] == 2) value = stone.clone();
            for(int j = 5*i; j < 5*i+5; j++) {
                if(j >= minerals.length) break;
                switch(minerals[j]) {
                    case "diamond":
                        result += value[0];
                        break;
                    case "iron":
                        result += value[1]; 
                        break;
                    case "stone":
                        result += value[2];
                        break;
                }
            }
        }
        return result;
    }
    public static void dfs(int depth, int num, int[] res, int[] picks, String[] minerals) {
        if(depth == num) {
            if(isValid(res, picks)) {
                min = Math.min(min, cal(res, minerals));
            }
            return;
        }

        for(int i = 0; i < 3; i++) {
            res[depth] = i;
            dfs(depth+1, num, res, picks, minerals);
        }
    }
    public static int solution(int[] picks, String[] minerals) {
        int num = (minerals.length % 5 == 0) ? minerals.length/5 : minerals.length/5+1;
        int pickNum = 0;
        for(int i = 0; i < picks.length; i++) {
            pickNum += picks[i];
        }
        if(num > pickNum) num = pickNum;
        int[] res = new int[num];
        dfs(0, num, res, picks, minerals);
        return min;
    }
    public static void main(String[] args) {
        int[] picks1 = {1,3,2};
        String[] minerals1 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        int[] picks2 = {0,1,1};
        String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        System.out.println(solution(picks2, minerals2));
    }
}
