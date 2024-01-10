package com.arthur.spring6webapp.service;

import com.arthur.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book>findAll();
}
