package ma.ensias.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.ensias.employee.entity.Employee;
 
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);
    List<Employee> findByAgeGreaterThan(int age);
    @Query("Select e from Employee e where e.age >= :min and e.name like :prefix%")
    List<Employee> findSpecificEmployees(@Param("min") int min, @Param("prefix") String prefix);   
}
