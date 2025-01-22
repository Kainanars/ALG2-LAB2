import java.util.*;

public class ExerciseA {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int K = scanner.nextInt();

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      String operation = scanner.next();

      if (operation.equals("I")) {
        int x = scanner.nextInt();
        minHeap.add(x);

        if (minHeap.size() > K) {
          minHeap.poll();
        }
      } else if (operation.equals("Q")) {
        System.out.println(minHeap.peek());
      }
    }

    scanner.close();
  }
}
