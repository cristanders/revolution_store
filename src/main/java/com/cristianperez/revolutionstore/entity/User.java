package com.cristianperez.revolutionstore.entity;

import com.cristianperez.revolutionstore.enums.UserRoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_user")
    private Integer codeUser;

    @NotBlank(message = "The username cannot be empty")
    @Size(min = 2, max = 45, message = "The username must be between 2 and 45 characters long")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "The password cannot be empty")
    @Size(min = 2, max = 45, message = "The password must be between 2 and 45 characters long")
    @Column(name = "passwords")
    private String password;

    @NotBlank(message = "The email cannot be empty")
    @Size(min = 5, max = 67, message = "The email must be between 5 and 67 characters long")
    @Column(name = "email")
    private String email;

    @NotNull(message = "The user role cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRoleEnum userRole;

    public Integer getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(Integer codeUser) {
        this.codeUser = codeUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
    }
}
