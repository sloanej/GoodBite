/*
 * Created by Team 5 on 2021.12.4
 * Copyright © 2021 Team 5. All rights reserved.
 */

package edu.vt.FacadeBeans;

import edu.vt.EntityBeans.UserPantry;
import edu.vt.EntityBeans.UserRecipe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// @Stateless annotation implies that the conversational state with the client shall NOT be maintained.
@Stateless
public class UserRecipeFacade extends AbstractFacade<UserRecipe> {

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
    public UserRecipeFacade() {
        super(UserRecipe.class);
    }
//    findUserRecipeByUserId/

    public List<UserRecipe> findUserRecipeByUserId(Integer userId) {
        return (List<UserRecipe>) entityManager.createNamedQuery("UserRecipe.findUserRecipeByUserId")
                .setParameter("userId", userId)
                .getResultList();
    }
}
