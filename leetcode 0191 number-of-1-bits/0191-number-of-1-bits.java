class Solution {
    public int hammingWeight(int n) {
        // return solveByString(n);
        // return solveByBitwise(n);
        return solveByBrianKernighan(n);
    }

    // Brian Kernighan’s 알고리즘 풀이
    private int solveByBrianKernighan(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= (n-1);
            cnt ++;
        }
        return cnt;
    }

    // 비트 연산 풀이
    private int solveByBitwise(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += (n & 1);
            n >>= 1;
        }
        return cnt;
    }

    // 문자열 변환 풀이
    private int solveByString(int n) {
        int cnt = 0;
        char[] ch = Integer.toBinaryString(n).toCharArray();
        for (char c : ch) {
            if (c == '1') cnt++;
        }
        return cnt;
    }
}