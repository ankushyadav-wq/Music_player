import java.util.*;

public class Music_Player {

    // Doubly linked list node: each song knows its previous and next song.
    static class Node {
        String title;
        Node prev, next;
        Node(String title) { this.title = title; }
    }

    // Circular doubly linked list used as the playlist.
    static class Playlist {
        Node head, tail, current;
        int size;

        boolean isEmpty() { return size == 0; }

        void add(String title) {
            Node node = new Node(title);
            if (head == null) {
                head = tail = node;
                node.next = node;      // circular: points to itself
                node.prev = node;
            } else {
                node.prev = tail;
                node.next = head;
                tail.next = node;
                head.prev = node;      // last <-> first link
                tail = node;
            }
            size++;
        }

        // Starts the first song if nothing is playing, otherwise keeps the current song.
        Node play() {
            if (current == null) current = head;
            return current;
        }

        // Last song wraps to the first.
        Node next() {
            current = (current == null) ? head : current.next;
            return current;
        }

        // First song wraps to the last.
        Node previous() {
            current = (current == null) ? tail : current.prev;
            return current;
        }
    }

    // Stack (linked implementation) for recently played songs; most recent on top.
    static class HistoryStack {
        private static class Item {
            String title;
            Item below;
            Item(String title, Item below) { this.title = title; this.below = below; }
        }
        private Item top;
        private int size;

        void push(String title) { top = new Item(title, top); size++; }

        String pop() {
            if (top == null) return null;
            String t = top.title;
            top = top.below;
            size--;
            return t;
        }

        boolean isEmpty() { return top == null; }

        List<String> recent(int limit) {
            List<String> result = new ArrayList<>();
            Item cur = top;
            while (cur != null && result.size() < limit) {
                result.add(cur.title);
                cur = cur.below;
            }
            return result;
        }
    }

    // Binary Search Tree of song titles (case-insensitive) for searching.
    static class BST {
        private static class TreeNode {
            String title;
            TreeNode left, right;
            TreeNode(String title) { this.title = title; }
        }
        private TreeNode root;

        void insert(String title) { root = insert(root, title); }

        private TreeNode insert(TreeNode node, String title) {
            if (node == null) return new TreeNode(title);
            int cmp = title.compareToIgnoreCase(node.title);
            if (cmp < 0) node.left = insert(node.left, title);
            else if (cmp > 0) node.right = insert(node.right, title);
            return node;
        }

        String search(String title) {
            TreeNode cur = root;
            while (cur != null) {
                int cmp = title.compareToIgnoreCase(cur.title);
                if (cmp == 0) return cur.title;
                cur = (cmp < 0) ? cur.left : cur.right;
            }
            return null;
        }
    }

    static Playlist playlist = new Playlist();
    static HistoryStack history = new HistoryStack();
    static BST bst = new BST();

    static void addSong(String title) {
        if (title.isEmpty()) {
            System.out.println("Song title cannot be empty.");
            return;
        }
        if (bst.search(title) != null) {
            System.out.println("Song already in playlist: " + title);
            return;
        }
        playlist.add(title);
        bst.insert(title);
        System.out.println("Song added: " + title);
    }

    static void announce(Node song) {
        history.push(song.title);          // every song that starts playing goes on the stack
        String note = (playlist.size == 1) ? " (Only one song in playlist)" : "";
        System.out.println("Now playing: " + song.title + note);
    }

    static boolean checkNotEmpty() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty. Add songs first.");
            return false;
        }
        return true;
    }

    static void play()     { if (checkNotEmpty()) announce(playlist.play()); }
    static void next()     { if (checkNotEmpty()) announce(playlist.next()); }
    static void previous() { if (checkNotEmpty()) announce(playlist.previous()); }

    static void search(String title) {
        if (!checkNotEmpty()) return;
        String found = bst.search(title);
        System.out.println(found != null ? "Song found: " + found : "Song not found: " + title);
    }

    static void recentlyPlayed() {
        if (history.isEmpty()) {
            System.out.println("No songs played yet.");
            return;
        }
        System.out.println("Recently played: " + String.join(", ", history.recent(10)));
    }

    static int readChoice(Scanner sc) {
        while (true) {
            System.out.print("Enter choice: ");
            String line = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= 1 && value <= 7) return value;
            } catch (NumberFormatException e) { /* fall through */ }
            System.out.println("Invalid choice. Enter a number from 1 to 7.");
        }
    }

    static void printMenu() {
        System.out.println("\n===== MUSIC PLAYER =====");
        System.out.println("1. Add song");
        System.out.println("2. Play");
        System.out.println("3. Next");
        System.out.println("4. Previous");
        System.out.println("5. Search song");
        System.out.println("6. Recently played");
        System.out.println("7. Exit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            printMenu();
            if (!sc.hasNextLine()) break;
            int choice = readChoice(sc);
            switch (choice) {
                case 1:
                    System.out.print("Enter song title: ");
                    addSong(sc.nextLine().trim());
                    break;
                case 2: play(); break;
                case 3: next(); break;
                case 4: previous(); break;
                case 5:
                    System.out.print("Enter title to search: ");
                    search(sc.nextLine().trim());
                    break;
                case 6: recentlyPlayed(); break;
                case 7:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
            }
        }
    }
}