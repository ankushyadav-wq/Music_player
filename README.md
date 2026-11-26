🎵 Music Player Using Java
  <b>A Console-Based Music Player Powered by Data Structures & Algorithms</b>

📌 About The Project

The Music Player is a menu-driven Java application developed to demonstrate the practical implementation of fundamental Data Structures and Algorithms (DSA).

This project simulates the basic functionalities of a music player, allowing users to add songs, play songs, navigate between tracks, search for songs, and view recently played songs.

The application uses three important data structures: Circular Doubly Linked List, Stack, and Binary Search Tree (BST) to manage playlists, maintain playback history, and perform efficient song searching.

✨ Features

🎶 Add Songs: Add new songs to the playlist.

▶️ Play Music: Start playing the first song or continue with the current song.

⏭️ Next Song: Move to the next song in the playlist.

⏮️ Previous Song: Navigate to the previous song.

🔁 Circular Navigation: Automatically move to the first song after the last song and vice versa.

🔍 Search Songs: Search for songs using a Binary Search Tree.

📜 Recently Played: View the last 10 played songs using Stack.

🚫 Duplicate Prevention: Prevents adding the same song twice.

⚠️ Input Validation: Handles invalid menu choices and empty song titles.

🧠 Data Structures Used

1. Circular Doubly Linked List

Used to manage the playlist.

Each node contains a song title.

Every node maintains references to the previous and next songs.

Supports forward and backward navigation.

Circular connections allow continuous playlist navigation.

2. Stack (LIFO)

Used to maintain recently played songs.

Every played song is pushed onto the stack.

The most recently played song appears first.

Displays up to the last 10 played songs.

3. Binary Search Tree (BST)

Used for searching songs.

Stores song titles in sorted order.

Uses case-insensitive comparisons.

Supports insertion and searching operations.

🛠️ Technologies Used

Programming Language: Java

Data Structures: Circular Doubly Linked List, Stack, Binary Search Tree

Algorithms: BST Insertion and Searching

Input Handling: Java Scanner

IDE: VS Code / IntelliJ IDEA / Eclipse

🚀 How to Run

Follow these steps to run the project on your computer.

1. Clone the Repository

git clone https://github.com/your-username/your-repository-name.git

2. Navigate to the Project Folder

cd your-repository-name

3. Compile the Java Program

javac MusicPlayer.java

4. Run the Application

java MusicPlayer

💻 Sample Output

===== MUSIC PLAYER =====

1. Add song
2. Play
3. Next
4. Previous
5. Search song
6. Recently played
7. Exit

Enter choice: 1
Enter song title: Shape of You
Song added: Shape of You

Enter choice: 1
Enter song title: Perfect
Song added: Perfect

Enter choice: 2
Now playing: Shape of You

Enter choice: 3
Now playing: Perfect

Enter choice: 6
Recently played: Perfect, Shape of You

Enter choice: 7
Goodbye!

📂 Project Structure

Music-Player/
│
├── MusicPlayer.java
└── README.md

⏱️ Time Complexity

Operation

Data Structure

Average / Typical Complexity

Add Song

Linked List + BST

O(1) + O(log n)

Play Song

Linked List

O(1)

Next Song

Linked List

O(1)

Previous Song

Linked List

O(1)

Search Song

BST

O(log n) average

Recently Played

Stack

O(k), up to 10 songs

Note: BST searching and insertion can take O(n) in the worst case if the tree becomes unbalanced.

🎯 Learning Outcomes

Through this project, I gained practical experience in:

Understanding linked lists and circular connections.

Implementing Stack using linked nodes.

Understanding Binary Search Tree operations.

Applying LIFO principles in playback history.

Performing song insertion and searching.

Combining multiple data structures in a single Java application.

Developing a menu-driven Java program.

🔮 Future Enhancements

🎧 Actual audio playback functionality.

🎨 Graphical User Interface (GUI).

📁 Playlist creation and management.

❤️ Favorite songs functionality.

💾 Permanent playlist storage using file handling.

🔀 Shuffle and repeat modes.

👨‍💻 Author
Ankush Kumar Yadav

🎓 B.Tech – Computer Science & Engineering (AI & ML)

🏫 Rungta International Skills University

📚 Project: Data Structures and Algorithms (DSA)

⭐ If you like this project, don't forget to give it a Star!

Built with Java | Powered by Data Structures | Made with ❤️
