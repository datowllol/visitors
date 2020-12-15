package com.placeManage.Place_Manage_Service.repository;

import com.placeManage.Place_Manage_Service.model.OccupiedTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OccupiedTableRepository extends JpaRepository<OccupiedTable, UUID> {
}
