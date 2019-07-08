package com.example.demo.Entities;

import com.example.demo.Entities.Locations;
import com.example.demo.Entities.Regions;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@XmlRootElement(name="Countries")
@Entity
public class Countries {
    @XmlElement
    private String countryId;
    @XmlElement
    private String countryName;

    @XmlElement
    private Long regionId;


    private Regions regionsByRegionId;
    private Collection<Locations> locationsByCountryId;

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
    public void setRegionId(Long regionId) { this.regionId = regionId; }



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

        Countries countries = (Countries) o;

        if (countryId != null ? !countryId.equals(countries.countryId) : countries.countryId != null) return false;
        if (countryName != null ? !countryName.equals(countries.countryName) : countries.countryName != null)
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
    @JoinColumn(name = "REGION_ID", referencedColumnName = "REGION_ID",insertable=false, updatable=false)
    public Regions getRegionsByRegionId() {
        return regionsByRegionId;
    }
    @XmlTransient
    @JsonIgnore
    public void setRegionsByRegionId(Regions regionsByRegionId) {
        this.regionsByRegionId = regionsByRegionId;
    }

    @OneToMany(mappedBy = "countriesByCountryId")
    public Collection<Locations> getLocationsByCountryId() {
        return locationsByCountryId;
    }
    @XmlTransient
    @JsonIgnore
    public void setLocationsByCountryId(Collection<Locations> locationsByCountryId) {
        this.locationsByCountryId = locationsByCountryId;
    }
}
