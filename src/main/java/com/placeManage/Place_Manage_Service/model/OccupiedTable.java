package com.placeManage.Place_Manage_Service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
public final class OccupiedTable {

    @Id
    private UUID occupiedTableId;


    @Column
    private UUID visitorsId;

    @Column
    private UUID saloonId;

    public OccupiedTable() {
        occupiedTableId = UUID.randomUUID();
    }
}