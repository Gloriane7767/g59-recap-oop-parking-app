package se.lexicon.model;

public class ParkingSpot {

    private Integer id;
    private Integer areaCode;
    private Integer spotNumber;
    private boolean occupied;

    public ParkingSpot(Integer id, Integer areaCode, Integer spotNumber) {
        this.id = id;
        this.areaCode = areaCode;
        this.spotNumber = spotNumber;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public Integer getSpotNumber() {
        return spotNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }


    /**
     * Marks the parking spot as occupied
     */
    public void occupy() {
        this.occupied = true;
    }

    /**
     * Marks the parking spot as available
     */
    public void vacate() {
        this.occupied = false;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", areaCode=" + areaCode +
                ", spotNumber=" + spotNumber +
                ", occupied=" + occupied +
                '}';
    }

}
