package com.kosa.ShareTour.dto;

import com.kosa.ShareTour.entity.Accommodation;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;

@Data
public class AccommodationFormDto {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    private String url;

//    @Length
    private String phone;

    @NotBlank
    private String area;

    @NotBlank
    private String grade;

    @NotBlank
    private String parking;

    @NotBlank
//    @Length
    private String locX;

    @NotBlank
//    @Length
    private String locY;

    @NotBlank
    private float price;

    private static ModelMapper modelMapper = new ModelMapper();

    public Accommodation createAccommodation() {
        return modelMapper.map(this, Accommodation.class);
    }

}
