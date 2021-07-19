import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
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
//        System.out.println(averageSalary);

        // only increment id's of Employee using stream
        employees.stream().forEach(e-> e.setId(e.getId() + 1));
//        System.out.println(employees.get(0).getId() + "name " + employees.get(0).getName());

       String commaSeperatedNames = employees.stream().map(e-> e.getId() + "," + e.getName()).collect(Collectors.joining(";"));
//       System.out.println(commaSeperatedNames);

        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
//        System.out.println(employeeMap);

        OptionalDouble averageSalary2 = employeeMap.entrySet().stream().filter(e-> e.getValue().getGrade().equalsIgnoreCase("A")).map(e-> e.getValue().getSalary()).mapToDouble(x->x).average();
//        System.out.println(averageSalary2);

        String commaSeperatedObject = employeeMap.entrySet().stream().map(e-> e.getValue().getId() + "," + e.getValue().getName()).collect(Collectors.joining(";"));
//        System.out.println(commaSeperatedObject);

        employeeMap.entrySet().stream().forEach(e-> e.getValue().setId(e.getValue().getId() + 1));
//        System.out.println(employeeMap);
    }
}
