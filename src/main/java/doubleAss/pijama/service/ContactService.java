package doubleAss.pijama.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import doubleAss.pijama.dao.ContactDao;
import doubleAss.pijama.entity.Contact;
import doubleAss.pijama.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactDao contactDao;

    public List<Contact> selectAll() {
        return contactDao.selectAll(this::convert);
    }

    private List<Contact> convert(Stream<Contact> result) {
        return result.map(this::modification).collect(Collectors.toList());
    }

    private Contact modification(Contact raw) {
        var mapper = new ModelMapper();
        var contact = mapper.map(raw, Contact.class);

        contact.setCreateDate(DateTimeUtil.convertToString(contact.getCreate_date()));
        contact.setUpdateDate(DateTimeUtil.convertToString(contact.getUpdate_date()));

        return contact;
    }

}
