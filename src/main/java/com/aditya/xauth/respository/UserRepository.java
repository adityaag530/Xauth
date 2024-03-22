package com.aditya.xauth.respository;
/*
 * @author adityagupta
 * @date 21/03/24
 */

import com.aditya.xauth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
