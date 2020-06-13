package com.tsokying.hktvmalltest.service;

import com.tsokying.hktvmalltest.model.Package;
import com.tsokying.hktvmalltest.repository.PackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    @Autowired
    private PackageRepo packageRepo;

    public Package addOrUpdatePackage(Package package_) {
        return packageRepo.save(package_);
    }

    public Iterable<Package> findAllPackage() {
        return packageRepo.findAll();
    }

    public Package findPackageById(Long id) {
        return packageRepo.getByPackageId(id);
    }

    public void deletePackage(Long id) {
        Package package_ = packageRepo.getByPackageId(id);
        packageRepo.delete(package_);
    }
}
