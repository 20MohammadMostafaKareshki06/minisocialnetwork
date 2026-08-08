import java.util.Scanner;

public class SocialNetWork {
    private UserList users;
    private FriendRequestQueue requests;
    private Graph graph;
    private UserTree tree;

    public SocialNetWork(int usercapacity, int queuecapacity) {
        users = new UserList(usercapacity);
        requests = new FriendRequestQueue(queuecapacity);
        graph = new Graph(users);
        tree = new UserTree();
    }

    public void registerUser(String name, String username) {
        if (users.findUser(username) != null) {
            System.out.println("The username is duplicated!");
            return;
        }
        users.addUser(new User(name, username));
        System.out.println("User " + name + " seccessfully registered.");
        tree.insert(new User(name, username));
    }

    public void sendFriendRequest(String from, String to) {
        User sender = users.findUser(from);
        User receiver = users.findUser(to);

        if (sender == null || receiver == null) {
            System.out.println("The User not found!");
            return;
        }
        requests.add(new FriendRequest(from, to));
        System.out.println("Friend request send.");
    }

    public void processFriendRequest() {
        FriendRequest req = requests.remove();
        if (req == null) {
            return;
        }
        User fromUser = users.findUser(req.fromUser);
        User toUser = users.findUser(req.toUser);

        System.out.println("Friend request from " + fromUser.name + " to " + toUser.name);
        System.out.println("Accept? (y/n)");
        Scanner k = new Scanner(System.in);
        String answer = k.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            fromUser.addFriends(toUser.username);
            toUser.addFriends(fromUser.username);
            System.out.println("The friend request accepted.");
        } else {
            System.out.println("The friend request rejected!");
        }
    }

    public void addPosts(String username, String text) {
        User user = users.findUser(username);
        if (user == null) {
            System.out.println("The user not found!");
            return;
        }
        user.post.addPosts(text);
    }

    public void showPosts(String username) {
        User user = users.findUser(username);
        if (user == null) {
            System.out.println("The user not found!");
            return;
        }
        user.post.showPosts();
    }

    public void showFriends(String username) {
        User user = users.findUser(username);
        if (user == null) {
            System.out.println("The user not found!");
            return;
        }
        user.showFriends();
    }

    public void showUsers() {
        users.showUsers();
    }

    public void showMutualFriends(String u1, String u2) {
        graph.showMutualFriends(u1, u2);
    }

    public void shortestPath(String u1, String u2) {
        graph.shortestPath(u1, u2);
    }

    public void searchUser(String username) {
        tree.search(username);
    }

    public void showSortedUsers() {
        tree.SortedUsers();
    }
}
