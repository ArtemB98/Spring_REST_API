package com.example.RestService.Controllers.Services.Repositories.EntityDTOs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Country")
public class CountryDTO {
    @XmlElement
    private String countryId;
    @XmlElement
    private String countryName;
    @XmlElement
    private Long regionId;

    public String getCountryId() {
        return countryId;
    }

    @XmlTransient
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Long getRegionId() {
        return regionId;
    }

    @XmlTransient
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getCountryName() {
        return countryName;
    }

    @XmlTransient
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
