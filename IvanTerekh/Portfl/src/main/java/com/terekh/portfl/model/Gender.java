package com.terekh.portfl.model;

public enum Gender {
	GENDER_CISGENDER_MALE("Cisgender Male"),
	GENDER_CISGENDER_FEMALE("Cisgender Female"),
	GENDER_TRANSSEXUAL_MALE("Transsexual male"),
	GENDER_TRANSSEXUAL_FEMALE("Transsexual born female"),
	GENDER_TRANSGENDER_MALE("Transgender born male"),
	GENDER_TRANSGENDER_FEMALE("Transgender female"),
	GENDER_AGENDER_MALE("Agender male"),
	GENDER_AGENDER_FEMALE("Agender female"),
	GENDER_BIGENDER_MALE("Bigender male"),
	GENDER_BIGENDER_FEMALE("Bigender female"),
	GENDER_OTHER("Other");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
    public static Gender genderFromString(String value){
    	for(Gender gender : Gender.values()){
    		if (value.equals(gender.label)){
    			return gender;
    		}
    	}
    	return null;
    }
}
