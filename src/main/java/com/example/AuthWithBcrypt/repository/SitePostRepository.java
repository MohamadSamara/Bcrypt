package com.example.AuthWithBcrypt.repository;

import com.example.AuthWithBcrypt.models.SitePost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SitePostRepository extends JpaRepository<SitePost , Long> {

}
