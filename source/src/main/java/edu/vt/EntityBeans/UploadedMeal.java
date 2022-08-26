/*
 * Created by Team 5 on 2021.7.14
 * Copyright © 2021 Team 5. All rights reserved.
 */
package edu.vt.EntityBeans;

import edu.vt.globals.Constants;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
The @Entity annotation designates this class as a JPA Entity POJO class
representing the UploadedMeal table in the CloudDriveDB database.
 */
@Entity

// Name of the database table represented
@Table(name = "UploadedMeals")

@NamedQueries({
    /*
    private User userId;    --> userId is the object reference of the User object.
    userId.id               --> User object's database primary key
     */
    @NamedQuery(name = "UploadedMeal.findAll", query = "SELECT u FROM UploadedMeal u")
    , @NamedQuery(name = "UploadedMeal.findById", query = "SELECT u FROM UploadedMeal u WHERE u.id = :id")
    , @NamedQuery(name = "UploadedMeal.findByFilename", query = "SELECT u FROM UploadedMeal u WHERE u.mealPhoto = :mealPhoto")
    , @NamedQuery(name = "UploadedMeal.findUserFilesByUserId", query = "SELECT u FROM UploadedMeal u WHERE u.userId.id = :userId")
})

public class UploadedMeal implements Serializable {
    /*
    ========================================================
    Instance variables representing the attributes (columns)
    of the UploadedMeal table in the CloudDriveDB database.

    CREATE TABLE UploadedMeal
    (
           id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
           filename VARCHAR(256) NOT NULL,
           user_id INT UNSIGNED,
           FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
    );

    ========================================================
     */
    private static final long serialVersionUID = 1L;

    // id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    // meal_photo VARCHAR(256) NOT NULL
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "meal_photo")
    private String mealPhoto;

    // user_id INT UNSIGNED
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    // meal_name VARCHAR(128) NOT NULL
    @Basic(optional = false)
    @Size(min = 1, max = 128)
    @Column(name = "meal_name")
    private String mealName;

    // file_description VARCHAR(2048) NOT NULL
    @Basic(optional = false)
    @Size(min = 1, max = 2048)
    @Column(name = "meal_description")
    private String mealDescription;

    /*
    ===================================================================
    Class constructors for instantiating a UploadedMeal entity object to
    represent a row in the UploadedMeal table in the CloudDriveDB database.
    ===================================================================
     */
    public UploadedMeal() {
    }

    // Used in handleFileUpload() method of FileUploadManager
    public UploadedMeal(String mealPhoto, User id, String mealName, String mealDescription) {
        this.mealPhoto = mealPhoto;
        userId = id;
        this.mealName = mealName;
        this.mealDescription = mealDescription;
    }

    /*
    ======================================================
    Getter and Setter methods for the attributes (columns)
    of the UploadedMeal table in the CloudDriveDB database.
    ======================================================
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMealPhoto() {
        return mealPhoto;
    }

    public void setMealPhoto(String filename) {
        this.mealPhoto = mealPhoto;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }

    /*
    ================================
    Instance Methods Used Internally
    ================================
     */

    // Generate and return a hash code value for the object with database primary key id
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /*
     Checks if the UploadedMeal object identified by 'object' is the same as the UploadedMeal object identified by 'id'
     Parameter object = UploadedMeal object identified by 'object'
     Returns True if the UploadedMeal 'object' and 'id' are the same; otherwise, return False
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UploadedMeal)) {
            return false;
        }
        UploadedMeal other = (UploadedMeal) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }

    // Return String representation of database primary key id
    @Override
    public String toString() {
        return id.toString();
    }

    /*
    =============
    Other Methods
    =============
     */

    public String getFilePath() {
        return Constants.FILES_ABSOLUTE_PATH + getMealPhoto();
    }

}
