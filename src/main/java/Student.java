public class Student {

    private String Name;
    private String Surname;
    private int Age;
    private String Field;

    public Student(String name, String surname, int age, String field) {
      Name = name;
      Surname = surname;
      Age = age;
      Field = field;
    }

    public String GetName() { return Name; }
    public String GetSurname() { return Surname; }
    public int GetAge() { return Age; }
    public String GetField() { return Field; }

    public String ToString() {
      return Name + " " + Surname + " " + Age + " " + Field;
    }

    public static Student Parse(String str) {
      String[] data = str.split(" ");

      if(data.length < 4)
        return new Student("ParseError", "", -1, "");

      String name = data[0];
      String surname = data[1];
      int age = Integer.parseInt(data[2]);

      StringBuilder field = new StringBuilder();
      for(int i = 3; i < data.length; i++) {
        field.append(data[i]);
        if(i < data.length - 1) field.append(" ");
      }

      return new Student(name, surname, age, field.toString());
    }
  }

}