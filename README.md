# Java Raft Hello World

A simple Java library that provides a hello world message.

## Installation

Add the following to your `build.gradle`:

```gradle
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/unknownpgr/java-raft")
        credentials {
            username = System.getenv("GITHUB_ACTOR")
            password = System.getenv("GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation 'com.github.unknownpgr:java-raft:1.0.0'
}
```

## Usage

```java
import com.github.unknownpgr.raft.HelloWorld;

public class Main {
    public static void main(String[] args) {
        String message = HelloWorld.sayHello();
        System.out.println(message); // Prints: Hello, World!
    }
}
```

## Publishing

To publish a new version:

1. Update the version in `build.gradle`
2. Set the following environment variables:
   - `GITHUB_ACTOR`: Your GitHub username
   - `GITHUB_TOKEN`: Your GitHub personal access token with `write:packages` scope
3. Run `./gradlew publish` 