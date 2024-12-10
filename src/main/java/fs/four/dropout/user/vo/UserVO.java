package fs.four.dropout.user.vo;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component("userVO")
public class UserVO {

    private String usr_id;
    private String usr_password;
    private String usr_nickname;
    private String usr_email;
    private char usr_email_optout;
    private Date usr_join_date;
    private char usr_withdraw;
    private Timestamp usr_created_date;
    private String usr_updated_id;
    private Timestamp usr_updated_date;
    private String usr_image_name;
    private String usr_image_path;

    private String role;

    public UserVO() {

    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }

    public String getUsr_password() {
        return usr_password;
    }

    public void setUsr_password(String usr_password) {
        this.usr_password = usr_password;
    }

    public String getUsr_nickname() {
        return usr_nickname;
    }

    public void setUsr_nickname(String usr_nickname) {
        this.usr_nickname = usr_nickname;
    }

    public String getUsr_email() {
        return usr_email;
    }

    public void setUsr_email(String usr_email) {
        this.usr_email = usr_email;
    }

    public char getUsr_email_optout() {
        return usr_email_optout;
    }

    public void setUsr_email_optout(char usr_email_optout) {
        this.usr_email_optout = usr_email_optout;
    }

    public Date getUsr_join_date() {
        return usr_join_date;
    }

    public void setUsr_join_date(Date usr_join_date) {
        this.usr_join_date = usr_join_date;
    }

    public char getUsr_withdraw() {
        return usr_withdraw;
    }

    public void setUsr_withdraw(char usr_withdraw) {
        this.usr_withdraw = usr_withdraw;
    }

    public Timestamp getUsr_created_date() {
        return usr_created_date;
    }

    public void setUsr_created_date(Timestamp usr_created_date) {
        this.usr_created_date = usr_created_date;
    }

    public String getUsr_updated_id() {
        return usr_updated_id;
    }

    public void setUsr_updated_id(String usr_updated_id) {
        this.usr_updated_id = usr_updated_id;
    }

    public Timestamp getUsr_updated_date() {
        return usr_updated_date;
    }

    public void setUsr_updated_date(Timestamp usr_updated_date) {
        this.usr_updated_date = usr_updated_date;
    }

    public String getUsr_image_name() {
        return usr_image_name;
    }

    public void setUsr_image_name(String usr_image_name) {
        this.usr_image_name = usr_image_name;
    }

    public String getUsr_image_path() {
        return usr_image_path;
    }

    public void setUsr_image_path(String usr_image_path) {
        this.usr_image_path = usr_image_path;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
