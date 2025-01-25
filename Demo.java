package HotelManagementSystem;

import java.util.Scanner;

public class Demo {

    private static final User[] users = {
            new User("Papayo", "123", "Papayo"),
            new User("Lita", "Lita456", "Lita"),
            new User("Bob", "bob789", "bob")
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String inputPassword = scanner.nextLine();

        User authenticatedUser = verifyUsername(inputUsername, inputPassword);

        if (authenticatedUser != null) {
            System.out.println("login successfully!");

            Room[] rooms = {
                    new Room(1),
                    new Room(2),
                    new Room(3),
                    new Room(4),
                    new Room(5)
            };
            HotelSystem hotelSystem = new HotelSystem(rooms);
//            HotelSystem hotelSystem = new HotelSystem();


            while (true) {
                String text = "Hotel Management System";
                int width = text.length() + 4;
                Scanner input = new Scanner(System.in);
                int choice;
                for (int i = 0; i < width; i++) {
                    System.out.print("*");
                }
                System.out.println();
                System.out.println("* " + text + " *");

                for (int i = 0; i < width; i++) {
                    System.out.print("*");
                }
                System.out.println();
                System.out.println("Enter 1: Check in");
                System.out.println("Enter 2: Check out");
                System.out.println("Enter 3: Show available rooms");
                System.out.println("Enter 4: Show all rooms");
                System.out.println("Enter 5: Remove a room");
                System.out.println("Enter 6: Add a room");
                System.out.println("Enter 7: Exit");
                System.out.print("Choose an option: ");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        hotelSystem.checkIn();
                        break;
                    case 2:
                        hotelSystem.checkOut();
                        break;
                    case 3:
                        hotelSystem.showAllAvailableRoom();
                        break;
                    case 4:
                        hotelSystem.displayAllRooms();
                        break;
                    case 5:
                        hotelSystem.removeRoom();
                        break;
                    case 6:
                        hotelSystem.addRoom();
                        break;
                    case 7:
                        System.out.println("Thank you for using our hotel management system.");
                        input.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            }

        } else {
            System.out.println("Incorrect username or password!");
        }

        scanner.close();

    }
    public static User verifyUsername(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
