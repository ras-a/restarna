package jp.co.creambakery.bean;

import jp.co.creambakery.entity.*;

public class CustomItemBean extends ItemBean  {

    private String creator;
    private Boolean isPublic;

    CustomItemBean(CustomItem entity) {
        super(entity.getItem());
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Boolean isPublic() {
        return isPublic;
    }

    public void setPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }
}