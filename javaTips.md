# Java ☕️
## ❓IoC container 
- `@Configuration`
- `@Bean`

Model-Controller-Service-Repo
```
class StudentController
|
— StudentService

class StudentService
|
— interface StudentRepository extends jpa 
```

Optional
```
isPresent(): bool
get(): <objType>
```

Repository:
```
findAll()
save()  
```

`StudentRepository.findStudentByEmail` is a member of type `Optional<Student>`

## Utils
- Deletion in a loop: `lst.removeIf( l -> l.equals(“a”));`
- Use Generics for List: `List<Integer> l = new List<>();`
- String comparison: `str1.equals(str2);`
- `record`: a special type of class declaration aimed at reducing the boilerplate code. No need to write constructors, get, set, etc., e.g. 
    ```
    public record Employee(int id, String firstName, String lastName) {}
    ```
