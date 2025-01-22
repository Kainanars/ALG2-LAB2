import java.util.*;

public class ExerciseB {

  public static void main(String[] args) {
    Scanner leitor = new Scanner(System.in);
    PriorityQueue<Client> maxHeap = new PriorityQueue<>((a, b) -> b.priority - a.priority);
    PriorityQueue<Client> minHeap = new PriorityQueue<>((a, b) -> a.priority - b.priority);
    Map<Integer, Client> clientMap = new HashMap<>();

    while (true) {
      String input = leitor.nextLine();
      String[] parts = input.split(" ");
      int comando = Integer.parseInt(parts[0]);

      if (comando == 0) {
        break;
      }

      if (comando == 1) {
        int id = Integer.parseInt(parts[1]);
        int priority = Integer.parseInt(parts[2]);
        Client client = new Client(id, priority);
        maxHeap.offer(client);
        minHeap.offer(client);
        clientMap.put(id, client);
      } else if (comando == 2) {
        while (!maxHeap.isEmpty() && !clientMap.containsKey(maxHeap.peek().id)) {
          maxHeap.poll();
        }

        if (maxHeap.isEmpty()) {
          System.out.println(0);
        } else {
          Client served = maxHeap.poll();
          clientMap.remove(served.id);
          System.out.println(served.id);
        }
      } else if (comando == 3) {
        while (!minHeap.isEmpty() && !clientMap.containsKey(minHeap.peek().id)) {
          minHeap.poll();
        }

        if (minHeap.isEmpty()) {
          System.out.println(0);
        } else {
          Client served = minHeap.poll();
          clientMap.remove(served.id);
          System.out.println(served.id);
        }
      }
    }

    leitor.close();
  }

  static class Client {
    int id;
    int priority;

    Client(int id, int priority) {
      this.id = id;
      this.priority = priority;
    }
  }
}
