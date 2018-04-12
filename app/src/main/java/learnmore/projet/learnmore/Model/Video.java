package learnmore.projet.learnmore.Model;

/**
 * Created by khalil on 27/03/2018.
 */

public class Video {
    private String title;
    private String time;
    private String description;
    private String videoUrl;
    private String thumbnail;
    private String courseId;


    public Video() {

    }

    public Video(String title, String description, String videoUrl, String thumbnail) {
        this.title = title;
        this.description = description;
        this.videoUrl = videoUrl;
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Video(String title, String description, String videoUrl) {


        this.title = title;
        this.description = description;
        this.videoUrl = videoUrl;
    }
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   }
