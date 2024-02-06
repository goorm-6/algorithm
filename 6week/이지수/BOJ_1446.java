package goorm_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1446 {
    static int N, D; // N: 지름길의 개수, D: 골목의 길이
    static List<List<Node>> graph = new ArrayList<>(); // 그래프를 저장할 리스트
    static int[] distance; // 시작점으로부터의 최단 거리를 저장할 배열

    public static void main(String[] args) throws Exception {
        // 입력을 받기 위한 BufferedReader 및 StringTokenizer 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N과 D 입력 받기
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        // 그래프 초기화
        for (int i = 0; i <= 10001; i++)
            graph.add(new ArrayList<>());
        // 최단 거리 배열 초기화
        distance = new int[10001];
        for (int i = 0; i < distance.length; i++)
            distance[i] = i;

        // 지름길 정보 입력 받아 그래프에 추가
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, w));
        }

        // 다익스트라 알고리즘 수행
        dijkstra(0);

        // 출력: D까지의 최단 거리
        System.out.println(distance[D]);
    }

    // 다익스트라 알고리즘 구현
    static void dijkstra(int start) {
        // 현재 위치가 D를 넘어가면 종료
        if (start > D)
            return;

        // 현재 위치에서 오른쪽으로 한 칸 이동했을 때의 거리 갱신
        if (distance[start + 1] > distance[start] + 1)
            distance[start + 1] = distance[start] + 1;

        // 현재 위치에서 출발해 갈 수 있는 모든 지름길에 대해 반복문 실행
        for (int i = 0; i < graph.get(start).size(); i++) {
            // 다음 노드와 해당 지름길의 길이(가중치) 정보를 가져옴
            Node nextNode = graph.get(start).get(i);
            // 만약 현재 위치에서 해당 지름길을 통해 이동하는 것이 이전까지 알고 있던 거리보다 짧다면
            if (distance[start] + nextNode.weight < distance[nextNode.node])
                // 더 짧은 거리로 갱신
                distance[nextNode.node] = distance[start] + nextNode.weight;
        }

        // 다음 위치로 이동하며 다익스트라 알고리즘 재귀 호출
        dijkstra(start + 1);
    }

    // 그래프에서 사용할 Node 클래스 정의
    static class Node {
        int node; // 도착 노드
        int weight; // 가중치(지름길의 길이)

        // 생성자
        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
