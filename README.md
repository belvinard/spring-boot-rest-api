# Spring rest API

### When we develop the resful web services using spring MVC, we always use

- **`@Controller`** annotation to make a Java class as Spring MVC controller
- **`@ResponseBody`** to tell controler that the object returned is automatically serialized into JSON and passed back into the HttpResponse object
- **`@RestController`** = `@Controller` + `@ResponseBody`

## Creating simple REST API
- Create the method
- Use spring annotation to make that mehod as a REST API
- **`@GetMapping`** annotation to map HTTP GET request onto specific handler method 
- Configure url for this rest API like this :  `@GetMapping("/hello-world")`

### Understanding the Components
* `@Controller`: This annotation marks a Java class as a Spring MVC controller, making it eligible to handle incoming web requests.
* `@ResponseBody`:This annotation indicates that the object returned by a controller method should be serialized into a specified format (e.g., JSON) and directly written to the HTTP response body.
* `@RestController`: This is a combination of `@Controller` and `@ResponseBody`. It simplifies the creation of RESTful services by automatically serializing the returned objects into JSON.

## Creating of REST API that return **Java Bean**

### JavaBean Overview

A **JavaBean** is a reusable software component in Java that follows a specific set of conventions, making it suitable for use in various Java-based frameworks and tools, such as **Spring** or **JavaServer Pages (JSP)**. JavaBeans are commonly used to represent objects with properties that can be easily accessed and manipulated.

## Key Characteristics of a JavaBean

### 1. Must have a public no-argument constructor
This allows the bean to be instantiated easily, including by frameworks and libraries that rely on reflection.

### 2. Properties must be accessible using getter and setter methods
Properties of a JavaBean should be accessible using standard method naming conventions:
- `get` for reading a property (e.g., `getName()`).
- `set` for modifying a property (e.g., `setName(String name)`).

### 3. Must be serializable
A JavaBean implements the `java.io.Serializable` interface, allowing it to be converted into a byte stream for storage or transfer over a network.

# Steps
**1. Create Student Java Bean**
The `Student` class is a simple JavaBean that holds the student's information such as `id`, `firstName`, and `lastName`.
- Example : 
```java
public class Student {
    private int id;
    private String firstName;
    private String lastName;}
```
**2. Create spring MVC controller**
Next, we create a Spring MVC controller to handle requests related to the Student object.
- Create `StudentController` class.
- Define the Java method `public Student getStudent()`.
- Create Student object `Student student = new Student()` and pass the value of constructor. that returns a `Student` object.
- Instantiate a `Student` object using the constructor `new Student()` and pass values for `id`, `firstName`, and `lastName`.
- Use the `@GetMapping` annotation to make the Java method accessible as a REST API endpoint.


# Steps to Create a Spring Boot REST API that Returns a List (JSON Format)

### 1. Create the `Student` Java Bean

The `Student` class will represent the student entity, containing fields like `id`, `firstName`, and `lastName`.

**Example:**

```java
public class Student {
    private int id;
    private String firstName;
    private String lastName;

    // Constructor
    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
```

### 2. Create a Spring Boot REST API to Return a List of Students
Now, create a Spring MVC controller to handle HTTP requests and return a list of `Student` objects as JSON.
**Steps:**
* Create a `StudentController` class.
* Define a method public `List<Student> getStudents()` that returns a list of Student objects.
* Annotate the method with `@GetMapping("/students")` to expose it as a REST endpoint.
- Example
```java
public List<Student> getStudents() {
        // Creating a list of Student objects
        List<Student> students = Arrays.asList(
                new Student(1, "Belvi", "Pachinco"),
                new Student(2, "John", "Doe"),
                new Student(3, "Jane", "Smith")
        );
        return students;
    }
```

# Steps to Create a Spring Boot REST API with `@PathVariable`

### 1. Create the `Student` Java Bean

This class represents the student entity with fields such as `id`, `firstName`, and `lastName`.

### 2. Create a Spring Boot REST API with  `@PathVariable `
The  `@PathVariable ` annotation allows you to capture values from the URI and pass them to your controller methods.

**Steps:**

* Create a `StudentController` class.
* Define a method `public Student getStudentById(@PathVariable int id)` to return a Student object based on the provided ID.
* Use `@GetMapping("/students/{id}")` to bind the path variable from the URL to the method parameter.
****`{id}`** is called **URI template variable**
```java
@RestController
public class StudentController {

    // Method to return a student based on the ID passed in the URL
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        // For demonstration, creating a static student based on ID
        return new Student(id, "Belvi", "Pachinco");
    }
}
```
The **@PathVariabl** annotation used on method argument to bind it to the value of a URI template variable.
**URI** stands for Uniform Resource Identifier
The **@PathVariabl** annotation in Spring MVC is used to extract values from the URI path of a request and bind them to method parameters in a controller.


# Steps to Create a Spring Boot REST API with `@RequestParam`
The `@RequestParam` annotation in Spring is used to extract query parameters from the URL of an HTTP request and bind them to method parameters in a controller. It allows you to access parameters that are sent in the URL after the ? symbol as key-value pairs.

### Goal of `@RequestParam:`
The primary goal of `@RequestParam` is to capture and use the data sent in query strings in HTTP requests. These parameters are typically passed to a REST API as part of a URL and help refine or specify the request.
### Example Use Cases:
* 1. **Filtering data:** For example, retrieving a list of students with a specific ID, name, or age.
* 2. **Paging and sorting:** Handling parameters like page and size to implement pagination in the response.
* 3. **Search functionality:** Extracting search terms or filters from the query string.

## Example of query parameter :
- http://localhost:8080/students?id=1 **id=1** is called `Query parameter`


### 1. Create the `Student` Java Bean

This class represents the student entity with fields such as `id`, `firstName`, and `lastName`.

### 2. Create a Spring Boot REST API using `@RequestParam`

The `@RequestParam` annotation is used to extract query parameters from the URL in HTTP requests. You can capture one or more parameters from the query string.

# Steps:
* Create a `StudentController` class.
* Define a method `public Student getStudentByParams(@RequestParam int id, @RequestParam String firstName)` to return a Student object.
* Use `@GetMapping("/students")` to define the URL endpoint.

**Example:**
```java
@RestController
public class StudentController {

    // Method to return a student based on query parameters passed in the URL
    @GetMapping("/students")
    public Student getStudentByParams(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        // Create a new student object using the provided query parameters
        return new Student(id, firstName, lastName);

    }

}
```

# Steps to Create a Spring Boot REST API Handling a POST Request

## 1. Create a `Student` Java Bean

This will represent the object that you'll be receiving in the POST request body.

**Example:**

```java
public class Student {
    private int id;
    private String firstName;
    private String lastName;

    // Constructors
    public Student() {
    }

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
```
## 2. Create a Spring Boot Controller to Handle HTTP POST Request 
This controller will define a method that handles POST requests to create a Student object.

**Example**
```java 
@RestController
public class StudentController {

    // Method to handle POST request to create a new student
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        // Here you would typically save the student to a database
        // For demonstration, we're just returning the student object
        return student;
    }
}
```

**Explanation:**
* **@RestController:** This annotation tells Spring that this class is a REST controller, where each method returns a JSON or XML response by default.
* **@PostMapping("/students"):** This annotation maps HTTP POST requests to the `/students` URL.
* **@RequestBody:** This annotation binds the JSON payload from the POST request body to the Student object.
* Add `@RequestBody` annotation
## @RequestBody annotation is responsible for retrieving the HTTP request body and automatically converting it to the Java object 


- We use **`@PutMapping`** annotation for mapping HTTP PUT request onto specific handler method
- We use **`@DeleteMapping`** annotation for mapping HTTP DELETE request onto specific handler method

- **`ResponseEntity`** is a powerful and flexible class in Spring used to represent the entire HTTP response, including the status code, headers, and body. It allows developers to customize how the API responds to client requests.


- Spring boot annotation sheet link : file:///D:/Java/Spring-Boot/Spring%20Boot2/09%20-%20Spring%20Boot%20-%20Building%20REST%20APIs/013%20Spring%20and%20Spring%20Boot%20Annotations%20Cheat%20Sheet.html