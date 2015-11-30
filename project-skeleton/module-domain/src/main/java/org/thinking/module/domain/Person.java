package org.thinking.module.domain;

import com.thinking.module.core.enums.EnumValue;

public class Person {

    public enum Gender implements EnumValue<Integer>{
        MALE(1),FEMALE(2),OTHER(0);
        private int value;
        private Gender(int value) {
            this.value = value;
        }
        @Override
        public Integer getValue() {
            return value;
        }
        
        public static Gender value(int value){
            Gender[] genders = Gender.values();
            for (Gender gender : genders) {
                if(gender.getValue().intValue()==value){
                    return gender;
                }
            }
            return OTHER;
        }
    }
    private Long id;
    private String name;
    private Gender gender;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
}
