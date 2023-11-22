package com.project.the.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.the.library.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
