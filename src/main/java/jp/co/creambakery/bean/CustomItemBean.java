package jp.co.creambakery.bean;

import jp.co.creambakery.entity.*;

public class CustomItemBean extends ItemBean  {

    private UserBean creator;
    private Boolean isPublic;

    CustomItemBean(CustomItem entity) {
        super(entity.getItem());
    }

    public UserBean getCreator() {
        return creator;
    }

    public void setCreator(UserBean creator) {
        this.creator = creator;
    }

    public Boolean isPublic() {
        return isPublic;
    }

    public void setPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }
}