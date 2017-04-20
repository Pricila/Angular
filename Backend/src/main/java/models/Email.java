package models;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;

/**
 * Created by PAVILION-DV6 on 10/4/2017.
 */
@Entity
@Table(name = "EMAIL", schema = "APP")
public class Email {
    @SequenceGenerator(name="Email_Seq", sequenceName="Email_Seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Email_Seq")
    private int email_id;
    @Nullable
    private int identification;
    @Nullable
    private String email;
    @Nullable
    private String email_type;


    public int getEmail_id() { return email_id; }

    public void setEmail_id(int email_id) { this.email_id = email_id; }

    @Basic
    public int getIdentification() { return identification; }

    public void setIdentification(int identification) { this.identification = identification; }

    @Basic
    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    @Basic
    public String getEmail_type() { return email_type; }

    public void setEmail_type(String email_type) { this.email_type = email_type; }
}
