package com.asgard.consumer.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.asgard.consumer.models.ResPartner;

@Repository
public interface ResRepo extends JpaRepository<ResPartner, Long>  {

    @Query("SELECT rp FROM ResPartner rp WHERE rp.uuid = :value")
    List<ResPartner> findByuuid(@Param("value") String value);

}
