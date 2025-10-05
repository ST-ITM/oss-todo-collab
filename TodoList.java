import java.util.ArrayList;

public class TodoList {
    private final ArrayList<TodoItem> items = new ArrayList<TodoItem>();
    private int nextId = 1;

    public int add(String title, String description) {
        TodoItem t = new TodoItem(nextId, title, description);
        items.add(t);
        nextId++;
        return t.getId();
    }

    public boolean markDone(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.get(i).setDone(true);
                return true;
            }
        }
        return false;
    }

    public ArrayList<TodoItem> getItems() {
        return items;
    }

}
