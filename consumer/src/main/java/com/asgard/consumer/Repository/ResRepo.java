package com.asgard.consumer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.models.ResPartner;

@Repository
public interface ResRepo extends JpaRepository<ResPartner, Long>  {

}
