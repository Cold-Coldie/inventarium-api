package com.coldie.inventarium_api.individual.model;

import com.coldie.inventarium_api.user.enums.RoleType;
import com.coldie.inventarium_api.user.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "INDIVIDUALS")
@PrimaryKeyJoinColumn(name = "id")
public class Individual extends User {
    @Column(name = "first_name")
    @NotNull(message = "firstName cannot be null.")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "lastName cannot be null.")
    private String lastName;



    public Individual(
            Long id,
            String email,
            String password,
            Date createdAt,
            Date updatedAt,
            RoleType role,
            String currency,
            String country,
            String address,
            String firstName,
            String lastName
    ) {
        super(id, email, password, createdAt, updatedAt, role, currency, country, address);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Individual() {
        super(null, null, null, null, null, null, null, null, null);
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

    @Override
    public String toString() {
        return "Individual{" +
                "id=" + getId() +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", role=" + getRole() +
                ", currency='" + getCurrency() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
