
/*
 * Created by Team 5 on 2021.11.15
 * Copyright © 2021 Team 5. All rights reserved.
 */

package edu.vt.Carousel;

import edu.vt.EntityBeans.Recipe;
import edu.vt.FacadeBeans.RecipeFacade;
import org.primefaces.model.ResponsiveOption;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named

/*
The @SessionScoped annotation preserves the values of the recipeController
object's instance variables across multiple HTTP request-response cycles
as long as the user's established HTTP session is alive.
 */
@SessionScoped

    public class ChronoLineView implements Serializable{

        private List<Event> events;
        private List<String> events2;

        @PostConstruct
        public void init() {
            events = new ArrayList<>();
            events.add(new Event("Locate Nearby Stores", "15/10/2020 10:30", "pi pi-shopping-cart", "#9C27B0", ""));
            events.add(new Event("View and Analyse Nutrients Consumed", "15/10/2020 14:00", "pi pi-cog", "#673AB7"));
            events.add(new Event("Custom List Favourite Recipes", "15/10/2020 16:15", "pi pi-shopping-cart", "#FF9800"));
            events.add(new Event(" Get a better Insight to your health data", "16/10/2020 10:00", "pi pi-check", "#607D8B"));

            events2 = new ArrayList<>();
            events2.add("1");
            events2.add("2");
            events2.add("3");
            events2.add("4");
        }

        public List<Event> getEvents() {
            return events;
        }

        public List<String> getEvents2() {
            return events2;
        }

        public static class Event {
            private String status;
            private String date;
            private String icon;
            private String color;
            private String image;

            public Event() {
            }

            public Event(String status, String date, String icon, String color) {
                this.status = status;
                this.date = date;
                this.icon = icon;
                this.color = color;
            }

            public Event(String status, String date, String icon, String color, String image) {
                this.status = status;
                this.date = date;
                this.icon = icon;
                this.color = color;
                this.image = image;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }

    }
