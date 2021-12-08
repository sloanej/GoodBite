/*
 * Created by Team 5 on 2021.11.20
 * Copyright © 2021 Team 5. All rights reserved.
 */
package edu.vt.FacadeBeans;

import edu.vt.EntityBeans.SharedMeal;
import edu.vt.misc.SharedMealData;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// @Stateless annotation implies that the conversational state with the client shall NOT be maintained.
@Stateless
public class SharedMealFacade extends AbstractFacade<SharedMeal> {
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
    public SharedMealFacade() {
        super(SharedMeal.class);
    }

//     Returns a list of object references of all the entity objects found in the database joined with user table
    public List<SharedMealData> joinUsername() {
        List<SharedMealData> sharedMealData = (List<SharedMealData>) getEntityManager()
                .createQuery(
                "SELECT u.username, m.userId, m.id, m.mealName, m.mealPhoto, m.mealDescription "+
                "FROM SharedMeal m "+
                "LEFT JOIN User u ON m.userId = u")
                .getResultList();

        return  sharedMealData;
    }

}
