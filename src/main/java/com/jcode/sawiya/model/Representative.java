package com.jcode.sawiya.model;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Lakshan harischandra
 */
@Entity
@Table(name = "representative")
public class Representative implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rep_id")
    private Integer repId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "appointed_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appointedOn;
    @Column(name = "retired_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date retiredOn;
    @Size(max = 100)
    @Column(name = "remarks")
    private String remarks;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repId")
    private List<Institute> instituteList;

    public Representative() {
    }

    public Representative(Integer repId) {
        this.repId = repId;
    }

    public Representative(Integer repId, Date appointedOn) {
        this.repId = repId;
        this.appointedOn = appointedOn;
    }

    public Integer getRepId() {
        return repId;
    }

    public void setRepId(Integer repId) {
        this.repId = repId;
    }

    public Date getAppointedOn() {
        return appointedOn;
    }

    public void setAppointedOn(Date appointedOn) {
        this.appointedOn = appointedOn;
    }

    public Date getRetiredOn() {
        return retiredOn;
    }

    public void setRetiredOn(Date retiredOn) {
        this.retiredOn = retiredOn;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<Institute> getInstituteList() {
        return instituteList;
    }

    public void setInstituteList(List<Institute> instituteList) {
        this.instituteList = instituteList;
    }  
}
