package HotelManagementSystem;

public class Room {
   private int roomNumber;
    private boolean isTaken;
    private String guestName;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isTaken = false;
        this.guestName = "";
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
}
