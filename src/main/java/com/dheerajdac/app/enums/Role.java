package com.dheerajdac.app.enums;

public enum Role {
    
    ADMIN("ADMIN", 1),
    SUPPORT("SUPPORT", 2),
    USER("USER", 3);

    private Role(String name, Integer value) {
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

    public static Role getRoleByValue(Integer value){
        for(Role role: values()){
            if(role.getValue().equals(value)){
                return role;
            }
        }
        throw new RuntimeException("Role not found");
    }

}
