package com.placeManage.Place_Manage_Service.service.placeFree;


import com.placeManage.Place_Manage_Service.dto.FreeTable;
import com.placeManage.Place_Manage_Service.model.Visitors;
import com.placeManage.Place_Manage_Service.repository.VisitorsRepository;
import com.placeManage.Place_Manage_Service.service.placeFind.PlaceFindService;
import com.placeManage.Place_Manage_Service.service.tableOccupation.TableOccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class PlaceFreeService implements InterfacePlaceFreeService {
    @Autowired
    private VisitorsRepository visitorsRepository;
    @Autowired
    private PlaceFindService placeFindService;
    @Autowired
    private TableOccupationService tableOccupationService;



    public Visitors visitorsLeavePub(UUID id) {


        FreeTable table = new FreeTable();
        table.setSaloonId(tableOccupationService.getById(placeFindService.getById(id).getOccupiedTableID()).getSaloonId());
        RestTemplate restTemplate = new RestTemplate();
        FreeTable Response;
        Response = restTemplate.postForObject("http://pub-saloon:8084/saloon/setfree", table, FreeTable.class);
        tableOccupationService.deleteById(placeFindService.getById(id).getOccupiedTableID());
        return placeFindService.getById(id);
    }
}
