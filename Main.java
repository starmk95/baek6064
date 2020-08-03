import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            String[] temp = br.readLine().split(" ");
            int M = Integer.parseInt(temp[0]);
            int N = Integer.parseInt(temp[1]);
            int x = Integer.parseInt(temp[2]);
            int y = Integer.parseInt(temp[3]);
            int ans = caing(M, N, x, y);
            System.out.println(ans);
        }
    }
    // 브루트 포스
    // N과 M의 최대값은 각 4만이므로 최다 경우의 수는 N*M인 16억이다.
    // 1억개의 경우의 수가 1초가 걸린다는 것을 감안하면 모든 경우의 수를 고려하기에는 경우가 너무 많다.
    // 그러므로 고려할 필요가 없는 경우들은 건너뛰면서 경우들을 고려한다.
    // 예를 들어 x=2이고 M=10이라면 x=2인 경우는 10의 주기로 등장한다.
    // (2, y), (3, y), ... , (1, y), (2, y)
    // 그러므로 x 값의 M 값을 주기로 하여 확인하고, y값은 그렇게 확인한 경우들 중 입력 값과 일치하는 값을 찾으면 된다.
    // 위로 도출된 경우의 수들은 총 N개이다.
    // 이 방법을 통해 O(M*N)이였던 시간복잡도는 O(N)으로 줄일 수 있다.
    // (N이 더 작은 경우에는 y 값을 N주기로 경우의 수를 처리하도록하면 O(M)으로 만들 수도 있다.)
    static int caing(int m, int n, int x, int y) {
        if (m < n) {
            for (int k = x; k < (n * m); k += m) {
                int temp = k % n;
                if (temp == 0) temp = n;
                if (temp == y) {
                    return k;
                }
            }
        } else { // m > n
            for (int k = y; k < (n * m); k += n) {
                int temp = k % m;
                if (temp == 0) temp = m;
                if (temp == x) {
                    return k;
                }
            }
        }
        return -1;
    }
}
