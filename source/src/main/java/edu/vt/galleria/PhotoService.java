/*
 * Created by Team 5 on 2021.11.11
 * Copyright © 2021 Team 5. All rights reserved.
 */

package edu.vt.galleria;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@Named(value = "photoService")
@ApplicationScoped
public class PhotoService {
    /*
    ============================
    Instance Variable (Property)
    ============================
     */
    private List<Photo> listOfPhotos;

    /*
    The PostConstruct annotation is used on a method that needs to be executed after
    dependency injection is done to perform any initialization. The initialization
    method init() is the first method invoked before this class is put into service.
     */
    @PostConstruct
    public void init() {
        listOfPhotos = new ArrayList<>();

        listOfPhotos.add(new Photo("/resources/images/slider/photo1.jpg", "/resources/images/slider/photos1.png", "Description for Photo 1", "Onions"));
        listOfPhotos.add(new Photo("/resources/images/slider/photo2.jpg", "/resources/images/slider/photos2.png", "Description for Photo 2", "Corn"));
        listOfPhotos.add(new Photo("/resources/images/slider/photo3.jpg", "/resources/images/slider/photos3.png", "Description for Photo 3", "Chickpeas"));
        listOfPhotos.add(new Photo("/resources/images/slider/photo4.jpg", "/resources/images/slider/photos4.png", "Description for Photo 4", "Lemons"));
        listOfPhotos.add(new Photo("/resources/images/slider/photo5.jpg", "/resources/images/slider/photos5.png", "Description for Photo 5", "Cooked Beans"));
        listOfPhotos.add(new Photo("/resources/images/slider/photo6.jpg", "/resources/images/slider/photos6.png", "Description for Photo 6", "Pears"));
        listOfPhotos.add(new Photo("/resources/images/slider/photo7.jpg", "/resources/images/slider/photos7.png", "Description for Photo 7", "Orange"));
        listOfPhotos.add(new Photo("/resources/images/slider/photo8.jpg", "/resources/images/slider/photos8.png", "Description for Photo 8", "Ginger"));
        listOfPhotos.add(new Photo("/resources/images/slider/photo9.jpg", "/resources/images/slider/photos9.png", "Description for Photo 9", "Chia Seeds"));
        listOfPhotos.add(new Photo("/resources/images/slider/photo10.jpg", "/resources/images/slider/photos10.png", "Description for Photo 10", "Potatoes"));
        listOfPhotos.add(new Photo("/resources/images/slider/photo11.jpg", "/resources/images/slider/photos11.png", "Description for Photo 11", "Pineapple"));
        listOfPhotos.add(new Photo("/resources/images/slider/photo12.jpg", "/resources/images/slider/photos12.png", "Description for Photo 12", "Mangoes"));



    }

    /*
    =============
    Getter Method
    =============
     */
    public List<Photo> getListOfPhotos() {
        return listOfPhotos;
    }
}
