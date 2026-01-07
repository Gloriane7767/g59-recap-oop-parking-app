package se.lexicon.DaoImpl;

import se.lexicon.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PackingSpotDaoImpl {
    public List<ParkingSpot> packingSpots = new ArrayList<>();
    ParkingSpot persist(ParkingSpot parkingSpot){
        packingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public Optional<ParkingSpot> findBySpotNumber(Integer spotNumber){
        return packingSpots.stream()
                .filter(parkingSpot -> parkingSpot.getSpotNumber().equals(spotNumber))
                .findFirst();
    }

    public List<ParkingSpot> findAll(){
        return packingSpots;
    }

    public List<ParkingSpot> findByAreaCode(Integer areaCode){
        List<ParkingSpot> result = new ArrayList<>();
        for (ParkingSpot parkingSpot : packingSpots) {
            if (parkingSpot.getAreaCode().equals(areaCode)) {
                result.add(parkingSpot);
            }
        }
        return result;
    }
    public void remove(Integer spotNumber){
        packingSpots.removeIf(parkingSpot -> parkingSpot.getSpotNumber().equals(spotNumber));
    }
}
