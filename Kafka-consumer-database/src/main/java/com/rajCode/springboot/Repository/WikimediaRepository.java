package com.rajCode.springboot.Repository;

import com.rajCode.springboot.Entity.WikimediaChanges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaChanges,Long> {
}
