public class UserTree {
    private TreeNode root;

    public void insert(User user) {
        root = insertRec(root, user);
    }

    private TreeNode insertRec(TreeNode root, User user) {
        if (root == null) {
            return new TreeNode(user);
        }

        if (user.username.compareTo(root.user.username) < 0) {
            root.left = insertRec(root.left, user);
        } else {
            root.right = insertRec(root.right, user);
        }
        return root;
    }

    public void search(String username) {
        TreeNode result = searchRec(root, username);
        if (result == null) {
            System.out.println("User not found!");
        } else
            System.out.println("found user: " + result.user.name);
    }

    private TreeNode searchRec(TreeNode root, String username) {
        if (root == null || root.user.username.equals(username))
            return root;

        if (username.compareTo(root.user.username) < 0)
            return searchRec(root.left, username);

        return searchRec(root.right, username);
    }

    public void SortedUsers() {
        inorder(root);
        System.out.println();
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.user.name + " " + root.user.username + " | ");
            inorder(root.right);
        }
    }
}
