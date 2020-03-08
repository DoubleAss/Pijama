package doubleAss.pijama.EntityListener;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreInsertContext;

import doubleAss.pijama.entity.Contact;

public class ContactEntityListener implements EntityListener<Contact> {

    @Override
    public void preInsert(Contact entity, PreInsertContext<Contact> context) {
        // TODO Auto-generated method stub
        EntityListener.super.preInsert(entity, context);
    }

}