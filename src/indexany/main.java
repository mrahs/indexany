package indexany;

public class main {

    public static void main(String[] args) {
        Index index = new Index("bookmark");
        index.addColumn(new Column("url", Column.LINK, true, true, "http://www.abuhammzah.net/"));
        index.addColumn(new Column("title", Column.TEXT, true, false, "link"));

        Index index2 = new Index("people");
        index2.addColumn(new Column("name", Column.TEXT, true, false, null));

//        System.out.println(index.toSqlCreateTableStatement());

        // initialize
        DataAccessObject dao = new DataAccessObject("/home/abuhammzah/indexany2.sqlite");
        dao.connect();
        dao.executeSqlStatement(Sql.TAG_TABLE_SQL_CREATE_STATEMENT);
        dao.executeSqlStatement(Sql.INDEX_TABLE_SQL_CREATE_STATEMENT);
        dao.executeSqlStatement(Sql.GUI_COLUMN_TABLE_SQL_CREATE_STATEMENT);

        // save tables
        dao.executeSqlStatement(Sql.getIndexTableIndexEntry(index));
        dao.executeSqlStatement(Sql.getIndexGuiColumnsTableEntry(index));
        dao.executeSqlStatement(Sql.getIndexSqlCreateTable(index));
        dao.executeSqlStatement(Sql.getIndexTagmapSqlTable(index));

        dao.executeSqlStatement(Sql.getIndexTableIndexEntry(index2));
        dao.executeSqlStatement(Sql.getIndexGuiColumnsTableEntry(index2));
        dao.executeSqlStatement(Sql.getIndexSqlCreateTable(index2));
        dao.executeSqlStatement(Sql.getIndexTagmapSqlTable(index2));

        dao.disconnect();
    }
}
