package com.example.AuthWithBcrypt.repository;

import com.example.AuthWithBcrypt.models.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteUserRepository extends JpaRepository<SiteUser , Long> {
    SiteUser findByUsername(String username);
    SiteUser findByPassword(String username);

}
