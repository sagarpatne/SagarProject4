package com.rays.pro4.bean;

/**
 * Role JavaBean encapsulates Role attributes.
 */
/**
 * @author SAGAR PATNE
 *
 */
public class RoleBean extends BaseBean {

       public static final int ADMIN = 1;
    public static final int STUDENT = 2;
    public static final int COLLEGE = 3;
    public static final int FACULTY = 4;
    public static final int KIOSK = 5;

    
    private String name;

        private String description;

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getkey() {
        return id + " ";
    }

    public String getValue() {
        return name;
    }

	

}