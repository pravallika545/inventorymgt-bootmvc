package com.dxctraining.inventorymgt.item.dto;

public class ComputerDto {
    private int id;
    private String name;
    private int discsize;
    private int supplierId;
    private String supplierName;

    private ComputerDto(){

    }

    public ComputerDto(int id, String name, int discsize){
        this.id = id;
        this.name = name;
        this.discsize = discsize;
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

    public int getDiscsize() {
        return discsize;
    }

    public void setDiscsize(int discsize) {
        this.discsize = discsize;
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
