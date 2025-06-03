# Java Raft Key-Value Store

A simple thread-safe key-value storage implementation in Java.

## Installation

Add the following to your `build.gradle`:

```gradle
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/unknownpgr/java-raft")
    }
}

dependencies {
    implementation 'com.github.unknownpgr:java-raft:1.0.0'
}
```

## Usage

```java
import com.github.unknownpgr.raft.KeyValueStore;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Create a new key-value store
        KeyValueStore store = new KeyValueStore();

        // Store a value
        store.put("name", "John Doe");

        // Retrieve a value
        Optional<String> value = store.get("name");
        value.ifPresent(System.out::println); // Prints: John Doe

        // Check if a key exists
        boolean exists = store.containsKey("name"); // Returns: true

        // Remove a value
        String removed = store.remove("name");

        // Get the number of entries
        int size = store.size();

        // Clear all entries
        store.clear();
    }
}
```

## Features

- Thread-safe operations using ConcurrentHashMap
- Null safety with Optional for get operations
- Basic CRUD operations (Create, Read, Update, Delete)
- Size tracking and store clearing capabilities

## Publishing

To publish a new version:

1. Update the version in `build.gradle`
2. Set the following environment variables:
   - `GITHUB_ACTOR`: Your GitHub username
   - `GITHUB_TOKEN`: Your GitHub personal access token with `write:packages` scope
3. Run `./gradlew publish`

## License

This project is licensed under the Apache License 2.0 - see the LICENSE file for details. 