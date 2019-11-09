package doubleAss.pijama.service;

import java.util.List;
import java.util.Optional;

import doubleAss.pijama.entity.Contact;

public interface ContactService {
    
    Iterable<Contact> findAll();

    List<Contact> search(String term);

    Optional<Contact> findOne(Integer id);

    void save(Contact contact);

    void delete(Integer id);
}