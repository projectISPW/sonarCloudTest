package progettoispw.letmeknow;


public class Factory {
    public Page createPage(){
        return new Page();
    }
    public PageMenu createPageMenu(){
        return new PageMenu();
    }
}