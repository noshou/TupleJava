# Tuple (com.oson.tuple)
A simple, immutable, and static **tuple-like** library for Java Provides fixed-size, immutable tuple classes (from Monad up to Icosad, including polyad for n-tuples) that enable grouping multiple comparable elements with lexicographic ordering. Designed for straightforward usage without dependencies, emphasizing immutability and type safety.

## Overview

This library offers a hierarchy of generic tuple classes, each representing a fixed-size immutable collection of comparable elements. From zero-element (`Nullad`) tuples to arbitrary-sized tuples like `Polyad`, it supports:

- **Immutability:** Tuple contents cannot be changed after creation.
- **Type Safety:** Generic typing ensures type consistency.
- **Lexicographic Comparison:** Tuples implement `Comparable`, enabling natural ordering.
- **Iteration:** Tuples are iterable over their elements.
- **Convenient Access:** Indexed fetch methods with bounds checking.
- **Predefined Sizes:** Common tuple sizes are implemented as separate classes for ease of use.

## Key Classes

- `Tuple<I extends Comparable<I>>`  
  Abstract base class with core logic, storage, and ordering.

- `Nullad<I>`  
  Zero-element tuple (empty tuple).

- `Polyad<I>`  
  Variable-length tuple supporting any number of elements.

- Fixed-size tuples like:  
  `Monad`, `Dyad`, `Triad`, `Tetrad`, ..., up to `Icosad` (20 elements) and special sizes like `Enneakaidecad` (19 elements).
## Importing
Add the dependency in your Maven `pom.xml`:

```xml
<dependency>
    <groupId>com.oson</groupId>
    <artifactId>tuple</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage Example

```java
import com.oson.tuple.Triad;

Triad<String> triple = new Triad<>("apple", "banana", "cherry");

System.out.println(triple); // Prints: ⟨apple, banana, cherry⟩

String first = triple.fetch(0); // "apple"
int size = triple.fetchSize(); // 3

for (String item : triple) {
    System.out.println(item);
}

