package jp.co.creambakery.bean;

import jp.co.creambakery.entity.*;

public class StoreItemBean extends ItemBean
{
    private String image;

    StoreItemBean(StoreItem entity) {
        super(entity.getItem());
        image = entity.getImage();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
