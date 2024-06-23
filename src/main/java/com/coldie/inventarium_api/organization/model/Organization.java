package com.coldie.inventarium_api.organization.model;

import com.coldie.inventarium_api.branch.model.Branch;
import com.coldie.inventarium_api.user.enums.RoleType;
import com.coldie.inventarium_api.user.model.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORGANIZATIONS")
@PrimaryKeyJoinColumn(name = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Organization extends User {
    @Column(name = "organization_name")
    @NotNull(message = "organizationName cannot be null.")
    private String organizationName;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
    private List<Branch> branches = new ArrayList<>();

    public Organization(
            Long id,
            String email,
            String password,
            Date createdAt,
            Date updatedAt,
            RoleType role,
            String currency,
            String country,
            String address,
            String organizationName,
            List<Branch> branches
    ) {
        super(id, email, password, createdAt, updatedAt, role, currency, country, address);
        this.organizationName = organizationName;
        this.branches = branches == null ? new ArrayList<>() : branches;
    }

    public Organization() {
        super(null, null, null, null, null, null, null, null, null);
        this.branches = new ArrayList<>();
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + getId() +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", role=" + getRole() +
                ", currency='" + getCurrency() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", address='" + getAddress() + '\'' +
                "organizationName='" + organizationName + '\'' +
                '}';
    }
}
