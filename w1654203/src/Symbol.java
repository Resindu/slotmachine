public class Symbol implements ISymbol {

    private int value;
    private String image;

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }


    public int compare(String imagePath){

        if(getImage().equals(imagePath)){
            return getValue();
        }
        else{
            return 0;
        }

    }

}

