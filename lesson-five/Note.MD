## 🧠 **Lesson Title**: Advanced Java Features, Exception Handling, and Multithreading

### 📍 **Goal**:

Help students understand how to handle exceptions, manage threads and concurrency, explore Java reflection, generics, annotations, and apply basic design patterns.

---

## 📘 Part 1: Exception Handling

### 📝 Concepts to Cover:

* `try`, `catch`, `finally`
* `throw` vs `throws`
* Custom exceptions
* Checked vs Unchecked exceptions
<br><br>
#### `try`, `catch`, `finally` <br>
These blocks allow you to handle runtime errors (exceptions) gracefully.

`try`: Encloses the code that might throw an exception.
`catch`: Handles the specific exception type.
`finally`: Executes code after the try-catch, regardless of the outcome (often used for resource cleanup).

#### `throw` vs `throws`<br>
`throw`: Used to explicitly throw an exception in your code.
`throws`: Declares in a method signature that the method might throw an exception.

#### Custom Exceptions
Creating your own exception class (extending Exception or RuntimeException) allows better control and clarity when handling domain-specific errors.

#### Checked vs Unchecked Exceptions
Checked: Must be declared in the method signature or handled with try-catch (e.g., IOException).
They are meant for recoverable conditions, like file not found, network issues, etc

Unchecked: Do not require explicit handling (e.g., NullPointerException).
Usually represent programming errors, like logic bugs or incorrect use of an API. 
They are considered non-recoverable, so catching them isn't always recommended.

---

## ⚙️ Part 2: Concurrency Tools
Concurrency refers to the ability of a program to execute multiple tasks or parts of a task simultaneously. It allows for more efficient use of system resources, especially CPU cores, and helps in building responsive and scalable applications. For instance, a web server handling multiple user requests or a GUI app that reads a file while updating its interface both benefit from concurrency.
Here's a **crash course in Multithreading in Java**, crafted to get you up to speed quickly with core concepts, code examples, and best practices.

### 📝 Multithreading Basics - Concepts to Cover:

Multithreading is a programming technique where multiple threads (smaller units of a process) run concurrently to perform tasks in parallel. Java provides built-in support for multithreaded programming.

#### Thread Creation (Thread, Runnable)

`Thread`: Extend the Thread class and override the run() method.

`Runnable`: Implement the Runnable interface and pass it to a Thread object.
<br>
<br>
### 🔄 Thread Lifecycle

New: Thread is created but not started.

Runnable: Thread is ready to run.

Running: Thread is executing.

Blocked/Waiting: Thread is waiting for resources or signals.

Terminated/Dead: Thread has completed execution or was interrupted.
<br>
<br>
#### join(), sleep(), yield()

join(): Waits for another thread to finish.

sleep(ms): Pauses the current thread for the specified duration.

yield(): Suggests that the thread scheduler give other threads a chance to run.

### 🆚 Multithreading vs Concurrency

| Concept    | Multithreading                                   | Concurrency                                                             |
| ---------- | ------------------------------------------------ | ----------------------------------------------------------------------- |
| Definition | Multiple threads within a single process         | Multiple tasks running "at the same time" (not necessarily in parallel) |
| Goal       | Parallelism                                      | Responsiveness / Task coordination                                      |
| Focus      | Performance via parallel execution               | Structure and management of multiple tasks                              |
| Example    | One app calculating and rendering simultaneously | Server handling many client requests                                    |

**Note**: Concurrency is the broader concept; **multithreading is one way to achieve concurrency**.

### 🔧 How to Create Threads in Java
#### ✅ Option 1: **Extending `Thread`**
#### ✅ Option 2: **Implementing `Runnable`**

### 🆚 `Thread` vs `Runnable`
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Running in a thread!");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // DO NOT call run() directly
    }
}
```
| Feature       | `Thread` class                                 | `Runnable` interface                    |
| ------------- | ---------------------------------------------- | --------------------------------------- |
| Inheritance   | Inherits `Thread` (can’t extend another class) | Implements an interface (more flexible) |
| Reusability   | Less reusable                                  | More reusable                           |
| Best Practice | Not preferred for large systems                | Preferred in modern applications        |
| Decoupling    | Tightly coupled                                | Loosely coupled (better separation)     |

**Best practice:** Use `Runnable` (or even better, **`ExecutorService`** for managing thread pools).

---

### 🧪 Common Thread Methods

* `start()` – Starts the thread.
* `run()` – The code to run in the thread.
* `sleep(ms)` – Pauses the thread.
* `join()` – Waits for a thread to finish.
* `yield()` – Suggests the current thread should pause for others.

---

### ⚠️ Multithreading Pitfalls

* **Race Conditions** – Two threads modify shared data without proper synchronization.
* **Deadlocks** – Two threads wait indefinitely for each other's locks.
* **Starvation** – One thread never gets access to resources due to others hogging it.
* **Thread Safety** – Use synchronized blocks or `java.util.concurrent` utilities.

---

### 💡 Use `ExecutorService` Instead of Manual Threads

```java
ExecutorService executor = Executors.newFixedThreadPool(2);
executor.submit(() -> System.out.println("Task 1"));
executor.submit(() -> System.out.println("Task 2"));
executor.shutdown();
```

This is **cleaner**, **scalable**, and avoids managing threads manually.

### 📝 Concepts to Cover:

#### synchronized: 
Restricts access to a block or method to one thread at a time, ensuring thread safety and data consistency.

#### ReentrantLock: 
A more flexible alternative to synchronized. It allows explicit lock/unlock calls and supports features like fairness and interruptibility.

#### Semaphore: 
Controls access to a resource using a fixed number of permits. Useful for limiting concurrent access (e.g., allowing only 3 threads to access a resource simultaneously).

#### ExecutorService and Thread Pools:
The Executor framework manages a pool of threads, enabling efficient task execution. It avoids the overhead of creating new threads for each task.

---

### Summary

* **Multithreading** enables better CPU utilization by parallelizing tasks.
* Prefer **`Runnable`** over extending `Thread`.
* Use **`ExecutorService`** for production-quality apps.
* Always manage shared resources carefully using **synchronization**, **locks**, or **concurrent collections**.

---

## 🔍 Part 4: Reflection, Generics, Annotations
These three features enable Java to support dynamic behavior, code reuse, and metadata-driven programming—all essential for modern software development.

### 📝 Concepts to Cover:

### 📘 Reflection:
Enables inspection and manipulation of classes, methods, and fields at runtime. Widely used in frameworks like Spring and Hibernate for dynamic object manipulation.
Allows inspection and interaction with classes and objects at runtime. Useful in building dynamic applications and frameworks.

```java
Class<?> clazz = Class.forName("java.lang.String");
Method[] methods = clazz.getDeclaredMethods();
for (Method method : methods) {
    System.out.println(method.getName());
}
```

### 📘 Generics:
Ensure compile-time type safety and reduce the need for casting in collections and methods. They help prevent ClassCastException and improve code readability and reusability.
Allow type parameters (e.g., List<T>), enabling safer and cleaner code. Help ensure type safety without sacrificing flexibility.

```java
public class Box<T> {
    private T item;
    public void set(T item) { this.item = item; }
    public T get() { return item; }
}
```

### 📘 Annotations:
Provide metadata about code elements. Frameworks use them to automate behaviors, reduce boilerplate, and enforce configurations (e.g., @Autowired, @Override).
Metadata added to code for configuration or behavior description. Common in modern Java development for declarative programming.

```java
@interface MyAnnotation {
    String value();
}

@MyAnnotation(value = "Sample")
public class MyClass {}
```

---

## 🧩 Part 5: Basic Design Patterns
Design patterns are general reusable solutions to common software design problems. Rather than solving a problem from scratch, patterns provide a proven approach, enabling developers to write efficient, scalable, and maintainable code.
#### Benefits of Using Design Patterns:

Proven Solutions: Avoid reinventing the wheel by using well-established techniques.

Shared Language: Improve communication among developers.

Maintainability and Scalability: Encourage modular and extensible code.

Loose Coupling and High Cohesion: Result in more organized and testable codebases.

### 1. Singleton Pattern:
Ensures that only one instance of a class exists during the application’s lifetime. Commonly used for configuration managers or logging services.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
```

### 2. Factory Pattern:
Encapsulates object creation. Delegates instantiation to a factory method, promoting flexibility and decoupling from specific class implementations.

```java
interface Shape {
    void draw();
}
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}
class ShapeFactory {
    public Shape getShape(String type) {
        return switch (type) {
            case "circle" -> new Circle();
            default -> null;
        };
    }
}
```

### 3. Strategy Pattern:
Defines a family of interchangeable algorithms. Clients can switch strategies at runtime without changing the context object.

```java
interface PaymentStrategy {
    void pay(int amount);
}
class CreditCard implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using CreditCard");
    }
}
```

---

## 🧪 Project: File Reader Application

### Features:

* Reads a file line-by-line
* Uses multithreading to read chunks in parallel (bonus)
* Uses exception handling
* Simple design pattern (e.g., Strategy for handling file formats)

---

## 🧠 Summary

| Topic                  | Skill Level  |
| ---------------------- | ------------ |
| Exception Handling     | Intermediate |
| Multithreading         | Intermediate |
| Concurrency Tools      | Advanced     |
| Reflection/Annotations | Advanced     |
| Design Patterns (3)    | Intermediate |

