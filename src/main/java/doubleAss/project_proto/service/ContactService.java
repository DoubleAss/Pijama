package doubleAss.project_proto.service;

import java.util.List;
import java.util.Optional;

import doubleAss.project_proto.entity.Contact;

public interface ContactService {
    
    Iterable<Contact> findAll();

    List<Contact> search(String term);

    Optional<Contact> findOne(Integer id);

    void save(Contact contact);

    void delete(Integer id);
}
