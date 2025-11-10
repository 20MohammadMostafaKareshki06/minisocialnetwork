import java.util.Scanner;

class Post {
    String content;
    Post next;

    public Post(String content) {
        this.content = content;
        this.next = null;
    }
}

class Post_List {
    private Post head;

    public void add_Posts(String text) {
        Post newPost = new Post(text);
        if (head == null) {
            head = newPost;
        } else {
            Post temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newPost;
            System.out.println("The post add.");
        }
    }

    public void show_Posts() {
        if (head == null) {
            System.out.println("There is not any posts!");
            return;
        }
        Post temp = head;
        System.out.println("Posts lists:");
        while (temp != null) {
            System.out.println(temp.content + " _ ");
            temp = temp.next;
        }
    }
}

class Friend_Request {
    String toUser;
    String fromUser;

    public Friend_Request(String fromUser, String toUser) {
        this.toUser = toUser;
        this.fromUser = fromUser;
    }
}

class Friend_Request_Queue {
    private Friend_Request[] queue;
    private int front, rear, capacity, size;

    public Friend_Request_Queue(int capacity) {
        queue = new Friend_Request[capacity];
        this.capacity = capacity;
        size = 0;
        front = 0;
        rear = -1;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Friend_Request req) {
        if (isFull()) {
            System.out.println("The queue requestes is full!");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = req;
        size++;
    }

    public Friend_Request remove() {
        if (isEmpty()) {
            System.out.println("THe queue is empty!");
            return null;
        }
        Friend_Request req = queue[front];
        front = (front + 1) % capacity;
        size--;
        return req;
    }
}

class User {
    String name;
    String username;
    String[] friends;
    int friendscount;
    Post_List post;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
        friends = new String[10];
        this.friendscount = 0;
        this.post = new Post_List();
    }

    public void add_Friends(String friendusername) {
        friends[friendscount++] = friendusername;
    }

    public void show_Friends() {
        if (friendscount == 0) {
            System.out.println("There is not any friends.");
            return;
        }
        System.out.println("friends " + name + ":");
        for (int i = 0; i < friendscount; i++) {
            System.out.print(friends[i] + " _ ");
        }
    }
}

class User_List {
    private User[] users;
    private int count;

    public User_List(int capacity) {
        this.users = new User[capacity];
        count = 0;
    }

    public void add_User(User u) {
        if (count >= users.length) {
            System.out.println("There is not any space for new users.");
            return;
        }
        users[count++] = u;
    }

    public User find_User(String username) {
        for (int i = 0; i < count; i++) {
            if (users[i].username.equals(username) || users[i].name.equals(username)) {
                return users[i];
            }
        }
        return null;
    }

    public int get_count() {
        return count;
    }
}

class Social_NetWork {
    private User_List users;
    private Friend_Request_Queue requests;

    public Social_NetWork(int usercapacity, int queuecapacity) {
        users = new User_List(usercapacity);
        requests = new Friend_Request_Queue(queuecapacity);
    }

    public void register_User(String name, String username) {
        if (users.find_User(username) != null) {
            System.out.println("The username is duplicated!");
            return;
        }
        users.add_User(new User(name, username));
        System.out.println("User " + name + " seccessfully registered.");
    }

    public void send_friend_request(String from, String to) {
        User sender = users.find_User(from);
        User receiver = users.find_User(to);

        if (sender == null || receiver == null) {
            System.out.println("The User not found!");
            return;
        }
        requests.add(new Friend_Request(from, to));
        System.out.println("Friend request send.");
    }

    public void process_friend_request() {
        Friend_Request req = requests.remove();
        if (req == null) {
            return;
        }
        User fromUser = users.find_User(req.fromUser);
        User toUser = users.find_User(req.toUser);

        System.out.println("Friend request from " + fromUser.name + " to " + toUser.name);
        System.out.println("Accept? (y/n)");
        Scanner k = new Scanner(System.in);
        String answer = k.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            fromUser.add_Friends(toUser.name);
            toUser.add_Friends(fromUser.name);
            System.out.println("The friend request accepted.");
        } else {
            System.out.println("The friend request rejected!");
        }
    }

    public void add_Posts(String username, String text) {
        User user = users.find_User(username);
        if (user == null) {
            System.out.println("The user not found!");
            return;
        }
        user.post.add_Posts(text);
    }

    public void show_Posts(String username) {
        User user = users.find_User(username);
        if (user == null) {
            System.out.println("The user not found!");
            return;
        }
        user.post.show_Posts();
    }

    public void show_friends(String username) {
        User user = users.find_User(username);
        if (user == null) {
            System.out.println("The user not found!");
            return;
        }
        user.show_Friends();
    }
}

public class MiniSocialNetwork {
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        Social_NetWork s = new Social_NetWork(10, 10);

        while (true) {
            System.out.println();
            System.out.println("=============Mini Social Network=============");
            System.out.println("1. register user: ");
            System.out.println("2. send friend request: ");
            System.out.println("3. check friend request: ");
            System.out.println("4. send post: ");
            System.out.println("5. show user's post");
            System.out.println("6. show user's friends: ");
            System.out.println("0. exit: ");
            int choose = k.nextInt();
            k.nextLine();

            switch (choose) {
                case 1 -> {
                    System.out.print("name: ");
                    String name = k.nextLine();
                    System.out.print("username: ");
                    String username = k.nextLine();
                    s.register_User(name, username);
                }
                case 2 -> {
                    System.out.print("from user: ");
                    String fromuser = k.nextLine();
                    System.out.print("to user: ");
                    String touser = k.nextLine();
                    s.send_friend_request(fromuser, touser);
                }
                case 3 -> s.process_friend_request();
                case 4 -> {
                    System.out.print("username: ");
                    String username = k.nextLine();
                    System.out.print("content post: ");
                    String txt = k.nextLine();
                    s.add_Posts(username, txt);
                }
                case 5 -> {
                    System.out.print("username: ");
                    String username = k.nextLine();
                    s.show_Posts(username);
                }
                case 6 -> {
                    System.out.print("username: ");
                    String name = k.nextLine();
                    s.show_friends(name);
                }
                case 0 -> {
                    System.out.println("End of program.");
                    return;
                }
                default -> System.out.println("incorrect number!");
            }
        }
    }
}