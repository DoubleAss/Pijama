package doubleAss.pijama.common.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class CreateUpdateDate {
    
    @Column(name="create_date")
    String createDate;
    
    @Column(name="update_date")
    String updateDate;
}
