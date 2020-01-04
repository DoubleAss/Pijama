package doubleAss.pijama.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doubleAss.pijama.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    List<Contact> findByNameContaining(String term, Pageable pageable);
    
    long count();
}