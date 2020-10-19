
package indexany;

public class Sql {
    public static final String TAG_TABLE_SQL_CREATE_STATEMENT = "CREATE TABLE tag(id INTEGER NOT NULL UNIQUE PRIMARY KEY, "
            + "name VARCHAR(100) NOT NULL UNIQUE);";
    public static final String INDEX_TABLE_SQL_CREATE_STATEMENT = "CREATE TABLE indx(name VARCHAR(100) NOT NULL UNIQUE PRIMARY KEY, "
            + "primary_column_name VARCHAR(100), "
            + "table_name VARCHAR(100) NOT NULL UNIQUE);";
    public static final String GUI_COLUMN_TABLE_SQL_CREATE_STATEMENT = "CREATE TABLE gui_column(name VARCHAR(100) NOT NULL, "
            + "table_name VARCHAR(100) NOT NULL, "
            + "x INTEGER NOT NULL, "
            + "y INTEGER NOT NULL, "
            + "width INTEGER NOT NULL, "
            + "height INTEGER NOT NULL, "
            + "PRIMARY KEY (name, table_name));";
    
    public static String getIndexSqlCreateTable(Index index) {
        StringBuilder stmnt = new StringBuilder("CREATE TABLE ");
        stmnt.append(index.getSqlTitle()).append("(");
        stmnt.append("id INTEGER NOT NULL UNIQUE PRIMARY KEY, ");
        for (GuiColumn col : index.getColumns()) {
            stmnt.append(col.getName()).append(" ");
            if (col.getType() == Column.INTEGER) {
                stmnt.append("INTEGER ");
            } else if (col.getType() == Column.DATE) {
                stmnt.append("DATE ");
            } else {
                stmnt.append("VARCHAR(100) ");
            }
            if (col.isRequired()) {
                stmnt.append("NOT NULL ");
            }
            if (col.isUnique()) {
                stmnt.append("UNIQUE ");
            }
            stmnt.append("DEFAULT '").append(col.getDefaultValue()).append("', ");
        }
        stmnt.delete(stmnt.length() - 2, stmnt.length() - 1);
        stmnt.append(");");
        return stmnt.toString();
    }
    public static String getIndexTagmapSqlTable(Index index) {
        return "CREATE TABLE " + index.getSqlTitle() + "_tagmap(" + index.getSqlTitle() + "_id INTEGER, "
                + "tag_id INTEGER, FOREIGN KEY (" + index.getSqlTitle() + "_id) REFERENCES " + index.getSqlTitle() + "(id), "
                + "FOREIGN KEY (tag_id) REFERENCES tag(id));";
    }
    public static String getIndexGuiColumnsTableEntry(Index index) {
        String prefix = "INSERT INTO gui_column (name, table_name, x, y, width, height) values (";
        String suffix = "); ";
        StringBuilder stmnt = new StringBuilder();

        for (GuiColumn col : index.getColumns()) {
            stmnt.append(prefix);
            stmnt.append("'").append(col.getName()).append("', ");
            stmnt.append("'").append(index.getSqlTitle()).append("', ");
            stmnt.append(col.getX()).append(", ");
            stmnt.append(col.getY()).append(", ");
            stmnt.append(col.getWidth()).append(", ");
            stmnt.append(col.getHeight());
            stmnt.append(suffix);
        }

        return stmnt.toString();
    }
    public static String getIndexTableIndexEntry(Index index) {
        return "INSERT INTO indx(name, primary_column_name, table_name) values ('"
                + index.getTitle() + "', '" + index.getPrimaryColumnName() + "', '" + index.getSqlTitle() + "');";
    }
}
