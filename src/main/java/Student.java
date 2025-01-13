public class Student {
  String name;
  Integer grade = 0;

  public Student(String name, Integer grade) {
    this.name = name;
    this.grade = grade;
  }

  public String getName() {
    return name;
  }

  public Integer getGrade() {
    return grade;
  }
}
