package com.jcode.sawiya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jcode.sawiya.model.User;



/**
 * Created by Lakshan Harischandra
 * Date: Sep 18, 2021
 * Time: 8:10:04 PM
 * Project: Sawiya | Volunteer
*/
@Repository
public interface UserRepsitory extends JpaRepository<User, Integer>{
    User findByEmail(String email);
    boolean existsByEmail(String email);
}


