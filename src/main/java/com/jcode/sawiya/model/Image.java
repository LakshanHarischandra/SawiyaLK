package com.jcode.sawiya.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.jcode.sawiya.model.Institute;

/**
 *
 * @author Lakshan harischandra
 */
@Entity
@Table(name = "image")
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "image_id")
    private Long imageId;
    @Size(max = 2000)
    @Column(name = "url")
    private String url;
    @Lob
    @Column(name = "image")
    private byte[] image;
    @JoinColumn(name = "institute_id", referencedColumnName = "institute_id")
    @ManyToOne
    private Institute instituteId;
    @JoinColumn(name = "post_id", referencedColumnName = "post_id")
    @ManyToOne
    private Post postId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private User userId;

    public Image() {
    }

    public Image(Long imageId) {
        this.imageId = imageId;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Institute getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Institute instituteId) {
        this.instituteId = instituteId;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
