package doubleAss.pijama.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import doubleAss.pijama.common.sql.ContactSql;
import doubleAss.pijama.entity.Contact;
import doubleAss.pijama.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Page<Contact> findAll(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    @Override
    public List<Contact> search(String term, Pageable pageable) {
        return contactRepository.findByNameContaining(term, pageable);
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
    
    @Override
    public long count() {
        return contactRepository.count();
    }
    
    @Override
    public long countBySearch(String term) {
        String sql = ContactSql.COUNT_BY_NAME_EMAIL;
        BigInteger count = null;
        try {
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("term", "%" + term + "%");
            count = (BigInteger) query.getResultList().get(0);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return count.longValue();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Contact> searchAllProperties(String term, Pageable pageable) {
        String sql = ContactSql.SEARCH_BY_NAME_EMAIL;
        List<Contact> listContact = new ArrayList<>();
        try {
            Query query = entityManager.createNativeQuery(sql, Contact.class);
            query.setParameter("term", "%" + term + "%");
            query.setParameter("term", "%" + term + "%");
            query.setParameter("offset", pageable.getOffset());
            query.setParameter("size", pageable.getPageSize());
            listContact = (List<Contact>) query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return listContact;
    }

    @Override
    @Transactional
    public int isUpdatedStatusContact(int id, int status) {
        
        String sql = ContactSql.UPDATE_STATUS_CONTACT;
        try {
            Query query = entityManager.createNativeQuery(sql, Contact.class);
            query.setParameter("status", status);
            query.setParameter("id", id);
            return query.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
   
}