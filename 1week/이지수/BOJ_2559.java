package prefix_sum;

import java.util.Scanner;

public class BOJ_2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] sequence = new int[N];
        int[] prefixSum = new int[N];

        for (int i = 0; i < N; i++) {
            sequence[i] = sc.nextInt();
        }

        // 누적합 배열 생성
        prefixSum[0] = sequence[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + sequence[i];
        }

        int maxSum = Integer.MIN_VALUE;

        // 누적합 배열을 이용하여 연속된 K개의 수의 합 중 최댓값 계산
        for (int i = K - 1; i < N; i++) {
            int sum;
            if (i - K < 0) {
                sum = prefixSum[i];
            } else {
                sum = prefixSum[i] - prefixSum[i - K];
            }
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}