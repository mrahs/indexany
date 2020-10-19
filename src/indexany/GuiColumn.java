package indexany;

public class GuiColumn extends Column {

    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;

    public GuiColumn() {
        super();
        x = 0;
        y = 0;
        width = 200;
        height = 30;
    }

    public GuiColumn(Integer x, Integer y, Integer width, Integer height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public GuiColumn(String name, int type, boolean required, boolean unique, String defaultValue) {
        super(name, type, required, unique, defaultValue);
        x = 0;
        y = 0;
        width = 200;
        height = 30;
    }

    public GuiColumn(Integer x, Integer y, Integer width, Integer height, String name, int type, boolean required, boolean unique, String defaultValue) {
        super(name, type, required, unique, defaultValue);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public GuiColumn(GuiColumn orig) {
        super(orig);
        this.x = orig.x;
        this.y = orig.y;
        this.height = orig.height;
        this.width = orig.width;
    }

    public GuiColumn(Column col) {
        super(col);
        x = 0;
        y = 0;
        width = 200;
        height = 30;
    }

    public GuiColumn(Column col, int x, int y, int w, int h) {
        super(col);
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public GuiColumn(String name) {
        super(name);
        x = 0;
        y = 0;
        width = 200;
        height = 30;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
