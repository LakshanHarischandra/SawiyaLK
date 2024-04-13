package com.jcode.sawiya.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lakshan harischandra
 */
@Entity
@Table(name = "verification")
public class Verification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "verification_id")
    private Integer verificationId;
    @Column(name = "location_by_map")
    private Short locationByMap;
    @Column(name = "location_by_manually")
    private Short locationByManually;
    @Column(name = "contact_verified")
    private Short contactVerified;
    @Column(name = "score")
    private Integer score;
    @Column(name = "approved_by")
    private Integer approvedBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "verificationId")
    private List<Institute> instituteList;

    public Verification() {
    }

    public Verification(Integer verificationId) {
        this.verificationId = verificationId;
    }

    public Integer getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(Integer verificationId) {
        this.verificationId = verificationId;
    }

    public Short getLocationByMap() {
        return locationByMap;
    }

    public void setLocationByMap(Short locationByMap) {
        this.locationByMap = locationByMap;
    }

    public Short getLocationByManually() {
        return locationByManually;
    }

    public void setLocationByManually(Short locationByManually) {
        this.locationByManually = locationByManually;
    }

    public Short getContactVerified() {
        return contactVerified;
    }

    public void setContactVerified(Short contactVerified) {
        this.contactVerified = contactVerified;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
    }

    public List<Institute> getInstituteList() {
        return instituteList;
    }

    public void setInstituteList(List<Institute> instituteList) {
        this.instituteList = instituteList;
    }
}
