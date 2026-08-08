import java.util.Scanner;

public class MiniSocialNetWork {

    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        SocialNetWork s = new SocialNetWork(10, 10);

        while (true) {
            System.out.println();
            System.out.println("=============Mini Social Network=============");
            System.out.println("1. register user: ");
            System.out.println("2. send friend request: ");
            System.out.println("3. check friend request: ");
            System.out.println("4. send post: ");
            System.out.println("5. show user's post: ");
            System.out.println("6. show user's friends: ");
            System.out.println("7. Show users: ");
            System.out.println("8. Mutual friends: ");
            System.out.println("9. shortest path: ");
            System.out.println("10. search user: ");
            System.out.println("11. show sorted users: ");
            System.out.println("0. exit: ");
            int choose = k.nextInt();
            k.nextLine();

            switch (choose) {
                case 1 -> {
                    System.out.print("name: ");
                    String name = k.nextLine();
                    System.out.print("username: ");
                    String username = k.nextLine();
                    s.registerUser(name, username);
                }
                case 2 -> {
                    System.out.print("from user: ");
                    String fromuser = k.nextLine();
                    System.out.print("to user: ");
                    String touser = k.nextLine();
                    s.sendFriendRequest(fromuser, touser);
                }
                case 3 -> s.processFriendRequest();
                case 4 -> {
                    System.out.print("username: ");
                    String username = k.nextLine();
                    System.out.print("content post: ");
                    String txt = k.nextLine();
                    s.addPosts(username, txt);
                }
                case 5 -> {
                    System.out.print("username: ");
                    String username = k.nextLine();
                    s.showPosts(username);
                }
                case 6 -> {
                    System.out.print("username: ");
                    String name = k.nextLine();
                    s.showFriends(name);
                }
                case 7 -> {
                    System.out.print("users: ");
                    s.showUsers();
                }

                case 8 -> {
                    System.out.println("username 1: ");
                    String user1 = k.nextLine();
                    System.out.println("username 2: ");
                    String user2 = k.nextLine();
                    s.showMutualFriends(user1, user2);
                }


                case 9 -> {
                    System.out.println("start from user: ");
                    String start = k.nextLine();
                    System.out.println("End to user: ");
                    String end = k.nextLine();
                    s.shortestPath(start, end);
                }

                case 10 -> {
                    System.out.println("username: ");
                    String username = k.nextLine();
                    s.searchUser(username);
                }

                case 11 -> {
                    s.showSortedUsers();
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
