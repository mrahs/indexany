package indexany;

import java.util.Objects;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.IntegerValidator;
import org.apache.commons.validator.routines.UrlValidator;

public class Column {

    public static final int TEXT = 0;
    public static final int LINK = 1;
    public static final int LINKS = 2;
    public static final int EMAIL = 3;
    public static final int EMAILS = 4;
    public static final int DATE = 5;
    public static final int INTEGER = 6;

    public static boolean validateInput(Column col, String in) {
        UrlValidator urlvalidator = new UrlValidator();
        EmailValidator emailvalidator = EmailValidator.getInstance();
        IntegerValidator intvalidator = new IntegerValidator();
        DateValidator datevalidator = new DateValidator();
        String[] tokens;

        switch (col.type) {
            case TEXT:
                if (col.required && in.isEmpty()) {
                    return false;
                }
                break;
            case LINK:
                if (!urlvalidator.isValid(in)) {
                    return false;
                }
                break;
            case LINKS:
                tokens = in.split("\\s");
                for (int i = 0; i < tokens.length; ++i) {
                    if (!urlvalidator.isValid(tokens[i])) {
                        return false;
                    }
                }
                break;
            case EMAIL:
                if (!emailvalidator.isValid(in)) {
                    return false;
                }
                break;
            case EMAILS:
                tokens = in.split("\\s");
                for (int i = 0; i < tokens.length; ++i) {
                    if (!emailvalidator.isValid(tokens[i])) {
                        return false;
                    }
                }
                break;
            case DATE:
                if (!datevalidator.isValid(in)) {
                    return false;
                }
                break;
            case INTEGER:
                if (!intvalidator.isValid(in)) {
                    return false;
                }
                break;
        }
        return true;
    }
    private String name;
    private int type;
    private boolean required;
    private boolean unique;
    private String defaultValue;

    public Column() {
        this("", TEXT, false, false, null);
    }

    public Column(String name) {
        this(name, TEXT, false, false, null);
    }

    public Column(String name, int type, boolean required, boolean unique, String defaultValue) {
        this.name = name;
        setType(type);
        this.required = required;
        this.unique = unique;
        this.defaultValue = defaultValue;
    }

    public Column(Column orig) {
        this.name = orig.name;
        this.type = orig.type;
        this.required = orig.required;
        this.unique = orig.unique;
        this.defaultValue = orig.defaultValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public final void setType(int type) {
        if (type < 0 || type > 6) {
            this.type = 0;
        } else {
            this.type = type;
        }
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public final void setDefaultValue(String defaultValue) {
        if (defaultValue != null) {
            if (!validateInput(this, defaultValue)) {
                // TODO
            } else {
                this.defaultValue = defaultValue;
            }
        } else {
            this.defaultValue = null;
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

        Column rhs = (Column) obj;

        return rhs.name.equals(name);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.name);
        return hash;
    }
}
