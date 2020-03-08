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
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "contact")
public class Contact extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "content")
    private String content;

    @Column(name = "file")
    private String file;

    @Column(name = "status")
    private Integer status;
    
    private String createDate;
    
    private String updateDate;

}