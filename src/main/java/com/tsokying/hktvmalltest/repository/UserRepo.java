package com.tsokying.hktvmalltest.repository;

import com.tsokying.hktvmalltest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    public List<User> findAllByOrderByUserIdAsc();
    public User getByUserId(Long id);
}
