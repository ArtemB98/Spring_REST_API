package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@XmlRootElement(name = "Country")
@Entity
@Table(name = "COUNTRIES")
public class Country {
    @XmlElement
    private String countryId;
    @XmlElement
    private String countryName;

    @XmlElement
    private Long regionId;


    private Region regionByRegionId;
    private Collection<Location> locationByCountryId;

    @Id
    @Column(name = "COUNTRY_ID", nullable = false, length = 2)
    public String getCountryId() {
        return countryId;
    }

    @XmlTransient
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "REGION_ID", nullable = true)
    public Long getRegionId() {
        return regionId;
    }

    @XmlTransient
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }


    @Basic
    @Column(name = "COUNTRY_NAME", nullable = true, length = 40)
    public String getCountryName() {
        return countryName;
    }

    @XmlTransient
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (countryId != null ? !countryId.equals(country.countryId) : country.countryId != null) return false;
        if (countryName != null ? !countryName.equals(country.countryName) : country.countryName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId != null ? countryId.hashCode() : 0;
        result = 31 * result + (countryName != null ? countryName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID", insertable = false, updatable = false)
    public Region getRegionByRegionId() {
        return regionByRegionId;
    }

    @XmlTransient
    @JsonIgnore
    public void setRegionByRegionId(Region regionByRegionId) {
        this.regionByRegionId = regionByRegionId;
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<Location> getLocationByCountryId() {
        return locationByCountryId;
    }

    @XmlTransient
    @JsonIgnore
    public void setLocationByCountryId(Collection<Location> locationByCountryId) {
        this.locationByCountryId = locationByCountryId;
    }
}
