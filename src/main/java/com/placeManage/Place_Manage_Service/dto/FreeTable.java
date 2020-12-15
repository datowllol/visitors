package com.placeManage.Place_Manage_Service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public final class FreeTable {

    private UUID freeTableId;
    private UUID saloonId;

    public FreeTable(){

    }
}