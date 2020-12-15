package com.placeManage.Place_Manage_Service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
public final class Saloon {
    private UUID tableId;

    private int placeNum;

    private String uniqueName;

    private UUID occupiedTableId;

    private UUID freeTableId;

    public Saloon() {

    }

    public Saloon(String uniqueName, int placeNum) {
        this.placeNum=placeNum;
        this.uniqueName=uniqueName;
    }
}
