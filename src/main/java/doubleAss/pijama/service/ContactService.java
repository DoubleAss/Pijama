package doubleAss.pijama.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import doubleAss.pijama.entity.Contact;

public interface ContactService {
    
    Page<Contact> findAll(Pageable pageable);

    List<Contact> search(String term, Pageable pageable);

    Optional<Contact> findOne(Integer id);
    
    long countBySearch(String term);
    
    long count();
    
    void save(Contact contact);

    void delete(Integer id);
    
    List<Contact> searchAllProperties(String term, Pageable pageable);
    
    int isUpdatedStatusContact(int id, int status);
}
