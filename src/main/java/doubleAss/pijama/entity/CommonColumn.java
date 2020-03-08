package doubleAss.pijama.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import lombok.Data;

@Data
@Entity
public class CommonColumn {

    @Column(name = "create_date")
    private LocalDateTime create_date;

    @Column(name = "update_date")
    private LocalDateTime update_date;

}
