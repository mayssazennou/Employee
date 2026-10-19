package ma.ensias.employee.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter 
@ToString 
@AllArgsConstructor 
@NoArgsConstructor 
public class EmployeeResponse {
    private int id;
    private String name;
    private int age;
}

// a response is immutable, Jackson only reads getters to produce JSON
// doesn't need setters or noAgrsConstructor => safer: nobody can modify it after the service creates it
// use records for immutable responses, common practice since java 16
// public record EmployeeResponse(int id, String name, int age) {}
