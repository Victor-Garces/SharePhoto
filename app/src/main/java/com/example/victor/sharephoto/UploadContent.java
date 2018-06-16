package com.example.victor.sharephoto;

public class UploadContent {

    private String ImageComment;

    private String ImageLocation;

    private String ImageURL;

    public void setImageComment(String imageComment) {
        ImageComment = imageComment;
    }

    public void setImageLocation(String imageLocation) {
        ImageLocation = imageLocation;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getImageComment(){
        return ImageComment;
    }

    public String getImageLocation(){
        return ImageLocation;
    }

    public String getImageURL(){
        return ImageURL;
    }
}
