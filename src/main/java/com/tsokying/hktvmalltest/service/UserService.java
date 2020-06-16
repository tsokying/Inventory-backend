package com.tsokying.hktvmalltest.service;

import com.tsokying.hktvmalltest.model.User;
import com.tsokying.hktvmalltest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User addOrUpdateUser(User user) {
        return userRepo.save(user);
    }

    public Iterable<User> findAllUser() {
        return userRepo.findAllByOrderByUserIdAsc();
    }

    public User findUserById(Long id) {
        return userRepo.getByUserId(id);
    }

    public void deleteUser(Long id) {
        User user = userRepo.getByUserId(id);
        userRepo.delete(user);
    }
}
