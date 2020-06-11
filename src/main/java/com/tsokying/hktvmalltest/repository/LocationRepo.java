package com.tsokying.hktvmalltest.repository;

import com.tsokying.hktvmalltest.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends CrudRepository<Location, Long> {
    Location getByLocationId(Long id);
}
