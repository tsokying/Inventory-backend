package com.tsokying.hktvmalltest.controller;

import com.tsokying.hktvmalltest.domain.Package;
import com.tsokying.hktvmalltest.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.tsokying.hktvmalltest.controller.ErrorController.getResponseEntity;

@RestController
@RequestMapping("/api/package")
@CrossOrigin
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping("")
    public ResponseEntity<?> addPackage(@Valid @RequestBody Package package_, BindingResult result) {
        ResponseEntity<?> errorMap = getResponseEntity(result);
        if (errorMap != null) return errorMap;
        Package newPackage = packageService.addOrUpdatePackage(package_);
        return new ResponseEntity<>(newPackage, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Package> getAllProduct(){
        return packageService.findAllPackage();
    }

    @GetMapping("/{package_id}")
    public ResponseEntity<?> getById(@PathVariable Long package_id) {
        Package package_ = packageService.findPackageById(package_id);
        return new ResponseEntity<>(package_, HttpStatus.OK);
    }

    @DeleteMapping("/{package_id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long package_id) {
        packageService.deletePackage(package_id);
        return new ResponseEntity<>("Package deleted", HttpStatus.OK);
    }

}
