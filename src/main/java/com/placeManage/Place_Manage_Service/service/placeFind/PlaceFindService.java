package com.placeManage.Place_Manage_Service.service.placeFind;


import com.placeManage.Place_Manage_Service.dto.Saloon;
import com.placeManage.Place_Manage_Service.model.OccupiedTable;
import com.placeManage.Place_Manage_Service.model.Visitors;
import com.placeManage.Place_Manage_Service.repository.VisitorsRepository;
import com.placeManage.Place_Manage_Service.service.tableOccupation.TableOccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class PlaceFindService implements InterfacePlaceFindService {
    @Autowired
    private VisitorsRepository visitorsRepository;
    @Autowired
    private TableOccupationService tableOccupationService;


    public Visitors addVisitors(Visitors visitors) {

        RestTemplate restTemplate = new RestTemplate();

        Saloon Response;

        OccupiedTable tempTable = new OccupiedTable();
        visitors.setOccupiedTableID(tempTable.getOccupiedTableId());
        Response = restTemplate.postForObject("http://pub-saloon:8084/saloon/getbynum", visitors, Saloon.class);
        tempTable.setSaloonId(Response.getTableId());
        tempTable.setVisitorsId(visitors.getVisitorId());
        tableOccupationService.addTable(tempTable);
        visitors.setOccupiedTableID(tempTable.getOccupiedTableId());
        Visitors visitorsSaved = visitorsRepository.save(visitors);
        return visitorsSaved;
    }

    public List<Visitors> getAll() {
        return visitorsRepository.findAll();
    }

    public Visitors getById(UUID id) {
        return visitorsRepository.getOne(id);
    }

    public Visitors getByVisitorsNum(Integer visitorsNum) {
        return visitorsRepository.findByVisitorsNum(visitorsNum);
    }

}
