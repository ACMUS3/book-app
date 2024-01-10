package com.arthur.spring6webapp.repository;

import com.arthur.spring6webapp.domain.Author;
import com.arthur.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
