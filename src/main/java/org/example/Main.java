package org.example;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PersonDAO personDAO = new PersonDAO();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPerson();
                case 2 -> showAllPeople();
                case 3 -> deletePerson();
                case 4 -> updatePerson();
                case 5 -> getById();
                case 6 -> {
                    HibernateUtil.shutdown();
                    System.exit(0);
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n1. Add person");
        System.out.println("2. Show all people");
        System.out.println("3. Delete person");
        System.out.println("4. Update person");
        System.out.println("5. Get Person by Id");
        System.out.println("6. Exit");
        System.out.print("Choose option: ");
    }

    private static void addPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();


        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        person.setEmail(email);

        personDAO.addPerson(person);
        System.out.println("Person added!");
    }

    private static void deletePerson(){
        System.out.print("Enter id: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        person.setEmail(email);

        personDAO.deletePerson(person);
        System.out.println("Person deleted!");
    }

    private static void updatePerson(){
        System.out.print("Enter id: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        person.setEmail(email);

        personDAO.updatePerson(person);
        System.out.println("Person update!");
    }

    private static void getById(){
        System.out.print("Enter id: ");
        Long id = scanner.nextLong();

        Person p = personDAO.getById(id);
        System.out.printf("ID: %d | Name: %s | Age: %d%n | Email: %s",
                p.getId(), p.getName(), p.getAge(), p.getEmail());
    }


    private static void showAllPeople() {
        personDAO.getAllPeople().forEach(p ->
                System.out.printf("ID: %d | Name: %s | Age: %d%n | Email: %s\n",
                        p.getId(), p.getName(), p.getAge(), p.getEmail()));
    }
}