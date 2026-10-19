
package ma.ensias.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;

import ma.ensias.employee.repository.EmployeeRepo;
import ma.ensias.employee.service.EmployeeNotFoundException;
import ma.ensias.employee.service.EmployeeService;

@Configuration
@Profile("smoke")
public class SmokeTest {

    @Bean
    @Order(1)
    CommandLineRunner repoTest(EmployeeRepo repo) {
        return args -> {
            System.out.println("\n=== 1. findAll ===");
            repo.findAll().forEach(System.out::println);

            System.out.println("\n=== 2. findByName ===");
            repo.findByName("Leila Ramzi").forEach(System.out::println);

            System.out.println("\n=== 3. findByAgeGreaterThan ===");
            repo.findByAgeGreaterThan(25).forEach(System.out::println);

            System.out.println("\n=== 4. findSpecificEmployees ===");
            repo.findSpecificEmployees(25, "Amine").forEach(System.out::println);
        };
    }

    @Bean
    @Order(2)
    CommandLineRunner serviceTest(EmployeeService service) {
        return args -> {
            System.out.println("\n=== 5. service : id existant ===");
            System.out.println(service.getEmployeeById(1));

            System.out.println("\n=== 6. service : id inexistant ===");
            try {
                service.getEmployeeById(9999);
            } catch (EmployeeNotFoundException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
        };
    }
}