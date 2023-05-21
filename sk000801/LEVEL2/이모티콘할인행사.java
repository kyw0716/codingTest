package sk000801.LEVEL2;
//29분..? 순열만 돌릴 줄 알면 풀 수 있는 문제였구나...
class 이모티콘할인행사 {
    //비율(이 비율 이상이면 구매), 가격(이 가격 이상으로 임티 구매했으면 임티플러스 가입) 
    int[] ans = new int[2];
    public int[] cal(int[] discount, int[] emoticons, int[][] users) {
        int enjoyMem = 0;
        int total = 0;
        
        for(int i = 0; i < users.length; i++) {
            int[] user = users[i];
            int price = 0;
            for(int j = 0; j < emoticons.length; j++) {
                if(user[0] <= discount[j]) {
                    price += emoticons[j]*(1.0-(double)(discount[j]/100.0));
                    //System.out.println((1.0-(double)(discount[j]/100.0)));
                } 
            }
            if(price >= user[1]) enjoyMem++;
            else total += price;
        }
        
        return new int[]{enjoyMem, total};
    }
    public void setDiscount(int[] discount, int[] emoticons, int[][] users, int depth) {
        if(depth == discount.length) {
            int[] res = cal(discount, emoticons, users);
            if(res[0] > ans[0]) {
                ans[0] = res[0];
                ans[1] = res[1];
            } else if(res[0] == ans[0]) {
                if(res[1] > ans[1]) {
                    ans[1] = res[1];
                }
            }
            return;
        }
        
        for(int i = 1; i <= 4; i++) {
            discount[depth] = 10*i;
            setDiscount(discount, emoticons, users, depth+1);
        }
    }
    public int[] solution(int[][] users, int[] emoticons) {
        int[] discount = new int[emoticons.length];
        setDiscount(discount, emoticons, users, 0);
        return ans;
    }
}
