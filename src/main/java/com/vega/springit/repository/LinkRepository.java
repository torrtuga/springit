package com.vega.springit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vega.springit.domain.Link;

import java.util.List;

public interface LinkRepository extends JpaRepository<Link, Long> {

    Link findByTitle(String title);

    List<Link> findAllByTitleLikeOrderByCreationDateDesc(String title);
}
