package com.placeManage.Place_Manage_Service.repository;

import com.placeManage.Place_Manage_Service.model.Visitors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VisitorsRepository extends JpaRepository<Visitors, UUID> {
    Visitors findByVisitorsNum(Integer visitorsNum);
}
