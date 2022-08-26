///*
/*
 * Created by Team 5 on 2021.11.15
 * Copyright © 2021 Team 5. All rights reserved.
 */
//
//package edu.vt.Carousel;
//
//import java.util.List;
//
//public class CheckboxView {
//    @Named
//    @RequestScoped
//    public class CheckboxView {
//
//        private String[] selectedOptions;
//        private String[] selectedOptions2;
//        private String[] selectedIngredients;
//        private String[] selectedIngredients;
//        private List<String> ingredients;
//        private List<SelectItem> ingredients;
//        private String[] selectedIngredients;
//
//        @PostConstruct
//        public void init() {
//            }
//
//
//        public String[] getSelectedOptions() {
//            return selectedOptions;
//        }
//
//        public void setSelectedOptions(String[] selectedOptions) {
//            this.selectedOptions = selectedOptions;
//        }
//
//        public String[] getSelectedOptions2() {
//            return selectedOptions2;
//        }
//
//        public void setSelectedOptions2(String[] selectedOptions2) {
//            this.selectedOptions2 = selectedOptions2;
//        }
//
//        public String[] getSelectedIngredients() {
//            return selectedIngredients;
//        }
//
//        public void setSelectedIngredients(String[] selectedIngredients) {
//            this.selectedIngredients = selectedIngredients;
//        }
//
//        public List<String> getIngredients() {
//            return ingredients;
//        }
//
//        public void setIngredients(List<SelectItem> ingredients) {
//            this.ingredients = ingredients;
//        }
//
//        public void setIngredients(List<String> ingredients) {
//            this.ingredients = ingredients;
//        }
//
//        public void onItemUnselect(UnselectEvent event) {
//            FacesContext context = FacesContext.getCurrentInstance();
//
//            FacesMessage msg = new FacesMessage();
//            msg.setSummary("Item unselected: " + event.getObject().toString());
//            msg.setSeverity(FacesMessage.SEVERITY_INFO);
//
//            context.addMessage(null, msg);
//        }
//    }
//}
