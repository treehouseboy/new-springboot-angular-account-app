package com.qa.account.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface AccountRepository extends JpaRepository<Account, Long> {
}