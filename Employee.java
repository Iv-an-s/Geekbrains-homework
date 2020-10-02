public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public int getAge() {
        return age;
    }

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInformation(){
        System.out.println("Employee's name is " + this.name);
        System.out.println("Employee's position is " + this.position);
        System.out.println("Employee's email is " + this.email);
        System.out.println("Employee's phone number is " + this.phoneNumber);
        System.out.println("Employee's salary is " + this.salary + " dollars");
        System.out.println("Employee is " + this.age + " years old");
    }

    public Employee[] createArray(){
        Employee [] array = new Employee[5];
        array[0] = new Employee("First", "worker", "asd@gmail.com",
                "8(916)123-45-67", 1000, 20);
        array[1] = new Employee("Second", "driver", "dfg@gmail.com",
                "8(903)098-09-09", 2000, 30);
        array[2] = new Employee("Third", "doctor", "qwe@mail.ru",
                "8(123)456-78-90", 3000, 40);
        array[3] = new Employee("Fourth", "JavaDeveloper", "rty@bk.ru",
                "8(999)999-99-99", 4000, 50);
        array[4] = new Employee("Fifth", "Architect", "lkj@yandex.ru",
                "8(555)555-55-55", 5000, 60);
        return array;
    }

    public void printEmployeesOver40yearsOld(Employee[] employees){
        for (Employee employee: employees){
            if (employee.getAge()>=40){
                employee.printInformation();
            }
        }

    }
}
