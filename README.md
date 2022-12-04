# Spring boot Essentials

- Spring Boot 3 support Generating native Images with GraalVM, which replaces the experimental Spring Native Project

## GraalVM

- __High Performance__: Apply Graal, an advanced Optimizing Compiler, that generates faster and leaner Code requiring
  fewer Compute Resources
- __AOT (ahead-of-time) Native Image Compilation__: Compile Java Applications ahead-of-time to native Binaries that
  start up instantly and deliver peak Performance with no Warmup Time
- __Polyglot Programming__: Leverage the best Features and Libraries of popular Languages in a single App with no
  Overhead
- __Advanced Tools__: Debug, monitor, profile, and optimize Resources Consumption in Java and across multiple Languages

## Dependencies

- __Jackson XMl__ transforms Java Objects into JSON Objects

## Spring Annotations

### SpringBootApplication

- `@SpringBootApplication` combines the `@Configuration`, `@EnableAutoConfiguration` and `@ComponentScan` Annotations
  with their default Attributes
- It is added just once to the Main Class of an Application

### EnableAutoConfiguration

- `@EnableAutoConfiguration` makes Spring use the Configuration based on the JAR files available in the Classpath
- It can figure out what Libraries are used and pre-configure their Components

### Configuration

- `@Configuration` setups Configuration Classes that are used to create Beans
- It allows Beans to depend on each other

### ComponentScan

- `@ComponentScan` is responsible for letting Spring know where to look for Components
- By Default, Spring will search within the Package that the Main Class is located, along with all of its Child Packages

### Bean

- `@Bean` annotates a Class as a Bean
- A Bean lets the Inversion-of-Control / Dependency Injection System inside Spring treat the annotated Class as a
  Component within the System
- It allows the Component to be injected as a Dependency or receive Dependency injects into it

### Component

- `@Component` lets Spring know that the annotated Class is a Component and should be managed by the Spring Container
- In Addition to the `@Component` Annotation, also the `@Repository`, `@Service` and `@Controller` Annotations can be
  used
- Each of these Annotations has a specific Purpose and Spring will manage the components accordingly

### Autowired

- `@Autowired` is used for automatic Injection of Beans
- `@Qualifier` is used in Conjunction with `@Autowired` to avoid Confusion when two or more Beans are configured the
  same

### Controller

- `@Controller` marks the Class as a Web controller
- It allows Spring to auto-detect Implementation Classes / beans by scanning the Classpath

### RestController

- `@RestController` combines the `@Controller` and `@ResponseBody` Annotations
- It indicates that the Class is a Web Controller, and that all their Methods will return a JSON Response

### ResponseBody

- `@ResponseBody` lets Spring know to automatically serialize Return Values of the Methods into HTTP Responses

### RequestMapping

- `@RequestMapping` specifies a Method in the Web Controller that should be responsible for serving the HTTP Request to
  the given Path or Endpoint

### GetMapping

- `@GetMapping` is an abbreviated Form of `@RequestMapping` specifically for HTTP GET Requests

### PostMapping

- `@PostMapping` is an abbreviated Form of `@RequestMapping` specifically for HTTP POST Requests
