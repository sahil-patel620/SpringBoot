    package com.sahil.testing.testingApp.repositories;

    import com.sahil.testing.testingApp.TestContainerConfiguration;
    import com.sahil.testing.testingApp.entities.Employee;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
    import org.springframework.context.annotation.Import;
    import org.springframework.test.context.ActiveProfiles;

    import java.util.List;

    import static org.assertj.core.api.Assertions.assertThat;

    @Import(TestContainerConfiguration.class)
    @DataJpaTest
    //@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
    class EmployeeRepositoryTest {

        @Autowired
        private EmployeeRepository employeeRepository;

        private Employee employee;

        @BeforeEach
        void setUp(){
            employee = Employee.builder()
                    .name("sahil")
                    .email("sahil@gmail.com")
                    .salary(100000L)
                    .build();
        }

        @Test
        void testFindByEmail_whenEmailISPresent_thenReturnEmployee() {

            //Arrange, Given
            employeeRepository.save(employee);

            //Act, When
            List<Employee> employeeList = employeeRepository.findByEmail(employee.getEmail());

            //Assert, Then
            assertThat(employeeList).isNotNull();
            assertThat(employeeList).isNotEmpty();
            assertThat(employeeList.get(0).getEmail()).isEqualTo(employee.getEmail());
        }

        @Test
        void testFindByEmail_whenEmailISNotFound_thenReturnEmptyEmployeeList(){
//            Given
            String email = "notPresent.123@gmail.com";
//            When
            List<Employee> employeeList = employeeRepository.findByEmail(email);
//            Then
            assertThat(employeeList).isNotNull();
            assertThat(employeeList).isEmpty();
        }
    }