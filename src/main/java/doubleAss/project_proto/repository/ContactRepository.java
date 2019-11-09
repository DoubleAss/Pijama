package doubleAss.project_proto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import doubleAss.project_proto.entity.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    List<Contact> findByNameContaining(String term);

}