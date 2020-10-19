package indexany;

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import java.io.File;
import java.util.Objects;

public class DataAccessObject {

    private File dbFilePath;
    private SQLiteConnection dbcon;

    public DataAccessObject() {
        dbFilePath = null;
    }

    public DataAccessObject(File dbFilePath) {
        this.dbFilePath = dbFilePath;
    }

    public DataAccessObject(String filePath) {
        this.dbFilePath = new File(filePath);
    }

    public File getDbFilePath() {
        return dbFilePath;
    }

    public void setDbFilePath(File dbFilePath) {
        this.dbFilePath = dbFilePath;
    }

    public void connect() {
        if (dbFilePath.isDirectory()) {
            dbFilePath = new File(dbFilePath.getPath() + "my_indeces.ia");
        }
        dbcon = new SQLiteConnection(dbFilePath);
        try {
            dbcon.open(!dbFilePath.exists());
        } catch (SQLiteException ex) {
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        dbcon.dispose();
    }

    public void executeSqlStatement(String sqlStatement) {
        try {
            dbcon.exec(sqlStatement);
        } catch (SQLiteException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj.getClass() != getClass()) {
            return false;
        }
        
        DataAccessObject rhs = (DataAccessObject)obj;
        
        return rhs.dbFilePath.equals(dbFilePath);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.dbFilePath);
        return hash;
    }
}
