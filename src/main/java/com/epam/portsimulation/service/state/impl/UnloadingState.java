package com.epam.portsimulation.service.state.impl;

import com.epam.portsimulation.entity.Dock;
import com.epam.portsimulation.entity.Ship;
import com.epam.portsimulation.service.state.ShipState;

public class UnloadingState extends ShipState {
    public UnloadingState(Ship ship) {
        super(ship);
    }
    @Override
    public boolean doActionInPort(Dock dock) {
        int containersCount = ship.getContainersCount();
        boolean isSuccessful = dock.addContainers(containersCount);
        if (isSuccessful) {
            ship.setContainersCount(0);
        }
        return isSuccessful;
    }
}
