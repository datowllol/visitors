package com.placeManage.Place_Manage_Service.api;

import com.placeManage.Place_Manage_Service.*;
import com.placeManage.Place_Manage_Service.model.Visitors;
import com.placeManage.Place_Manage_Service.service.placeFind.PlaceFindService;
import com.placeManage.Place_Manage_Service.service.placeFree.PlaceFreeService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@GRpcService
public class PlaceManageGrpcController extends PlaceManageServiceGrpc.PlaceManageServiceImplBase {
    @Autowired
    PlaceFreeService placeFreeService;

    @Autowired
    PlaceFindService placeFindService;

    @Override
    public void all(AllVisitorsRequest request, StreamObserver<AllVisitorsResponse> responseObserver) {
        List<Visitors> visitors = placeFindService.getAll();
        List<VisitorsRequest> convertedVisitors = visitors.stream().
                map(Visitors::toVisitorsResponse).
                collect(Collectors.toList());
        AllVisitorsResponse response = AllVisitorsResponse.newBuilder().
                addAllVisitors(convertedVisitors).
                build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void add(VisitorsRequest request, StreamObserver<VisitorsRequest> responseObserver) {
        Visitors visitors = placeFindService.addVisitors(Visitors.fromVisitorsRequest(request));
        responseObserver.onNext(visitors.toVisitorsResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void byId(VisitorsRequestId request, StreamObserver<VisitorsRequest> responseObserver) {
        Visitors visitors = placeFindService.getById(UUID.fromString(request.getId()));
        responseObserver.onNext(visitors.toVisitorsResponse());
        responseObserver.onCompleted();
    }

    @Override
    public void delete(DeleteVisitorsRequest request, StreamObserver<DeleteVisitorsResponse> responseObserver) {
        placeFreeService.visitorsLeavePub(UUID.fromString(request.getId()));
        responseObserver.onNext(DeleteVisitorsResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

}