package com.example.RestService.Controllers.Services.Repositories.EntityDTOs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Location")
public class LocationDTO {
    @XmlElement
    private Long locationId;
    @XmlElement
    private String streetAddress;
    @XmlElement
    private String postalCode;
    @XmlElement
    private String city;
    @XmlElement
    private String stateProvince;
    @XmlElement
    private String countryId;

    public Long getLocationId() {
        return locationId;
    }

    @XmlTransient
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    @XmlTransient
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @XmlTransient
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    @XmlTransient
    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    @XmlTransient
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountryId() {
        return countryId;
    }

    @XmlTransient
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}
