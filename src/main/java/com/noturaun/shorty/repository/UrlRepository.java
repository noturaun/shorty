package com.noturaun.shorty.repository;

import com.noturaun.shorty.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {

    @Query("FROM Url u WHERE u.shortened = ?1")
    Optional<Url> getUrlByShortened(String shortenedUrl);
}
