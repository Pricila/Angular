package models;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;

/**
 * Created by PAVILION-DV6 on 9/4/2017.
 */
@Entity
@Table(name = "USERS", schema = "APP")
public class User {
    @Id
    private int identification;
    @Nullable
    private String first_name;
    @Nullable
    private String last_name;
    @Nullable
    private String gender;
    @Nullable
    private String date_of_birth;
    @Nullable
    private String address_city;
    @Nullable
    private String address;
    @Nullable
    private String postal_code;


    public int getIdentification() { return identification; }

    public void setIdentification(int identification) { this.identification = identification;  }

    @Basic
    public String getFirst_name() { return first_name; }

    public void setFirst_name(String first_name) { this.first_name = first_name; }

    @Basic
    public String getLast_name() { return last_name; }

    public void setLast_name(String last_name) { this.last_name = last_name; }

    @Basic
    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    @Basic
    public String getDate_of_birth() { return date_of_birth; }

    public void setDate_of_birth(String date_of_birth) { this.date_of_birth = date_of_birth; }

    @Basic
    public String getAddress_city() { return address_city; }

    public void setAddress_city(String address_city) { this.address_city = address_city; }

    @Basic
    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    @Basic
    public String getPostal_code() { return postal_code; }

    public void setPostal_code(String postal_code) { this.postal_code = postal_code; }
}
