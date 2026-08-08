import DataStructureProject.User;

public class UserList {
    private User[] users;
    private int count;

    public UserList(int capacity) {
        this.users = new User[capacity];
        count = 0;
    }

    public void addUser(User u) {
        if (count >= users.length) {
            System.out.println("There is not any space for new users.");
            return;
        }
        users[count++] = u;
    }

    public User findUser(String username) {
        for (int i = 0; i < count; i++) {
            if (users[i].username.equals(username) || users[i].name.equals(username)) {
                return users[i];
            }
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public void showUsers() {
        for (int i = 0; i < count; i++) {
            System.out.print(users[i].name + " - ");
        }
    }

    public int indexOf(String username) {
        for (int i = 0; i < count; i++) {
            if (users[i].username.equals(username))
                return i;
        }
        return -1;
    }

    public User getUserByIndex(int index) {
        if (index < 0 || index >= count)
            return null;
        return users[index];
    }
}
