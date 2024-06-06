package org.studyeasy.SpringBlog.util.constants;

public enum Previllage {
    RESET_ANY_USER_PASSWORD(1l,"RESET_ANY_USER_PASSWORD"),
    ACCESS_ADMIN_PANEL(2l,"ACCESS_ADMIN_PANEL");

    private Long id;

    private String previllage;

    private Previllage(long id , String previllage){
        this.id=id;
        this.previllage = previllage;

    }
    public Long getId(){
        return id;
    }

    public String getprevillage(){
        return previllage;
    }
    
    
    
}
