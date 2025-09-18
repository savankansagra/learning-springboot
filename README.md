# Spring Boot Dependency Injection Demo

## How to Run
```bash
mvn spring-boot:run
```

## Test the APIs
```bash
# Get all students
curl http://localhost:8080/api/students

# Add a student
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{"name":"John Doe","department":"Computer Science","cgpa":8.5}'
```

## Dependency Injection Demo Points
1. **@Autowired** - Spring automatically injects dependencies
2. **@Service** - Business logic layer
3. **@Repository** - Data access layer  
4. **@RestController** - Web layer
5. **No manual object creation** - Spring manages everything!