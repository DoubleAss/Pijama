package doubleAss.pijama.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    private Integer status;
    
    @NotEmpty
    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
    
    

}