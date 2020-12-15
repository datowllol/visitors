package com.placeManage.Place_Manage_Service.service.tableOccupation;


import com.placeManage.Place_Manage_Service.model.OccupiedTable;

import java.util.List;
import java.util.UUID;

public interface InterfaceTableOccupationService {
    OccupiedTable addTable(OccupiedTable table);
    List<OccupiedTable> getAll();
    OccupiedTable getById(UUID id);
    void deleteById(UUID id);
}
