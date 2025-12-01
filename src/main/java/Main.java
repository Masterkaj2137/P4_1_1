/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try {
            Service s = new Service();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Dodaj studenta");
                System.out.println("2. Wyświetl wszystkich studentów");
                System.out.println("3. Wyjście");
                System.out.print("Wybierz opcję: ");

                int option = scanner.nextInt();
                scanner.nextLine();

                if (option == 1) {
                    System.out.print("Podaj imię studenta: ");
                    String name = scanner.nextLine();

                    System.out.print("Podaj wiek studenta: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    s.addStudent(new Student(name, age));
                    System.out.println("Student dodany.");
                }
                else if (option == 2) {
                    var students = s.getStudents();
                    System.out.println("\n--- Lista studentów ---");
                    for (Student current : students) {
                        System.out.println(current.ToString());
                    }
                    System.out.println("------------------------");
                }
                else if (option == 3) {
                    System.out.println("Koniec programu.");
                    break;
                }
                else {
                    System.out.println("Nieprawidłowa opcja!");
                }
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Błąd podczas pracy z plikiem: " + e.getMessage());
        }
    }
}
