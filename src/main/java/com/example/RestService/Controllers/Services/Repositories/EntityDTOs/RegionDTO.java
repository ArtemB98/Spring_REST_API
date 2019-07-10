package com.example.RestService.Controllers.Services.Repositories.EntityDTOs;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "Region")
public class RegionDTO {
    @XmlElement
    private Long regionId;
    @XmlElement
    private String regionName;

    public Long getRegionId() {
        return regionId;
    }

    @XmlTransient
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    @XmlTransient
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
}
