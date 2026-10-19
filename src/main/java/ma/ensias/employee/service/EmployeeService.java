package ma.ensias.employee.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.ensias.employee.entity.Employee;
import ma.ensias.employee.repository.EmployeeRepo;
import ma.ensias.employee.response.EmployeeResponse;

@Service 
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    private final ModelMapper modelMapper;

    // @Autowired // constructor injection, autowired not required for single-constructor beans
    public EmployeeService(EmployeeRepo employeeRepo, ModelMapper modelMapper) {
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }

    @Transactional(readOnly = true) // not needed for a single read, but a good practice
    public EmployeeResponse getEmployeeById(int id) {
        return employeeRepo.findById(id)
            .map(this::toResponse)
            .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    private EmployeeResponse toResponse(Employee employee) {
        return modelMapper.map(employee, EmployeeResponse.class);
    }

}
