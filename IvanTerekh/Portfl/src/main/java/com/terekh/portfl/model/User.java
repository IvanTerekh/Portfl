package com.terekh.portfl.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email
    private String email;

    @Min(1900)
    private Integer birthYear;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Photo> photoes;
    
    public User(String name, String password, String email) {
        this.username = name;
        this.password = password;
        this.email = email;
        this.birthYear = 1900;
        this.height = 1;
        this.weight = 1;
        this.gender = Gender.GENDER_CISGENDER_MALE;
        this.role = UserRole.ROLE_USER;
    }
    
}

