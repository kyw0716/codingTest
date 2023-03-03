package sk000801.백준.구현;
import java.util.*;

public class _2048 {
    static int n;
    static int[][] game;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int max = 0;
    public static void game(int depth) {
        if(depth == 5) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    max = Math.max(max, game[i][j]);
                }
            }
            return;
        }

        int[][] game2 = new int[n][n];
        for(int i = 0; i < n; i++) {
            game2[i] = game[i].clone();
        }

        for(int i = 0; i < 4; i++) {
            move(i);
            game(depth+1);
            for(int j = 0; j < n; j++) {
                game[j] = game2[j].clone(); //원래 값으로 돌려놓음
            }
        }
    }
    //상하좌우 중 한 방향으로 밀어서 이동시키기
    public static void move(int dir) {
        switch(dir) {
            case 0: //상
                for(int i = 0; i < n; i++) {
                    int index = 0; //값을 넣을 위치
                    int block = 0; //최근 블록의 수
                    for(int j = 0; j < n; j++) {
                        if(game[j][i] != 0) {
                            if(block == game[j][i]) {
                                //윗부분으로 2배 해준 값을 넣어줌
                                game[index-1][i] = block*2;
                                //이후 탐색을 위해 원래 값은 0으로 초기화
                                block = 0;
                                //윗부분에 값을 넘겨주고 값이 삭제됨
                                game[j][i] = 0;
                            } else {
                                block = game[j][i];
                                game[j][i] = 0;
                                game[index][i] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 1://하
                for(int i = 0; i < n; i++) {
                    int index = n-1; //값을 넣을 위치
                    int block = 0; //최근 블록의 수
                    for(int j = n-1; j >= 0; j--) {
                        if(game[j][i] != 0) {
                            if(block == game[j][i]) {
                                game[index+1][i] = block*2;
                                block = 0;
                                game[j][i] = 0;
                            } else {
                                block = game[j][i];
                                game[j][i] = 0;
                                game[index][i] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
            case 2://좌
                for(int i = 0; i < n; i++) {
                    int index = 0; //값을 넣을 위치
                    int block = 0; //최근 블록의 수
                    for(int j = 0; j < n; j++) {
                        if(game[i][j] != 0) {
                            if(block == game[i][j]) {
                                game[i][index-1] = block*2;
                                block = 0;
                                game[i][j] = 0;
                            } else {
                                block = game[i][j];
                                game[i][j] = 0;
                                game[i][index] = block;
                                index++;
                            }
                        }
                    }
                }
                break;
            case 3://우
                for(int i = 0; i < n; i++) {
                    int index = n-1; //값을 넣을 위치
                    int block = 0; //최근 인덱스?블록?의값
                    for(int j = n-1; j >= 0; j--) {
                        if(game[i][j] != 0) {
                            if(block == game[i][j]) {
                                game[i][index+1] = block*2;
                                block = 0;
                                game[i][j] = 0;
                            } else {
                                block = game[i][j];
                                game[i][j] = 0;
                                game[i][index] = block;
                                index--;
                            }
                        }
                    }
                }
                break;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        game = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                game[i][j] = in.nextInt();
            }
        }

        game(0);

        System.out.println(max);
    }
}
