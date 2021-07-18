import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIExamples {
    public static void main(String args[]) throws ParseException {
        List<Employee> employees = Stream.of(new Employee(101, "john", "A", 60000),
                                            new Employee(109, "peter", "B", 30000),
                                            new Employee(102, "mak", "A", 80000),
                                            new Employee(103, "kim", "A", 90000),
                                            new Employee(104, "json", "C", 15000)).collect(Collectors.toList());
        OptionalDouble averageSalary = employees.stream().filter(e-> e.getGrade().equalsIgnoreCase("A")).map(Employee::getSalary).mapToDouble(x->x).average();
        System.out.println(averageSalary);
    }
}
