package test.weather.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import test.weather.Model.Location;
import test.weather.Repository.UserLocationRepository;

@Service
public class UserLocationService {
    
    @Autowired
    private UserLocationRepository userLocationRepository;

    public void saveUserLocation(double latitude, double longitude, String userId) {
        try {
            Location userLocation = new Location();
            userLocation.setLatitude(latitude);
            userLocation.setLongitude(longitude);
            userLocation.setId(userId); // Ensure this is compatible with the database schema
            userLocationRepository.save(userLocation);
        } catch (Exception e) {
            // Log the exception, e.g., using a logger or System.err
            System.err.println("Error saving user location: " + e.getMessage());
            // Handle the exception as appropriate for your application
        }
    }
}

