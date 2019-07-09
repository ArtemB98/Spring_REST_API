package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@Entity
@XmlRootElement(name = "Locations")
public class Locations {
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

    private Collection<Departments> departmentsByLocationId;
    private Countries countriesByCountryId;


    @Basic
    @Column(name = "COUNTRY_ID", nullable = true, length = 2)
    public String getCountryId() {
        return countryId;
    }

    @XmlTransient
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }


    @Id
    @Column(name = "LOCATION_ID", nullable = false, precision = 0)
    public Long getLocationId() {
        return locationId;
    }

    @XmlTransient
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "STREET_ADDRESS", nullable = true, length = 40)
    public String getStreetAddress() {
        return streetAddress;
    }

    @XmlTransient
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Basic
    @Column(name = "POSTAL_CODE", nullable = true, length = 12)
    public String getPostalCode() {
        return postalCode;
    }

    @XmlTransient
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "CITY", nullable = false, length = 30)
    public String getCity() {
        return city;
    }

    @XmlTransient
    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "STATE_PROVINCE", nullable = true, length = 25)
    public String getStateProvince() {
        return stateProvince;
    }

    @XmlTransient
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locations locations = (Locations) o;

        if (locationId != null ? !locationId.equals(locations.locationId) : locations.locationId != null) return false;
        if (streetAddress != null ? !streetAddress.equals(locations.streetAddress) : locations.streetAddress != null)
            return false;
        if (postalCode != null ? !postalCode.equals(locations.postalCode) : locations.postalCode != null) return false;
        if (city != null ? !city.equals(locations.city) : locations.city != null) return false;
        if (stateProvince != null ? !stateProvince.equals(locations.stateProvince) : locations.stateProvince != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = locationId != null ? locationId.hashCode() : 0;
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateProvince != null ? stateProvince.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "locationsByLocationId")
    public Collection<Departments> getDepartmentsByLocationId() {
        return departmentsByLocationId;
    }

    @XmlTransient
    @JsonIgnore
    public void setDepartmentsByLocationId(Collection<Departments> departmentsByLocationId) {
        this.departmentsByLocationId = departmentsByLocationId;
    }

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", insertable = false, updatable = false)
    public Countries getCountriesByCountryId() {
        return countriesByCountryId;
    }

    @XmlTransient
    @JsonIgnore
    public void setCountriesByCountryId(Countries countriesByCountryId) {
        this.countriesByCountryId = countriesByCountryId;
    }
}
