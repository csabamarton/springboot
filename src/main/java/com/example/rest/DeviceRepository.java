package com.example.rest;

import com.example.model.Device;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "device", path="device")
public interface DeviceRepository extends PagingAndSortingRepository<Device, Long>{

    List<Device> findByDeviceId(@Param("deviceid") Long deviceId);
}

