package com.ninjarmm.app.entity.device;


import com.ninjarmm.app.entity.service.ServeType;

import java.util.Arrays;
import java.util.List;

public enum DeviceType {
    Windows_Workstation(Arrays.asList(ServeType.Windows, ServeType.Normal)),
    Windows_Server(Arrays.asList(ServeType.Windows, ServeType.Normal)),
    Mac(Arrays.asList(ServeType.Mac, ServeType.Normal));

    private List<ServeType> serveTypesAllowed;

    DeviceType(List<ServeType> serveTypesAllowed) {
        this.serveTypesAllowed = serveTypesAllowed;
    }

    public List<ServeType> getServicesTypeAllowed() {
        return this.serveTypesAllowed;
    }

}

