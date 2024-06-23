package com.coldie.inventarium_api.branch.repository;

import com.coldie.inventarium_api.branch.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
}
