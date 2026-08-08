import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostList {
    private Post head;

    public void addPosts(String text) {
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

    public void showPosts() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd | HH:mm:ss");
        String timestamp = now.format(formatter);

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
        System.out.println(timestamp);
    }
}
