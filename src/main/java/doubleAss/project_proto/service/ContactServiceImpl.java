package doubleAss.project_proto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doubleAss.project_proto.entity.Contact;
import doubleAss.project_proto.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public List<Contact> search(String term) {
        return contactRepository.findByNameContaining(term);
    }

    @Override
    public Optional<Contact> findOne(Integer id) {
        return contactRepository.findById(id);
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }

   
}