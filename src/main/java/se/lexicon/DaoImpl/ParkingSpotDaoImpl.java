package se.lexicon.DaoImpl;

import se.lexicon.dao.ParkingSpotDao;
import se.lexicon.model.ParkingSpot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingSpotDaoImpl implements ParkingSpotDao {
    public List<ParkingSpot> parkingSpots = new ArrayList<>();

    @Override
    public ParkingSpot persist(ParkingSpot parkingSpot){
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    @Override
    public Optional<ParkingSpot> findBySpotNumber(Integer spotNumber){
        return parkingSpots.stream()
                .filter(parkingSpot -> parkingSpot.getSpotNumber().equals(spotNumber))
                .findFirst();
    }

    @Override
    public List<ParkingSpot> findAll(){
        return parkingSpots;
    }

    @Override
    public List<ParkingSpot> findByAreaCode(Integer areaCode){
        List<ParkingSpot> result = new ArrayList<>();
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.getAreaCode().equals(areaCode)) {
                result.add(parkingSpot);
            }
        }
        return result;
    }

    @Override
    public void remove(Integer spotNumber){
        parkingSpots.removeIf(parkingSpot -> parkingSpot.getSpotNumber().equals(spotNumber));
    }
}
