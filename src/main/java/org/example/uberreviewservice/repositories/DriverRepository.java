package org.example.uberreviewservice.repositories;

import org.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Driver findByIdAndLicenceNumber(Long id,String licenceNumber);
//
//    @Query(nativeQuery = true,value = "SELECT * from Driver where id = :id and  licence_number = :licenceNumber")   //  Raw query ,error is thrown at runtime in query
//    Driver rawFindByIdAndLicenceNumber(Long id,String licenceNumber);
//
//    @Query("SELECT d from Driver d where d.id = :id and  d.licenceNumber = :licenceNumber")    // Hibernate query, error is thrown at compile time
//    Driver hqlFindByIdAndLicenceNumber(Long id,String licenceNumber);

    List<Driver> findAllByIdIn(List<Long> ids);

}
