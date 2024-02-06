package goorm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_9934 {
    static int k; // 이진 트리의 높이를 나타내는 변수
    static int[] arr; // 입력 값 배열로 만들어주기 위한 배열
    static List<ArrayList<Integer>> list; // 각 레벨에 해당하는 노드를 저장하는 리스트

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine()); // 이진 트리 높이를 입력 받음
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 완전 이진 트리의 노드개수 = 2^k-1개
        // Math.pow()-> 거듭제곱 구하는 메소드
        arr = new int[(int) Math.pow(2, k) - 1];

        // 입력값 배열 삽입
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // depth에 맞게 노드를 저장하기 위한 list
        list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>()); // 깊이에 따라 노드를 저장할 리스트 생성
        }

        // 탐색
        search(0,arr.length - 1,0); //주어진 배열을 이용해 완전 이진 트리 생성

        // 출력을 위해 StringBuilder에 담기
        for (int i = 0; i < k; i++) {
            for (int j : list.get(i)) {
                sb.append(j).append(" "); // 리스트에 저장된 노드를 출력형식으로 변환
            }
            sb.append("\n"); // 각 레벨의 출력이 끝나면 줄바꿈 해줌
        }

        System.out.println(sb); // 최종 결과 출력
    }
    static void search(int start, int end, int depth) {
        // 재귀 탈출문
        if(depth == k) {
            return; // 주어진 깊이에 도달하면 재귀를 종료
        }

        // 중간값
        int mid = (start + end) / 2;

        // depth에 맞게 노드 삽입
        list.get(depth).add(arr[mid]); // 해당 깊이에 중간값을 리스트에 추가

        // 왼쪽 노드(시작부터 중간 - 1 까지)
        //중간값을 기준으로 왼쪽 노드에 대해 재귀 호출
        search(start, mid - 1, depth + 1);

        // 오른쪽 노드 ( 중간 + 1 부터 끝까지)
        //중간값을 기준으로 오른쪽 노드에 대해 재귀 호출
        search(mid + 1, end, depth + 1);
    }
}
