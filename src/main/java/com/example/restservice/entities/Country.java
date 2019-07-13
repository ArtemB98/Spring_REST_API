package com.example.restservice.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "COUNTRIES")
public class Country {
    private String countryId;
    private String countryName;
    private Long regionId;
    private Region regionByRegionId;
    private Collection<Location> locationByCountryId;

    @Id
    @Column(name = "COUNTRY_ID", nullable = false, length = 2)
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "REGION_ID", nullable = true)
    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }


    @Basic
    @Column(name = "COUNTRY_NAME", nullable = true, length = 40)
    public String getCountryName() {
        return countryName;
    }

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

    public void setRegionByRegionId(Region regionByRegionId) {
        this.regionByRegionId = regionByRegionId;
    }

    @OneToMany(mappedBy = "countryByCountryId")
    public Collection<Location> getLocationByCountryId() {
        return locationByCountryId;
    }

    public void setLocationByCountryId(Collection<Location> locationByCountryId) {
        this.locationByCountryId = locationByCountryId;
    }
}
