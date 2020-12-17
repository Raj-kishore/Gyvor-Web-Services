package com.dynacult.restapi.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dynacult.restapi.entity.Appuser;

@Repository
public interface AppusersDAO extends PagingAndSortingRepository<Appuser, Long>, 
JpaSpecificationExecutor<Appuser> {

}
