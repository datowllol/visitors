package com.placeManage.Place_Manage_Service.service.placeFind;

import com.placeManage.Place_Manage_Service.model.Visitors;

import java.util.List;
import java.util.UUID;

public interface InterfacePlaceFindService {
    Visitors addVisitors(Visitors visitors);

    List<Visitors> getAll();

    Visitors getById(UUID id);

    Visitors getByVisitorsNum(Integer visitorsNum);
}
