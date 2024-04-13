package com.jcode.sawiya.repository;

import com.jcode.sawiya.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Thakshila Bandara
 * Date: Dec 27, 2023.
 * Time: 9:30:04 AM
 * Project: Sawiya | Volunteer
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {


    @Transactional
    @Query(value = "SELECT name FROM role WHERE role_id = ?1", nativeQuery = true)
    String findRoleByRoleId(Integer roleId);
}
