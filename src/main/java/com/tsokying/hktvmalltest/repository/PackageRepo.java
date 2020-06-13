package com.tsokying.hktvmalltest.repository;

import com.tsokying.hktvmalltest.model.Package;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageRepo extends CrudRepository<Package, Long> {
    Package getByPackageId(Long id);
}
