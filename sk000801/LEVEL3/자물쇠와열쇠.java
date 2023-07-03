package sk000801.LEVEL3;
//https://velog.io/@tjdud0123/%EC%9E%90%EB%AC%BC%EC%87%A0%EC%99%80-%EC%97%B4%EC%87%A0-2020-%EC%B9%B4%EC%B9%B4%EC%98%A4-%EA%B3%B5%EC%B1%84-python
//멋쟁이 선생님의 풀이를 일단 따라해 봤다..
//시간을 재는게 의미가 없을 것 같음(해석하는데만 1시간ㅋ),, 90도 돌리는 것부터 헷갈린 나레기

public class 자물쇠와열쇠 {
    public int[][] rotate(int[][] keys) {
        int[][] arr = new int[keys.length][keys[0].length];
        for(int i = 0; i < keys.length; i++) {
           for(int j = 0; j < keys[0].length; j++) {
               arr[i][j] = keys[j][keys.length-1-i];
           }
        }
        return arr;
    }
    public void add(int x, int y, int[][] keys, int[][] arr) {
        for(int i = 0; i < keys.length; i++) {
            for(int j = 0; j < keys[0].length; j++) {
                arr[x+i][y+j] += keys[i][j];
            }
        }
    }
    public void subtract(int x, int y, int[][] keys, int[][] arr) {
        for(int i = 0; i < keys.length; i++) {
            for(int j = 0; j < keys[0].length; j++) {
                arr[x+i][y+j] -= keys[i][j];
            }
        }
    }
    public boolean check(int m, int n, int[][] arr) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[m+i][m+j] != 1) return false;
            }
        }
        return true;
    }
    public boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        int len = 2*m+n;
        int[][] arr = new int[len][len];
        
        //중앙에 자물쇠를 배치(자물쇠 배열의 크기를 확장시켜 왼쪽 위부터 차례대로 맞춰가며 확인하기 위함)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i+m][j+m] = lock[i][j];
            }
        }
        
        //키를 4방향으로 회전시켜봄
        int[][] keys = key.clone();
        for(int i = 0; i < 4; i++) {
            keys = rotate(keys);
            for(int j = 1; j < m+n; j++) {
                for(int r = 1; r < m+n; r++) {
                    //열쇠 넣음
                    add(j, r, keys, arr);
                    //열쇠로 자물쇠 열 수 있는 경우는 바로 true 반환
                    if(check(m, n, arr)) return true;
                    //열쇠 다시 뺌
                    subtract(j, r, keys, arr);
                }
            }
        }
        
        return false;
    }
}