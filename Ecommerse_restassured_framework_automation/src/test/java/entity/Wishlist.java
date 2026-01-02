package entity;

import java.util.Date;
import java.util.List;

public class Wishlist
{
    private String user;              // maps to User _id
    private List<Item> items;         // wishlist items

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // ================== Inner Class ==================

    public static class Item {
        private String product;       // maps to Product _id
        private Boolean savedForLater;
        private Date addedAt;

        public String getProduct() {
            return product;
        }

        public void setProduct(String product) {
            this.product = product;
        }

        public Boolean getSavedForLater() {
            return savedForLater;
        }

        public void setSavedForLater(Boolean savedForLater) {
            this.savedForLater = savedForLater;
        }

        public Date getAddedAt() {
            return addedAt;
        }

        public void setAddedAt(Date addedAt) {
            this.addedAt = addedAt;
        }
    }
}
