/*
 * Created by Team 5 on 2021.11.20
 * Copyright © 2021 Team 5. All rights reserved.
 */
package edu.vt.FacadeBeans;

import edu.vt.EntityBeans.UploadedMeal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// @Stateless annotation implies that the conversational state with the client shall NOT be maintained.
@Stateless
public class UploadedMealFacade extends AbstractFacade<UploadedMeal> {
    /*
    ---------------------------------------------------------------------------------------------
    The EntityManager is an API that enables database CRUD (Create Read Update Delete) operations
    and complex database searches. An EntityManager instance is created to manage entities
    that are defined by a persistence unit. The @PersistenceContext annotation below associates
    the entityManager instance with the persistence unitName identified below.
    ---------------------------------------------------------------------------------------------
     */
    @PersistenceContext(unitName = "GoodBitePU")
    private EntityManager entityManager;

    // Obtain the object reference of the EntityManager instance in charge of
    // managing the entities in the persistence context identified above.
    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    /*
    This constructor method invokes its parent AbstractFacade's constructor method,
    which in turn initializes its entity class type T and entityClass instance variable.
     */
    public UploadedMealFacade() {
        super(UploadedMeal.class);
    }

    /*
     *********************
     *   Other Methods   *
     *********************
     */

    // Returns the object reference of the UploadedMeal object whose primary key is id
    public UploadedMeal getUserFile(int id) {
        return entityManager.find(UploadedMeal.class, id);
    }

    // Returns a list of object references of UploadedMeal objects that belong to
    // the User object whose database Primary Key = primaryKey
    public List<UploadedMeal> findUserFilesByUserPrimaryKey(Integer primaryKey) {
        /*
        The following @NamedQuery definition is given in UploadedMeal entity class file:
        @NamedQuery(name = "UploadedMeal.findUserFilesByUserId", query = "SELECT u FROM UploadedMeal u WHERE u.userId.id = :userId")
        
        The following statement obtains the results from the named database query.
         */
        return entityManager.createNamedQuery("UploadedMeal.findUserFilesByUserId")
                .setParameter("userId", primaryKey)
                .getResultList();
    }

    // Returns a list of object references of UploadedMeal objects whose name is file_name
    // It is assumed that file names are not unique and many files can have the same name
    public List<UploadedMeal> findByFilename(String file_name) {
        /*
        The following @NamedQuery definition is given in UploadedMeal entity class file:
        @NamedQuery(name = "UploadedMeal.findByFilename", query = "SELECT u FROM UploadedMeal u WHERE u.filename = :filename")
        
        The following statement obtains the results from the named database query.
         */
        return entityManager.createNamedQuery("UploadedMeal.findByFilename")
                .setParameter("mealPhoto", file_name)
                .getResultList();
    }

}
