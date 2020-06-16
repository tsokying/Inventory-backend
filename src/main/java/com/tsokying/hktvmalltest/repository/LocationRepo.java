package com.tsokying.hktvmalltest.repository;

import com.tsokying.hktvmalltest.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {
    public List<Location> findAllByOrderByLocationIdAsc();
    Location getByLocationId(Long id);
}
