/*
 * Created by Team 5 on 2021.10.18
 * Copyright © 2021 Team 5. All rights reserved.
 */
package edu.vt.managers;


import edu.vt.EntityBeans.User;
import edu.vt.controllers.UserRecipeController;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.shaded.json.JSONArray;

// These two are needed for PrimeFaces file download
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named(value = "fileDownloadManager")
@RequestScoped
public class FileDownloadManager implements Serializable {
    /*
    ===============================
    Instance Variables (Properties)
    ===============================
     */

    /*
    The @Inject annotation directs the CDI Container Manager to inject (store) the object reference of the
    CDI container-managed CompanyController bean into the instance variable 'companyController' after it is instantiated at runtime.
     */
    @Inject
    UserRecipeController userRecipeController;

    /*
    DefaultStreamedContent and StreamedContent classes are
    imported from the org.primefaces.model packages above.
     */
    private StreamedContent file;

    /*
    =========================
    Getter and Setter Methods
    =========================
     */
    public StreamedContent getFile() {

        // 'items' contains the data table content. Convert it to JSONArray.
        JSONArray jasonArray = new JSONArray(userRecipeController.getListOfRecipes());

        // Convert the JSON array into a String
        String dataTableAsJsonString = jasonArray.toString();

        /*
        -----------------------------------------------------------------------------------------------------
        'listOfCompanies' is List<Company>: an Array List containing the object references of Company objects.
        Each Company object is represented as a JSON object with KEY-VALUE pairings.
        The KEY-VALUE pairings are not in any particular order.
        [                                              <== Start of JSON array
            {                                          <== Start of first company's JSON object
                "ticker":"WMT",
                "website":"https://www.walmart.com",
                "name":"Wal-Mart Stores Inc.",
                "exchange":"NYSE",
                "id":1,
                "employees":2300000,
                "revenues":500343,
                "sector":"Retailing"
            },                                         <== End of first company's JSON object
            :
            :
            {                                          <== Start of last company's JSON object
                "ticker":"GM",
                "website":"https://www.gm.com",
                "name":"General Motors Company",
                "exchange":"NYSE",
                "id":43,
                "employees":180000,
                "revenues":157311,
                "sector":"Motor Vehicles & Parts"
            }                                          <== End of last company's JSON object
        ]                                              <== End of JSON array
        -----------------------------------------------------------------------------------------------------
         */
        // Convert the String into an InputStream
        InputStream inputStream = new ByteArrayInputStream(dataTableAsJsonString.getBytes());

        file = DefaultStreamedContent.builder().contentType("text/plain").name("RecipesInJSONFile.txt").stream(() -> inputStream).build();

        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }

    public UserRecipeController getUserRecipeController() {
        return userRecipeController;
    }

    public void UserRecipeController(UserRecipeController userRecipeController) {
        this.userRecipeController = userRecipeController;
    }

}
