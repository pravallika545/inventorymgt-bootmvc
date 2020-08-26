package com.dxctraining.inventorymgt.item.dto;

public class PhoneDto {
    private int id;
    private String name;
    private int storagesize;
    private int supplierId;
    private String supplierName;

    public PhoneDto(){

    }
    public PhoneDto(int id, String name, int storagesize){
        this.id = id;
        this.name = name;
        this.storagesize = storagesize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStoragesize() {
        return storagesize;
    }

    public void setStoragesize(int storagesize) {
        this.storagesize = storagesize;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
