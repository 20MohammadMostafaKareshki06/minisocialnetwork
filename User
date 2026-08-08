import DataStructureProject.PostList;

import java.util.Scanner;

public class User {
    String name;
    String username;
    String[] friends;
    int friendscount;
    PostList post;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
        friends = new String[10];
        this.friendscount = 0;
        this.post = new PostList();
    }

    public void addFriends(String friendusername) {
        friends[friendscount++] = friendusername;
    }

    public void showFriends() {
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
