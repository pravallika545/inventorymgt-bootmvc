package com.dxctraining.inventorymgt.item.util;

import com.dxctraining.inventorymgt.item.dto.PhoneDto;
import com.dxctraining.inventorymgt.item.entities.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneUtil {
    public PhoneDto phoneDto(Phone phone, int supplierId, String supplierName){
        PhoneDto dto = new PhoneDto(phone.getId(),phone.getName(),phone.getStoragesize());
        dto.setSupplierId(supplierId);
        dto.setSupplierName(supplierName);
        return dto;
    }
}
