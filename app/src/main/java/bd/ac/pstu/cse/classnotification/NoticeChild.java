package bd.ac.pstu.cse.classnotification;

public class NoticeChild {
    private String title;
    private String time;
    private String description;

    public NoticeChild(){

    }

    public NoticeChild(String title,String description,String time) {
        //super();
        this.title=title;
        this.description=description;
        this.time=time;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
