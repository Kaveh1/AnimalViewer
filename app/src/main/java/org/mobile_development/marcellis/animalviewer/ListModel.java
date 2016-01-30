package org.mobile_development.marcellis.animalviewer;

/**
 * Created by Marcellis on 30-1-2016.
 */
public class ListModel {


    private int imageId;
    private String imageText;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImageText() {
        return imageText;
    }

    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    public ListModel(int imageId, String imageText) {

        this.imageId = imageId;
        this.imageText = imageText;
    }
}
