import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Graph {

    private UserList users;

    public Graph(UserList users) {
        this.users = users;
    }

    public void showMutualFriends(String u1, String u2) {
        User user1 = users.findUser(u1);
        User user2 = users.findUser(u2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Mutual Friends:");
        for (int i = 0; i < user1.friendscount; i++) {
            for (int j = 0; j < user2.friendscount; j++) {
                if (user1.friends[i].equals(user2.friends[j])) {
                    System.out.println(user1.friends[i] + " ");
                }
            }
        }
        System.out.println();
    }

    public void shortestPath(String start, String end) {
        int startIdx = users.indexOf(start);
        int endIdx = users.indexOf(end);

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("User not found!");
            return;
        }

        int n = users.getCount();
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, 0);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(startIdx);
        visited[startIdx] = true;

        while (!q.isEmpty()) {
            int currIdx = q.poll();
            User currUser = users.getUserByIndex(currIdx);

            if (currIdx == endIdx) {
                System.out.println("Shortest path length: " + distance[endIdx]);
                return;
            }

            for (int i = 0; i < currUser.friendscount; i++) {
                int friendIdx = users.indexOf(currUser.friends[i]);

                if (friendIdx != -1 && !visited[friendIdx]) {
                    visited[friendIdx] = true;
                    distance[friendIdx] = distance[currIdx] + 1;
                    q.add(friendIdx);
                }
            }
        }

        System.out.println("No path found");
    }

}
