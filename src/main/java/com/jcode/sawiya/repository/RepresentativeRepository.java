package com.jcode.sawiya.repository;

import com.jcode.sawiya.model.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentativeRepository extends JpaRepository<Representative, Integer> {


}
