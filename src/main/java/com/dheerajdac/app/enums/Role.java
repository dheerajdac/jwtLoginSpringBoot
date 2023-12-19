package com.dheerajdac.app.enums;

public enum Role {
    
    ROLE_ADMIN("ROLE_ADMIN", 1),
    ROLE_SUPPORT("ROLE_SUPPORT", 2),
    ROLE_USER("ROLE_USER", 3);

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
