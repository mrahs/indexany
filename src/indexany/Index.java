package indexany;

import java.util.HashSet;
import java.util.Set;

public class Index {

    private String title;
    private Set<GuiColumn> columns;
    private String primaryColumnName;

    public Index(String title) {
        setTitle(title);
        this.columns = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public final void setTitle(String title) {
        if (title == null) {
            title = "NoN";
        }
        this.title = title;
    }

    public String getSqlTitle() {
        return title.replaceAll("\\s", "_");
    }

    public String getPrimaryColumnName() {
        return primaryColumnName;
    }

    public void setPrimaryColumnName(String primaryColumnName) {
        if (columns.contains(new GuiColumn(primaryColumnName))) {
            this.primaryColumnName = primaryColumnName;
        } else {
            throw new RuntimeException("column \"" + primaryColumnName + "\" does not exist!");
        }
    }

    public Set<GuiColumn> getColumns() {
        return columns;
    }

    public void setColumns(Set<GuiColumn> columns) {
        this.columns = columns;
    }

    public void addColumn(Column col, int x, int y, int w, int h) {
        columns.add(new GuiColumn(col, x, y, w, h));
    }

    public void addColumn(Column col) {
        addColumn(col, 0, 0, 200, 30);
    }

    public void removeColumn(String name) {
        columns.remove(new GuiColumn(name));
    }

    public void removeColumn(Column col) {
        removeColumn(col.getName());
    }

    public int getColumnsCount() {
        return columns.size();
    }

    public boolean hasColumn(String colName) {
        return columns.contains(new GuiColumn(colName));
    }
}
