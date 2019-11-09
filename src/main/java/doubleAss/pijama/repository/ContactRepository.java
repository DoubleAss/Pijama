package doubleAss.pijama.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import doubleAss.pijama.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findByNameContaining(String term);

}