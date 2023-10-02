package com.example.splitwise.Repos;


import com.example.splitwise.Modals.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<Users,Long> {

    @Override
    Optional<Users> findById(Long aLong);

    Users findByuserEmail(String userEmail);
//The return type of this method is Optional<User>, which means it can return either a User object if a match is found, or an empty Optional if no match is found.
//    @Override
//    Optional<Users> findByEmail(String email);

}
