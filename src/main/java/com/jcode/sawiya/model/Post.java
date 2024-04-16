package com.jcode.sawiya.model;

import java.io.Serializable;
import java.util.List;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "post_id")
    private Long postId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "heading")
    private String heading;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "place")
    private String place;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "contact_one")
    private String contactOne;
    @Size(max = 15)
    @Column(name = "contact_two")
    private String contactTwo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_verified_place")
    private short isVerifiedPlace;
    @Column(name = "no_of_stars")
    private Integer noOfStars;
    @Size(max = 50)
    @Column(name = "picked_by")
    private String pickedBy;
    @Column(name = "picked_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickedOn;
    @Column(name = "picked_agreed_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pickedAgreedOn;
    @Size(max = 50)
    @Column(name = "approved_by")
    private String approvedBy;
    @Column(name = "approved_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedOn;
    @Size(max = 50)
    @Column(name = "acknowledge_by")
    private String acknowledgeBy;
    @Column(name = "ack_agreed_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ackAgreedOn;
    @Column(name = "acknowledge_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acknowledgeOn;
    @Size(max = 50)
    @Column(name = "cancelled_by")
    private String cancelledBy;
    @Column(name = "cancelled_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelledOn;
    @OneToMany(mappedBy = "postId")
    private List<Image> imageList;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "institution_id", referencedColumnName = "institution_id")
    @OneToOne(optional = false)
    private Institute institutionId;

    public Post() {
    }

    public Post(Long postId) {
        this.postId = postId;
    }

    public Post(Long postId, String category, String heading, String description, String place, String address, String contactOne, String status, Date createdOn, short isVerifiedPlace) {
        this.postId = postId;
        this.category = category;
        this.heading = heading;
        this.description = description;
        this.place = place;
        this.address = address;
        this.contactOne = contactOne;
        this.status = status;
        this.createdOn = createdOn;
        this.isVerifiedPlace = isVerifiedPlace;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public short getIsVerifiedPlace() {
        return isVerifiedPlace;
    }

    public void setIsVerifiedPlace(short isVerifiedPlace) {
        this.isVerifiedPlace = isVerifiedPlace;
    }

    public Integer getNoOfStars() {
        return noOfStars;
    }

    public void setNoOfStars(Integer noOfStars) {
        this.noOfStars = noOfStars;
    }

    public String getPickedBy() {
        return pickedBy;
    }

    public void setPickedBy(String pickedBy) {
        this.pickedBy = pickedBy;
    }

    public Date getPickedOn() {
        return pickedOn;
    }

    public void setPickedOn(Date pickedOn) {
        this.pickedOn = pickedOn;
    }

    public Date getPickedAgreedOn() {
        return pickedAgreedOn;
    }

    public void setPickedAgreedOn(Date pickedAgreedOn) {
        this.pickedAgreedOn = pickedAgreedOn;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedOn() {
        return approvedOn;
    }

    public void setApprovedOn(Date approvedOn) {
        this.approvedOn = approvedOn;
    }

    public String getAcknowledgeBy() {
        return acknowledgeBy;
    }

    public void setAcknowledgeBy(String acknowledgeBy) {
        this.acknowledgeBy = acknowledgeBy;
    }

    public Date getAckAgreedOn() {
        return ackAgreedOn;
    }

    public void setAckAgreedOn(Date ackAgreedOn) {
        this.ackAgreedOn = ackAgreedOn;
    }

    public Date getAcknowledgeOn() {
        return acknowledgeOn;
    }

    public void setAcknowledgeOn(Date acknowledgeOn) {
        this.acknowledgeOn = acknowledgeOn;
    }

    public String getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(String cancelledBy) {
        this.cancelledBy = cancelledBy;
    }

    public Date getCancelledOn() {
        return cancelledOn;
    }

    public void setCancelledOn(Date cancelledOn) {
        this.cancelledOn = cancelledOn;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Institute getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Institute institutionId) {
        this.institutionId = institutionId;
    }    
}
