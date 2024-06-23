package com.coldie.inventarium_api.branch.controller;

import com.coldie.inventarium_api.branch.model.Branch;
import com.coldie.inventarium_api.branch.repository.BranchRepository;
import com.coldie.inventarium_api.organization.model.Organization;
import com.coldie.inventarium_api.organization.repository.OrganizationRepository;
import com.coldie.inventarium_api.user.enums.RoleType;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/branch")
public class BranchController {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @GetMapping
    public ResponseEntity<List<Branch>> getBranches() {
        return new ResponseEntity<List<Branch>>(branchRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Branch> createBranch() {
        Branch branch = new Branch();
        Organization organization = organizationRepository.findById(2L).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        branch.setEmail("erioluwa3@gmail.com");
        branch.setPassword("erioluwa@gmail");
        branch.setRole(RoleType.BRANCH);
        branch.setCurrency("USD");
        branch.setCountry("USA");
        branch.setAddress("2 Washington");
        branch.setBranchName("Erioluwa Branch.");
        branch.setOrganization(organization);

        return new ResponseEntity<Branch>(branchRepository.save(branch), HttpStatus.CREATED);
    }
}
