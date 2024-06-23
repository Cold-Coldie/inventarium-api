package com.coldie.inventarium_api.branch.model;

import com.coldie.inventarium_api.organization.model.Organization;
import com.coldie.inventarium_api.user.enums.RoleType;
import com.coldie.inventarium_api.user.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "BRANCHES")
@PrimaryKeyJoinColumn(name = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Branch extends User {
    @Column(name = "branch_name")
    @NotNull(message = "branchName cannot be null.")
    private String branchName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "organization_id", nullable = false)
//    @JsonBackReference
    private Organization organization;

    public Branch(
            Long id,
            String email,
            String password,
            Date createdAt,
            Date updatedAt,
            RoleType role,
            String currency,
            String country,
            String address,
            String branchName,
            Organization organization
    ) {
        super(id, email, password, createdAt, updatedAt, role, currency, country, address);
        this.branchName = branchName;
        this.organization = organization;
    }

    public Branch() {
        super(null, null, null, null, null, null, null, null, null);
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + getId() +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", role=" + getRole() +
                ", currency='" + getCurrency() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", address='" + getAddress() + '\'' +
                "branchName='" + branchName + '\'' +
                "organization='" + organization + '\'' +
                '}';
    }
}
