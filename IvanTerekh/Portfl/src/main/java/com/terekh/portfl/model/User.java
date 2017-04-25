package com.terekh.portfl.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email
    private String email;

    @Min(1900)
    private int birthYear;
    
    @Min(1)
    @Max(999)
    private Integer height;
    
    @Min(1)
    @Max(999)
    private Integer weight;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserRole role;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
    
}

