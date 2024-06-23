package models;

public record Moneda(String conversion_rate) {
    @Override
    public String toString() {
        return "$" + conversion_rate;
    }
}
