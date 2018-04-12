package learnmore.projet.learnmore.Model;

/**
 * Created by khalil on 28/03/2018.
 */

public class Note {
    private String title;
    private String description;
    private String noteUrl;
    private String thumbnail;
    private String courseId;

    public Note() {
    }

    public Note(String title, String description, String noteUrl, String thumbnail) {
        this.title = title;
        this.description = description;
        this.noteUrl = noteUrl;
        this.thumbnail = thumbnail;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getNoteUrl() {
        return noteUrl;
    }

    public void setNoteUrl(String noteUrl) {
        this.noteUrl = noteUrl;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
