package com.RentalCar.dtos;

public class GetClientDataDto {

    private int id;

    public GetClientDataDto(int id) {
        this.id = id;
    }

    public GetClientDataDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
