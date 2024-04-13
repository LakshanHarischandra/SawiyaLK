package com.jcode.sawiya.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.jcode.sawiya.model.Privilege;

/**
 * Created by Lakshan harischandra
 * Date: 08/12/2023
 * Time: 10:40 PM
 * Project: Sawiya | Volunteer
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
	
	@Query(value = "SELECT p.* FROM sawiya.privilege AS p \n" +
            "INNER JOIN sawiya.role_has_privilege AS rp\n" +
            "ON p.privilege_id=rp.priviledge_id \n" +
            "WHERE rp.role_id= ?1", nativeQuery = true)
    List<Privilege> findPrivilegesByRoleId(int roleId);
}
