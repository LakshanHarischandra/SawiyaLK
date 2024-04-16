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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "institute")
public class Institute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "institution_id")
    private Integer institutionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address_line_one")
    private String addressLineOne;
    @Size(max = 100)
    @Column(name = "address_line_two")
    private String addressLineTwo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "postal_code")
    private String postalCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "country")
    private String country;
    @Size(max = 500)
    @Column(name = "location")
    private String location;
    @Size(max = 15)
    @Column(name = "contact_one")
    private String contactOne;
    @Size(max = 15)
    @Column(name = "contact_two")
    private String contactTwo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rep_agreed_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date repAgreedOn;
    @Column(name = "Institution_rating")
    private Integer institutionrating;
    @OneToMany(mappedBy = "institutionId")
    private List<Image> imageList;
    @OneToMany(mappedBy = "institutionId")
    private List<Review> reviewList;
    @JoinColumn(name = "rep_id", referencedColumnName = "rep_id")
    @ManyToOne(optional = false)
    private Representative repId;
    @JoinColumn(name = "verification_id", referencedColumnName = "verification_id")
    @ManyToOne(optional = false)
    private Verification verificationId;

    public Institute() {
    }

    public Institute(Integer institutionId) {
        this.institutionId = institutionId;
    }

    public Institute(Integer institutionId, String name, String description, String addressLineOne, String city, String postalCode, String country, Date repAgreedOn) {
        this.institutionId = institutionId;
        this.name = name;
        this.description = description;
        this.addressLineOne = addressLineOne;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.repAgreedOn = repAgreedOn;
    }

    public Integer getinstitutionId() {
        return institutionId;
    }

    public void setinstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactOne() {
        return contactOne;
    }

    public void setContactOne(String contactOne) {
        this.contactOne = contactOne;
    }

    public String getContactTwo() {
        return contactTwo;
    }

    public void setContactTwo(String contactTwo) {
        this.contactTwo = contactTwo;
    }

    public Date getRepAgreedOn() {
        return repAgreedOn;
    }

    public void setRepAgreedOn(Date repAgreedOn) {
        this.repAgreedOn = repAgreedOn;
    }

    public Integer getInstitutionrating() {
        return institutionrating;
    }

    public void setInstitutionrating(Integer institutionrating) {
        this.institutionrating = institutionrating;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public Representative getRepId() {
        return repId;
    }

    public void setRepId(Representative repId) {
        this.repId = repId;
    }

    public Verification getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(Verification verificationId) {
        this.verificationId = verificationId;
    }
}
