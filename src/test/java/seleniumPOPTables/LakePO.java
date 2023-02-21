package seleniumPOPTables;

public class LakePO {
    String name;
    String country;
    String area;
    int lp;


    public LakePO(String name, String country, String area, int lp) {
        this.name = name;
        this.country = country;
        this.area = area;
        this.lp = lp;
    }

    public String getCountry() {
        return country;
    }

    public String getArea() {
        return area;
    }

    public int getLp() {
        return lp;
    }

}
