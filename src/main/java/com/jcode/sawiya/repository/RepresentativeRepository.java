package com.jcode.sawiya.repository;

import com.jcode.sawiya.model.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Thakshila Bandara
 * Date: Dec 27, 2023.
 * Time: 9:30:04 AM
 * Project: Sawiya | Volunteer
 */
@Repository
public interface RepresentativeRepository extends JpaRepository<Representative, Integer> {


}
