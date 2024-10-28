# Duke - A CLI Task Management Chatbot

## 🤖 Overview
Duke is a command-line interface (CLI) chatbot that helps users manage their tasks, events, and deadlines through natural language interaction. Built in Java, it demonstrates object-oriented programming principles and clean architecture design.

```
 ____        _        
|  _ \ _   _| | _____ 
| | | | | | | |/ / _ \
| |_| | |_| |   <  __/
|____/ \__,_|_|\_\___|

Hello! I'm Duke 🤖
What can I do for you today?
```

## ✨ Features

### Task Management
- **Add Tasks**: Create different types of tasks
  ```
  todo read book
  deadline return book /by Sunday
  event team meeting /at Mon 2-4pm
  ```

- **List Tasks**: View all tasks
  ```
  list
  1.[✓] read book
  2.[✗] return book (by: Sunday)
  3.[✗] team meeting (at: Mon 2-4pm)
  ```

- **Mark Tasks**: Mark tasks as done
  ```
  done 1
  Marked this task as done:
  [✓] read book
  ```

- **Delete Tasks**: Remove tasks
  ```
  delete 2
  Removed this task:
  [✗] return book (by: Sunday)
  ```

### Data Persistence
- Automatically saves tasks to local storage
- Loads previous tasks on startup
- Maintains task state between sessions

## 🏗️ Architecture

```
src/
├── main/
│   ├── java/
│   │   ├── duke/
│   │   │   ├── Duke.java           # Main application class
│   │   │   ├── command/            # Command pattern implementation
│   │   │   ├── parser/             # Input parsing logic
│   │   │   ├── storage/            # Data persistence
│   │   │   ├── task/              # Task-related classes
│   │   │   └── ui/                # User interface
│   └── resources/
└── test/
    └── java/
        └── duke/                   # Test classes
```

### Design Patterns Used
1. **Command Pattern**: For executing different user commands
2. **Singleton Pattern**: For storage management
3. **Factory Pattern**: For creating different task types

## 🚀 Getting Started

### Prerequisites
- JDK 11 or higher
- IntelliJ IDEA (recommended)

### Installation

1. Clone the repository
```bash
git clone https://github.com/yourusername/duke.git
```

2. Open in IntelliJ IDEA
- Click `Open`
- Select the project directory
- Wait for project indexing to complete

3. Configure JDK
- Set Project SDK to JDK 11
- Set Project language level to SDK default

4. Run the application
```bash
./gradlew run
```

### Running Tests
```bash
./gradlew test
```

## 💻 Usage Examples

### Basic Task Management
```
> todo read book
Got it. I've added this task:
[✗] read book
Now you have 1 tasks in the list.

> deadline return book /by Sunday
Got it. I've added this task:
[✗] return book (by: Sunday)
Now you have 2 tasks in the list.

> done 1
Nice! I've marked this task as done:
[✓] read book
```

### Finding Tasks
```
> find book
Here are the matching tasks in your list:
1.[✓] read book
2.[✗] return book (by: Sunday)
```

### Error Handling
```
> done 999
☹ OOPS!!! The task number is invalid.

> todo
☹ OOPS!!! The description of a todo cannot be empty.
```

## 🧪 Testing

### Unit Tests
- Task creation and manipulation
- Command parsing
- Storage operations

### Integration Tests
- End-to-end command execution
- Data persistence
- Error handling

## 📝 Class Documentation

### Core Classes

#### `Duke`
Main class that orchestrates the chatbot's operations
```java
public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    
    public Duke(String filePath) {
        // Initialize components
    }
    
    public void run() {
        // Main operation loop
    }
}
```

#### `Task`
Base class for all task types
```java
public abstract class Task {
    protected String description;
    protected boolean isDone;
    
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }
    
    // Common task methods
}
```

## 🛠️ Technical Implementation

### Data Storage
- Uses text file for persistence
- Custom serialization format
- Atomic write operations

### Error Handling
- Custom exceptions for different scenarios
- Graceful error recovery
- User-friendly error messages

### Input Processing
- Command parsing using regex
- Flexible date/time format parsing
