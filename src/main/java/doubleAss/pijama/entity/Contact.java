package doubleAss.pijama.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import doubleAss.pijama.common.entity.SystemDate;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "contact")
@Data
@EqualsAndHashCode(callSuper=false)
public class Contact extends SystemDate{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;
    
    @Column(name = "status")
    private int status;

    @Column(name = "content")
    private String content;

}