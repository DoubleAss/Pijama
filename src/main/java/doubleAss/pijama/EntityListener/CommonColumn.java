package doubleAss.pijama.EntityListener;

import java.time.LocalDateTime;

import org.seasar.doma.Column;

public class CommonColumn {

    @Column(name = "create_date")
    private LocalDateTime create_date;

    @Column(name = "update_date")
    private LocalDateTime update_date;

}
