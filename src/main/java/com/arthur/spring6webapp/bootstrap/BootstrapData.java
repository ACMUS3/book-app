package com.arthur.spring6webapp.bootstrap;

import com.arthur.spring6webapp.domain.Author;
import com.arthur.spring6webapp.domain.Book;
import com.arthur.spring6webapp.domain.Publisher;
import com.arthur.spring6webapp.repository.AuthorRepository;
import com.arthur.spring6webapp.repository.BookRepository;
import com.arthur.spring6webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Maddy");
        rod.setLastName("Johnson");

        Book noEjB = new Book();
        noEjB.setTitle("J2EE Dev");
        noEjB.setIsbn("489415");

        Author rodSaved = authorRepository.save(rod);
        Book noEjBSaved = bookRepository.save(noEjB);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEjBSaved);

        dddSaved.getAuthors().add(ericSaved);
        noEjBSaved.getAuthors().add(rodSaved);


        Publisher publisher = new Publisher();
        publisher.setName("My Publisher");
        publisher.setAddressLine1("123 Main");

        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        noEjBSaved.setPublisher(savedPublisher);

        bookRepository.save(dddSaved);
        bookRepository.save(noEjBSaved);

        authorRepository.save(rodSaved);
        authorRepository.save(ericSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + authorRepository.count());
        System.out.println("Book Count: " + publisherRepository.count());

    }
}
