package com.cristianperez.revolutionstore.entity;

import com.cristianperez.revolutionstore.enums.StatusCustomerEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpi_customer")
    private Integer dpiCustomer;

    @NotBlank(message = "The username cannot be empty")
    @Size(min = 2, max = 60, message = "The name must be between 2 and 60 characters long")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "The user's last name cannot be left blank")
    @Size(min = 2, max = 60, message = "The name must be between 2 and 60 characters long")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "The user's address name cannot be left blank")
    @Size(min = 5, max = 100, message = "The address must be between 5 and 100 characters long")
    @Column(name = "address")
    private String address;

    @NotNull(message = "The customer status cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "status_customer")
    private StatusCustomerEnum statusCustomer;

    public Integer getDpiCustomer() {
        return dpiCustomer;
    }

    public void setDpiCustomer(Integer dpiCustomer) {
        this.dpiCustomer = dpiCustomer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StatusCustomerEnum getStatusCustomer() {
        return statusCustomer;
    }

    public void setStatusCustomer(StatusCustomerEnum statusCustomer) {
        this.statusCustomer = statusCustomer;
    }
}
