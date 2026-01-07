package se.lexicon.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class Reservation {

    private String reservationId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status status;
    private Customer customer;
    private ParkingSpot parkingSpot;

    public Reservation(ParkingSpot parkingSpot, Customer customer, int hours) {

    }

    private void setDurationInHours(int hours) {
    }


    /*
    VWhy is this.parkingSpot.occupy(); inside the constructor?
To understand this, imagine a real-world parking lot.
1. The Action vs. The Paperwork
In the code, the Reservation object is the "Paperwork" (the ticket). The ParkingSpot object is the "Physical Space" (the actual ground where the car sits).
When you create a new reservation (the ticket), you aren't just printing paper—you are also physically taking up a spot in the lot. If the code only created the ticket but didn't tell the spot it was taken, someone else might try to park in that same spot 2 seconds later because the system still thinks it's empty!
2. Automatic Updates
By putting this.parkingSpot.occupy(); inside the constructor, we make the system automatic and safe:
•
Automation: As soon as you say "New Reservation," the computer immediately flips the switch on that parking spot to "Occupied." You don't have to remember to do it in a separate step.
•
Consistency: It ensures that a reservation and an occupied spot always go together. You can't have a reservation for an "empty" spot, and you shouldn't have an "occupied" spot without a reservation.
3. How it works (The "Switch")
If you look at the ParkingSpot.java file, you will see:
public void occupy() {
    this.occupied = true;
}
When the Reservation constructor calls occupy(), it is reaching over to the ParkingSpot and flipping its occupied status from false (Available) to true (Taken).
In simple terms: We put it there so that the moment the "Parking Ticket" is created, the "Spot" is officially locked so no one else can take it.
     */
// These are like little windows that let you look at the information on the ticket (Id, Start Time, etc.) without changing it.
    public String getReservationId() {
        return reservationId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Status getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    // When the customer leaves, we call this. It changes the status to COMPLETED and tells the parking spot it is now free (vacate).
    public void complete(){
        this.status = Status.COMPLETED;
        this.parkingSpot.vacate();
    }


    public void serDurationInHours(int hours){
        if (hours <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        this.endTime = startTime.plusHours(hours);
    }

    @Override
    public String toString() {
        return """
                Reservation Details:
                ----------------------
                Reservation ID: %s
                Start Time    : %s
                End Time      : %s
                Parking Spot  : %s
                Customer      : %s
                ---------------------
                """.formatted(reservationId, startTime, endTime, parkingSpot, customer);
    }
}
/*
In Java (and programming in general), we usually only put things in the constructor that the user/programmer needs to provide manually.
Here is why those 4 were left out:
1.
Reservation ID: We want the computer to generate this automatically to ensure it's unique. If we let humans type it in, they might accidentally use the same ID twice.
2.
Start Time: A reservation usually starts the exact moment you create it. By using LocalDateTime.now(), the computer ensures the time is 100% accurate.
3.
End Time: This is calculated data. Since we already have the startTime and the hours, the computer can do the math itself. We don't want to ask the user "What time is it 3 hours from now?"—the computer is better at that!
4.
Status: When you first create a reservation, it is always active. It wouldn't make sense to create a "Finished" reservation from the start, so we set it to ACTIVE automatically to save the user from typing it every time.
Summary: We leave them out of the constructor to make the code smarter and easier to use. The user only provides the "raw" ingredients (Who, Where, How long), and the constructor handles the "paperwork" (ID, Time stamps, Status).
 */