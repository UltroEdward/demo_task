package pages.product;

public enum FilterBy {
    PRICE_FROM_LOW("Price Low to High");

    private String textValue;

    FilterBy(String textValue) {
        this.textValue = textValue;
    }

    public String getText() {
        return textValue;
    }
}
