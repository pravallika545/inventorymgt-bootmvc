package com.dxctraining.inventorymgt.item.util;

import com.dxctraining.inventorymgt.item.dto.ComputerDto;
import com.dxctraining.inventorymgt.item.entities.Computer;
import org.springframework.stereotype.Component;

@Component
public class ComputerUtil {
    public ComputerDto computerDto(Computer computer, int supplierId, String supplierName){
        ComputerDto dto = new ComputerDto(computer.getId(),computer.getName(),computer.getDiscsize());
        dto.setSupplierId(supplierId);
        dto.setSupplierName(supplierName);
        return dto;
    }
}
