package doubleAss.pijama.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import doubleAss.pijama.entity.Contact;

@Dao
@ConfigAutowireable
public interface ContactDao {
    
    @Select
    List<Contact> selectAll();

    @Insert
    @Transactional
    int insert(Contact Contact);

}
