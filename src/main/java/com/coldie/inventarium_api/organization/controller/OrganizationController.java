package com.coldie.inventarium_api.organization.controller;

import com.coldie.inventarium_api.individual.model.Individual;
import com.coldie.inventarium_api.organization.model.Organization;
import com.coldie.inventarium_api.organization.repository.OrganizationRepository;
import com.coldie.inventarium_api.user.enums.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/organization")
public class OrganizationController {

    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping("")
    public ResponseEntity<List<Organization>> getOrganizations() {
        return new ResponseEntity<List<Organization>>(organizationRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Organization> createOrganization() {
        Organization organization = new Organization();

        organization.setEmail("erioluwa2@gmail.com");
        organization.setPassword("erioluwa@gmail");
        organization.setRole(RoleType.ORGANIZATION);
        organization.setCurrency("USD");
        organization.setCountry("USA");
        organization.setAddress("2 Washington");
        organization.setOrganizationName("Erioluwa Org.");

        return new ResponseEntity<Organization>(organizationRepository.save(organization), HttpStatus.CREATED);
    }
}
