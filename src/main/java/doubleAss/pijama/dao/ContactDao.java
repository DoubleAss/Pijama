package doubleAss.pijama.dao;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.SelectType;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.transaction.annotation.Transactional;

import doubleAss.pijama.entity.Contact;

@Dao
@ConfigAutowireable
public interface ContactDao {
    
    @Select(strategy = SelectType.STREAM)
    List<Contact> selectAll(Function<Stream<Contact>, List<Contact>> result);

    @Insert(sqlFile = false)
    @Transactional
    int insert(Contact Contact);

}
