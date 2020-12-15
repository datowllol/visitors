package com.placeManage.Place_Manage_Service.service.placeFree;



import com.placeManage.Place_Manage_Service.model.Visitors;

import java.util.UUID;

public interface InterfacePlaceFreeService {
    Visitors visitorsLeavePub(UUID id);
}
