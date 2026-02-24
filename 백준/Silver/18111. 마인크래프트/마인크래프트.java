import java.io.*;
import java.util.*;

/**
 * 18111 - 마인크래프트
 * 땅의 높이를 일정하게; 땅의 높이 : 0 <= H <= 256
 * 블록 제거 -> 인벤토리 : 2초
 * 인벤토리 -> 블록 : 1초
 * 작업 최소 시간과 땅의 높이를 출력
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 세로, 가로, 인벤 보유 블록
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // [N,M] 땅의 높이
        int[][] ground = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 높이 0 ~ 256 가능
        // 제거한 블록과 설치한 블록의 개수를 따로 구하여 원래 인벤토리에 있는 블록의 개수와 비교 -> 가능한 조건인지 판단
        // 최종 걸린 시간을 계산하여 최소값 찾기

        int minTime = Integer.MAX_VALUE;
        int height = 0;
        
        for (int H = 0; H <= 256; H++) {
            int del = 0;  // 제거한 블록
            int ins = 0;  // 추가한 블록

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {

                    // 지정한 땅의 높이 보다 높으면 블록 제거, 지정한 땅의 높이 보다 낮으면 블록 추가
                    if (ground[i][j] > H) {
                        del += ground[i][j] - H;
                    } else if (ground[i][j] < H) {
                        ins += H - ground[i][j];
                    }
                }
            }
            if (del + B < ins) continue;

            int curTime = (del * 2) + ins; // 지정한 높이에서의 소요시간 계산

            minTime = Math.min(minTime, curTime); // 가장 적은 시간 선택

            if(minTime == curTime) height = H; // 현재 소요시간이 가장 적은 시간으로 선택된다면 해당 높이를 저장

        }
        sb.append(minTime).append(" ").append(height);

        System.out.print(sb);
    }
}

