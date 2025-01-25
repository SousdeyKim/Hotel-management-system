package HotelManagementSystem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class HotelSystem {
//    private Room[] rooms;
private List<Room> rooms;

    String hotelName = "Happiness Hotel";

//    public HotelSystem(Room[] rooms) {
//        this.rooms = rooms;
//    }

    public HotelSystem(Room[] roomsArray) {
        this.rooms = new ArrayList<>();
        for (Room room : roomsArray) {
            this.rooms.add(room);
        }
    }
//public HotelSystem() {
//    this.rooms = new ArrayList<>();
//}

    Scanner scanner = new Scanner(System.in);
    public void checkIn() {
        System.out.print("Enter room number: ");
        int roomNum = scanner.nextInt();
        Room room = findRoom(roomNum);
        if(room!=null) {
            if(room.isTaken()) {
                System.out.print("Room is already taken.");
            }
            else {
                room.setTaken(true);
                System.out.print("Enter guest name: ");
                String guestName = scanner.next();
                room.setGuestName(guestName);
                System.out.println("\n==============================================");
                System.out.println("|               CHECK-IN SUCCESS              |");
                System.out.println("==============================================");
                System.out.println("| Room Number : " + room.getRoomNumber());
                System.out.println("| Guest Name  : " + room.getGuestName());
                System.out.println("| Status      : Checked in successfully       |");
                System.out.println("==============================================");
                System.out.println("|         Welcome to our " + hotelName + "!          |");
                System.out.println("==============================================\n");
            }
        }

    }

    public void checkOut(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter room number: ");
        int checkOutRoom = scanner.nextInt();
        Room room = findRoom(checkOutRoom);
        if(room!=null) {
            if(!room.isTaken()) {
                System.out.println("Room is not taken.");
            }
            else {
                room.setTaken(false);
                System.out.println(" ");
                System.out.println("========================================");
                System.out.println("|          CHECK-OUT CONFIRMATION      |");
                System.out.println("========================================");
                System.out.println("| Room Number : " + room.getRoomNumber());
                System.out.println("| Guest Name  : " + room.getGuestName());
                System.out.println("| Status      : Checked out successfully");
                System.out.println("========================================");
                System.out.println(" ");
                room.setGuestName("");

            }
        }
    }

    public void displayAllRooms() {
        System.out.println("==============================================");
        System.out.println("|              All Rooms               |");
        System.out.println("==============================================");
        System.out.printf("| %-10s | %-10s | %-10s |\n", "Room Number", "Status", "Guest Name");
        System.out.println("==============================================");
        for(Room room : rooms) {
            if(room.isTaken()) {
                System.out.printf("| %-10d | %-10s | %-10s |\n", room.getRoomNumber(), "Taken", room.getGuestName());
            }
            else {
                System.out.printf("| %-10d | %-10s | %-10s |\n", room.getRoomNumber(), "Vacant", "");
            }
        }
        System.out.println("==============================================");
    }

    public void showAllAvailableRoom() {
        System.out.println("==============================================");
        System.out.println("|             AVAILABLE ROOMS               |");
        System.out.println("==============================================");
        System.out.printf("| %-10s | %-10s |\n", "Room Number", "Status");
        System.out.println("==============================================");

        boolean hasAvailableRooms = false;
        for (Room room : rooms) {
            if (!room.isTaken()) {
                System.out.printf("| %-10d | %-10s |\n", room.getRoomNumber(), "Vacant");
                hasAvailableRooms = true;
            }
        }

        if (!hasAvailableRooms) {
            System.out.println("| No available rooms at the moment          |");
        }

        System.out.println("==============================================\n");
    }
    public void removeRoom() {
        System.out.print("Enter room number to remove: ");
        int roomNum = scanner.nextInt();
        Room room = findRoom(roomNum);

        if (room != null) {
            rooms.remove(room);
            System.out.println("Room number " + roomNum + " has been successfully removed.");
        } else {
            System.out.println("Room number " + roomNum + " does not exist.");
        }
    }

    public void addRoom() {
        System.out.print("Enter new room number to add: ");
        int roomNum = scanner.nextInt();
        Room existingRoom = findRoom(roomNum);

        if (existingRoom == null) {
            Room newRoom = new Room(roomNum);
            rooms.add(newRoom);
            System.out.println("Room number " + roomNum + " has been successfully added.");
        } else {
            System.out.println("Room number " + roomNum + " already exists.");
        }
    }


    private Room findRoom(int roomNumber) {
        for(Room room : rooms) {
            if(roomNumber==room.getRoomNumber()) {
                return room;
            }
        }
        return null;
    }

}
