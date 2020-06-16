package com.tsokying.hktvmalltest.repository;

import com.tsokying.hktvmalltest.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PackageRepo extends JpaRepository<Package, Long> {
    public List<Package> findAllByOrderByPackageIdAsc();
    Package getByPackageId(Long id);
}
