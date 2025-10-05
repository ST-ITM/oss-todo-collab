public class TodoItem {
    private final int id;
    private String title;
    private String description;
    private boolean done;

    public TodoItem(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String t) { this.title = t; }
    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }
    public boolean isDone() { return done; }
    public void setDone(boolean d) { this.done = d; }

    public String summary() {
        String status = done ? "DONE" : "OPEN";
        return "[" + status + "] " + id + " | " + title + " -- " + description;
    }
}
