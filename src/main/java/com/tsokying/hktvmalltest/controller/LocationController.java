package com.tsokying.hktvmalltest.controller;

import com.tsokying.hktvmalltest.model.Location;
import com.tsokying.hktvmalltest.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

import static com.tsokying.hktvmalltest.controller.ErrorController.getResponseEntity;

@RestController
@RequestMapping("/api/location")
@CrossOrigin
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("")
    public ResponseEntity<?> addLocation(@Valid @RequestBody Location location, BindingResult result) {
        ResponseEntity<?> errorMap = getResponseEntity(result);
        if (errorMap != null) return errorMap;
        Location newLocation = locationService.addOrUpdateLocation(location);
        return new ResponseEntity<>(newLocation, HttpStatus.CREATED);
    }

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public void uploadProductData(@RequestParam("file") MultipartFile file) throws IOException {
        locationService.saveAll(CsvUtils.read(Location.class, file.getInputStream()));
    }

    @GetMapping("/all")
    public Iterable<Location> getAllLocation(){
        return locationService.findAllLocation();
    }

    @GetMapping("/{location_id}")
    public ResponseEntity<?> getById(@PathVariable Long location_id) {
        Location location = locationService.findLocationById(location_id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

    @DeleteMapping("/{location_id}")
    public ResponseEntity<?> deleteLocation(@PathVariable Long location_id) {
        locationService.deleteLocation(location_id);
        return new ResponseEntity<>("Location deleted", HttpStatus.OK);
    }

}
