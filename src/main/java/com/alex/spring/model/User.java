package com.alex.spring.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by alex on 2/25/2015.
 */

@Data
@EqualsAndHashCode(exclude = {"id","companyDomain"})
@Entity
@Table(name = "KPI")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "COMPANY_DOMAIN")
    private String companyDomain;

}
