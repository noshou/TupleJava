# Tuple (com.oson.tuple)

A simple, immutable, and static **tuple-like** library for Java.

This library provides a suite of fixed-size and variable-size tuple classes (from `Nullad` to `Icosad`, including `Polyad`) that allow you to group multiple comparable elements with full type safety, immutability, and natural ordering. Designed with clarity and zero dependencies in mind.

## ✨ Features

- ✅ **Immutable** – tuples are final and cannot be modified
- 🔒 **Type-safe** – generic parameter `<I extends Comparable<I>>` ensures consistency
- 📚 **Lexicographic comparison** – all tuples implement `Comparable`
- 🔁 **Iterable** – iterate over elements with enhanced `for`-loop
- 🔢 **Indexed access** – retrieve values with bounds checking
- 📐 **Sized variants** – predefined classes from 0 to 20 elements

## 📦 Key Classes

| Class              | Description                            |
|--------------------|----------------------------------------|
| `Tuple<I>`         | Abstract base class with full logic    |
| `Nullad<I>`        | 0-element tuple                        |
| `Monad<I>`         | 1-element tuple                        |
| `Dyad<I>`          | 2-element tuple                        |
| `Triad<I>`         | 3-element tuple                        |
| ...                | ... up to `Icosad<I>` (20 elements)    |
| `Polyad<I>`        | Variable-length tuple of any size      |

Each tuple is comparable and iterable, and offers fast, predictable access via `.fetch(int)` and `.fetchSize()`.

## 🚀 Getting Started

### Maven

Add the following to your `pom.xml`:

```xml
<dependency>
  <groupId>com.oson</groupId>
  <artifactId>tuple</artifactId>
  <version>1.0.0</version>
</dependency>
```

If using GitHub Packages:

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/nathansheaouedraogo/Tuple</url>
  </repository>
</repositories>
```

### Gradle

```gradle
dependencies {
    implementation 'com.oson:tuple:1.0.0'
}
```

## 🧪 Example Usage

### Basic Usage

```java
import com.oson.tuple.Triad;

// Create a 3-element tuple
Triad<String> triple = new Triad<>("apple", "banana", "cherry");

// Print the tuple
System.out.println(triple);         // ⟨apple, banana, cherry⟩

// Access elements by index
String first = triple.fetch(0);     // "apple"
String second = triple.fetch(1);    // "banana"
String third = triple.fetch(2);     // "cherry"

// Get the size
int size = triple.fetchSize();      // 3

// Iterate over elements
for (String item : triple) {
    System.out.println(item);
}
```

### Different Tuple Types

```java
import com.oson.tuple.*;

// Empty tuple
Nullad<String> empty = new Nullad<>();

// Single element
Monad<Integer> single = new Monad<>(42);

// Two elements
Dyad<String> pair = new Dyad<>("hello", "world");

// Variable-length tuple
Polyad<String> many = new Polyad<>("a", "b", "c", "d", "e");
```

### Comparison and Sorting

```java
import com.oson.tuple.Triad;
import java.util.Arrays;
import java.util.Collections;

// Create tuples for comparison
Triad<String> t1 = new Triad<>("apple", "banana", "cherry");
Triad<String> t2 = new Triad<>("apple", "banana", "date");
Triad<String> t3 = new Triad<>("apple", "blueberry", "cherry");

// Compare tuples (lexicographic order)
System.out.println(t1.compareTo(t2)); // negative (cherry < date)
System.out.println(t1.compareTo(t3)); // negative (banana < blueberry)

// Sort tuples
List<Triad<String>> tuples = Arrays.asList(t3, t1, t2);
Collections.sort(tuples);
System.out.println(tuples); // [t1, t2, t3] in lexicographic order
```

## 🏗️ Architecture

The library is built around a clean inheritance hierarchy:

- **`Tuple<I>`** - Abstract base class containing all common functionality
- **Fixed-size classes** - `Nullad`, `Monad`, `Dyad`, `Triad`, etc. up to `Icosad`
- **Variable-size class** - `Polyad` for tuples of any length

All classes are:
- **Immutable** - cannot be modified after creation
- **Type-safe** - all elements must be of the same comparable type
- **Comparable** - support natural ordering via lexicographic comparison
- **Iterable** - can be used in enhanced for-loops

## 📋 API Reference

### Core Methods

| Method | Description |
|--------|-------------|
| `fetch(int index)` | Get element at specified index (with bounds checking) |
| `fetchSize()` | Get the number of elements in the tuple |
| `iterator()` | Get an iterator over the tuple elements |
| `compareTo(Tuple<I> other)` | Compare tuples lexicographically |
| `equals(Object obj)` | Check equality with another object |
| `hashCode()` | Get hash code for the tuple |
| `toString()` | Get string representation: `⟨elem1, elem2, ...⟩` |

### Constructors

Each tuple class has a constructor that accepts the appropriate number of elements:

```java
new Nullad<>()                           // 0 elements
new Monad<>(a)                          // 1 element
new Dyad<>(a, b)                        // 2 elements
new Triad<>(a, b, c)                    // 3 elements
// ... up to
new Icosad<>(a, b, c, ..., t)          // 20 elements
new Polyad<>(a, b, c, ...)             // any number of elements
```

## 🛠️ Development

### Building the Project

To build and install locally:

```bash
mvn clean install
```

### Running Tests

```bash
mvn test
```

### Deploying to GitHub Packages

```bash
mvn deploy
```

Make sure you have your GitHub credentials configured in `~/.m2/settings.xml`.

### Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 Requirements

- Java 8 or higher
- Maven 3.6 or higher (for building)
- Zero runtime dependencies

## 📄 License

MIT License. See [LICENSE](LICENSE) for details.

## 📬 Contact

**Maintained by Nathan Shea Ouedraogo**

- GitHub: [@nathansheaouedraogo](https://github.com/nathansheaouedraogo)
- Project Link: [https://github.com/nathansheaouedraogo/Tuple](https://github.com/nathansheaouedraogo/Tuple)
