/*
 * Created by Team 5 on 2021.12.4
 * Copyright © 2021 Team 5. All rights reserved.
 */

package edu.vt.FacadeBeans;

import edu.vt.EntityBeans.Recipe;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// @Stateless annotation implies that the conversational state with the client shall NOT be maintained.
@Stateless
public class RecipeFacade extends AbstractFacade<Recipe> {
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
    public RecipeFacade() { super(Recipe.class); }


    /*
    *********************
    *   Other Methods   *
    *********************
     */

    // Returns the object reference of the Recipe object whose name is name
    public Recipe findByName(String name) {
        /*
        The following @NamedQuery definition is given in Recipe.java entity class file:
        @NamedQuery(name = "Recipe.findByName", query = "SELECT c FROM Recipe c WHERE c.name = :name")
         */

        if (entityManager.createNamedQuery("Recipe.findByName")
                .setParameter("name", name)
                .getResultList().isEmpty()) {

            // Return null if no recipe object exists
            return null;

        } else {

            // Return the Object reference of the recipe object whose name is name
            return (Recipe) (entityManager.createNamedQuery("Recipe.findByName")
                    .setParameter("name", name)
                    .getSingleResult());
        }
    }

  //Query Methods to search the Database

    /*
    -----------------------------
    Search Category: Name
    -----------------------------
     */
     //Searches RecipesDB for recipes where recipes name contains the searchString entered by the user.
    public List<Recipe> nameQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in the Car name
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery(
                "SELECT c FROM Recipe c WHERE c.name LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    }

    /*
//    -----------------------------
//    Search Category: Category
//    -----------------------------
//     */
//    // Searches RecipesDB for recipes where category contains the searchString entered by the user.
    public List<Recipe> categoryQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in the capital city name
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery(
                "SELECT c FROM Recipe c WHERE c.category LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    }
//
//    /*
//    -------------------------
//    Search Category: Cuisine
//    -------------------------
//     */
//    // Searches RecipesDB for recipes where cuisine contains the searchString entered by the user.
    public List<Recipe> cuisineQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in the language name
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery(
                "SELECT c FROM Recipe c WHERE c.cuisine LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    }

//  /*
//   -------------------------
//   Search Category: Publisher Name
//   -------------------------
//    */
//  // Searches RecipesDB for recipes where publisher_name contains the searchString entered by the user.
    public List<Recipe> publisherNameQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in the currency name
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery(
                "SELECT c FROM Recipe c WHERE c.source LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    }

    /*
//    --------------------
//    Search Category: ALL
//    --------------------
//     */
//    // Searches RecipesDB for recipes where name OR category or cuisine or Publisher name  contains the searchString entered by the user.
    public List<Recipe> allQuery(String searchString) {
        // Place the % wildcard before and after the search string to search for it anywhere in each attribute name
        searchString = "%" + searchString + "%";
        // Conduct the search in a case-insensitive manner and return the results in a list.
        return getEntityManager().createQuery(
                "SELECT c FROM Recipe c WHERE c.name LIKE :searchString OR c.category LIKE :searchString OR c.cuisine LIKE :searchString OR c.source LIKE :searchString")
                .setParameter("searchString", searchString)
                .getResultList();
    }

    }


