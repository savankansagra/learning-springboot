# Spring Boot DI + MVC Demo

## How to Run
```bash
mvn spring-boot:run
```

## REST API Endpoints (JSON)
```bash
# Get all students
curl http://localhost:8080/api/students

# Add a student
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","department":"Computer Science","cgpa":8.5}'
```

## MVC Endpoints (HTML Pages)
- **GET** http://localhost:8080/mvc/students - View all students
- **GET** http://localhost:8080/mvc/students/add - Add student form

## Demo Points

### Dependency Injection
1. **@Autowired** - Spring automatically injects dependencies
2. **@Service** - Business logic layer
3. **@Repository** - Data access layer  
4. **@RestController** - REST API layer
5. **@Controller** - MVC web layer

### MVC Pattern
1. **Model** - Student entity and data
2. **View** - HTML templates (Thymeleaf)
3. **Controller** - Handles requests and returns ModelAndView
4. **ModelAndView** - Combines Model + View in single object
5. **Same Service Layer** - Used by both REST and MVC controllers!