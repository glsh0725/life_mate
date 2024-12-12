package fs.four.dropout.community.vo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("communityWriteVO")
public class CommunityWriteVO {

    private Number com_post_number;
    private String com_title;
    private String com_thumbnail_name;
    private String com_thumbnail_path;
    private String com_location;
    private String com_duration;
    private String com_image_name;
    private String com_image_path;
    private String com_video_name;
    private String com_video_path;
    private String com_content;
    private String usr_id;
    @DateTimeFormat(pattern = "YYYY-MM-DD")
    private Date com_post_date;

    public CommunityWriteVO() {

    }

    public Number getCom_post_number() {
        return com_post_number;
    }

    public void setCom_post_number(Number com_post_number) {
        this.com_post_number = com_post_number;
    }

    public String getCom_title() {
        return com_title;
    }

    public void setCom_title(String com_title) {
        this.com_title = com_title;
    }

    public String getCom_thumbnail_name() {
        return com_thumbnail_name;
    }

    public void setCom_thumbnail_name(String com_thumbnail_name) {
        this.com_thumbnail_name = com_thumbnail_name;
    }

    public String getCom_thumbnail_path() {
        return com_thumbnail_path;
    }

    public void setCom_thumbnail_path(String com_thumbnail_path) {
        this.com_thumbnail_path = com_thumbnail_path;
    }

    public String getCom_location() {
        return com_location;
    }

    public void setCom_location(String com_location) {
        this.com_location = com_location;
    }

    public String getCom_duration() {
        return com_duration;
    }

    public void setCom_duration(String com_duration) {
        this.com_duration = com_duration;
    }

    public String getCom_image_name() {
        return com_image_name;
    }

    public void setCom_image_name(String com_image_name) {
        this.com_image_name = com_image_name;
    }

    public String getCom_image_path() {
        return com_image_path;
    }

    public void setCom_image_path(String com_image_path) {
        this.com_image_path = com_image_path;
    }

    public String getCom_video_name() {
        return com_video_name;
    }

    public void setCom_video_name(String com_video_name) {
        this.com_video_name = com_video_name;
    }

    public String getCom_video_path() {
        return com_video_path;
    }

    public void setCom_video_path(String com_video_path) {
        this.com_video_path = com_video_path;
    }

    public String getCom_content() {
        return com_content;
    }

    public void setCom_content(String com_content) {
        this.com_content = com_content;
    }

    public Date getCom_post_date() {
        return com_post_date;
    }

    public void setCom_post_date(Date com_post_date) {
        this.com_post_date = com_post_date;
    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }
}
