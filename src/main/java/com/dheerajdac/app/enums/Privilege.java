package com.dheerajdac.app.enums;

public enum Privilege {

    READ("READ",1),
    WRITE("WRITE",2),
    MODIFY("MODIFY",3),
    DElETE("DElETE",4);

    private Privilege(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    private String name;

    private Integer value;

    public String getName() {
        return this.name;
    }
    
    public Integer getValue() {
        return this.value;
    }

    public static Privilege getPrivilegeByValue(Integer value){
        for(Privilege privilege: values()){
            if(privilege.getValue().equals(value)){
                return privilege;
            }
        }
        throw new RuntimeException("Privilege not found");
    }
}
