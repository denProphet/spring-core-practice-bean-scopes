import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private String name;
    private List<Cat> catList;

    public Zoo(String name, List<Cat> catList) {
        this.name = name;
        this.catList = catList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cat> getCatList() {
        return catList;
    }

    public void setCatList(List<Cat> catList) {
        this.catList = catList;
    }

    public void showCats(){
        for (Cat cat : catList) {
            System.out.println("{ ");
            cat.showCatInfo();
            System.out.println(" }");
        }
    }
}
