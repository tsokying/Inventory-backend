package com.tsokying.hktvmalltest.repository;

import com.tsokying.hktvmalltest.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User getByUserId(Long id);
}
