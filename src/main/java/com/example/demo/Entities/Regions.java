package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Collection;

@XmlRootElement(name = "Region")
@Entity
public class Regions {
    @XmlElement
    private Long regionId;
    @XmlElement
    private String regionName;
    private Collection<Countries> countriesByRegionId;

    @Id
    @Column(name = "REGION_ID", nullable = false, precision = 0)
    public Long getRegionId() {
        return regionId;
    }

    @XmlTransient
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "REGION_NAME", nullable = true, length = 25)
    public String getRegionName() {
        return regionName;
    }

    @XmlTransient
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Regions regions = (Regions) o;

        if (regionId != null ? !regionId.equals(regions.regionId) : regions.regionId != null) return false;
        if (regionName != null ? !regionName.equals(regions.regionName) : regions.regionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = regionId != null ? regionId.hashCode() : 0;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "regionsByRegionId")
    public Collection<Countries> getCountriesByRegionId() {
        return countriesByRegionId;
    }

    @XmlTransient
    @JsonIgnore
    public void setCountriesByRegionId(Collection<Countries> countriesByRegionId) {
        this.countriesByRegionId = countriesByRegionId;
    }
}
