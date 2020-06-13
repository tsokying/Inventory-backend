package com.tsokying.hktvmalltest.service;

import com.tsokying.hktvmalltest.model.Location;
import com.tsokying.hktvmalltest.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepo locationRepo;

    public Location addOrUpdateLocation(Location location) {
        return locationRepo.save(location);
    }

    public Iterable<Location> findAllLocation() {
        return locationRepo.findAll();
    }

    public Location findLocationById(Long id) {
        return locationRepo.getByLocationId(id);
    }

    public void deleteLocation(Long id) {
        Location location = locationRepo.getByLocationId(id);
        locationRepo.delete(location);
    }
}
