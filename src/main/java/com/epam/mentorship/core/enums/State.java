package com.epam.mentorship.core.enums;

public enum State {

    ALABAMA("Alabama"),
    ALASKA("Alaska"),
    ARIZONA("Arizona"),
    ARKANSAS("Arkansas"),
    CALIFORNIA("California"),
    COLORADO("Colorado"),
    CONNECTICUT("Connecticut"),
    DELAWARE("Delaware"),
    DISTRICT_OF_COLUMBIA("District of Columbia"),
    FLORIDA("Florida"),
    GEORGIA("Georgia"),
    HAWAII("Hawaii"),
    IDAHO("Idaho"),
    ILLINOIS("Illinois"),
    INDIANA("Indiana"),
    IOWA("Iowa"),
    KANSAS("Kansas"),
    KENTUCKY("Kentucky"),
    LOUISIANA("Louisiana"),
    MAINE("Maine"),
    MARYLAND("Maryland"),
    MASSACHUSETTS("Massachusetts"),
    MICHIGAN("Michigan"),
    MINNESOTA("Minnesota"),
    MISSISSIPPI("Mississippi"),
    MISSOURI("Missouri"),
    MONTANA("Montana"),
    NEBRASKA("Nebraska"),
    NEVADA("Nevada"),
    NEW_HAMPSHIRE("New Hampshire"),
    NEW_JERSEY("New Jersey"),
    NEW_MEXICO("New Mexico"),
    NEW_YORK("New York"),
    NORTH_CALIFORNIA("North Carolina"),
    NORTH_DAKOTA("North Dakota"),
    OHIO("Ohio"),
    OKLAHOMA("Oklahoma"),
    OREGON("Oregon"),
    PENNSYLVANIA("Pennsylvania"),
    PUERTI_RICO("Puerto Rico"),
    RHODE_ISLAND("Rhode Island"),
    SOUTH_CALIFORNIA("South Carolina"),
    SOUTH_DAKOTA("South Dakota"),
    TENNESSEE("Tennessee"),
    TEXAS("Texas"),
    US_VIRGIN_ISLANDS("US Virgin Islands"),
    UTAH("Utah"),
    VERMONT("Vermont"),
    VIRGINIA("Virginia"),
    WASHINGTON("Washington"),
    WEST_VIRGINIA("West Virginia"),
    VISCONSIN("Wisconsin"),
    WYOMING("Wyoming");

    private String state;

    State(String value){
        this.state=value;
    }

    public String getValue(){
        return state;
    }


}
