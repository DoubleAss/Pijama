package doubleAss.pijama.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import doubleAss.pijama.common.util.DatetimeUtil;
import doubleAss.pijama.entity.Contact;

@Aspect
@Component
public class SystemDateServiceAspect {

    @Before(value = "execution(* doubleAss.pijama.service.ContactServiceImpl.save*(..)) and args(contact)")
    public void beforeAdvice(JoinPoint joinPoint, Contact contact) {

        // Check add new contact
        if (contact.getId() == null) {
            contact.setCreateDate(DatetimeUtil.getSystemDateTimeSave());
        } else {
            contact.setUpdateDate(DatetimeUtil.getSystemDateTimeSave());
        }

    }
    
}
