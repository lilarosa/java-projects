
public class Main {

    public static void main(String[] args) {
        Student s = new Student("Alice", 20);
        System.out.println("Name: " + s.getName());
        System.out.println("Age: " + s.getAge());
    }
}

class Student {

    private String name;
    private int age;

    // Constructor 
    public Student(String name, int age) {
        this.name = name;
        if (age > 0) {
            this.age = age;

        } else {
            System.out.println("Invalid age, set to 0");
            this.age = 0;
        }
    }
    // getter

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    //Setter
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
