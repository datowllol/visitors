package com.placeManage.Place_Manage_Service.model;

import com.placeManage.Place_Manage_Service.VisitorsRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public final class Visitors {

    @Id
    private UUID visitorId;

    @Column
    private int visitorsNum;
    private UUID occupiedTableID;



    public Visitors(int visitorsNum) {
        visitorId = UUID.randomUUID();
        this.visitorsNum = visitorsNum;
    }


    public VisitorsRequest toVisitorsResponse() {
        return VisitorsRequest.newBuilder().
                setVisitorId(visitorId.toString()).
                setVisitorsNum(visitorsNum).
                setOccupiedTableID(occupiedTableID.toString()).
                build();
    }

    public static Visitors fromVisitorsRequest(VisitorsRequest visitorsResponse) {
        return new Visitors( UUID.fromString(visitorsResponse.getVisitorId()),
                visitorsResponse.getVisitorsNum(),
                UUID.fromString(visitorsResponse.getOccupiedTableID()));

    }
}