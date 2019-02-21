public enum Fruit {
    LEMON,
    ORANGE,
    MANDARIN;

    public static Fruit getFruit(String line) {
        try {
            return Fruit.valueOf(line);
        } catch (Exception e) {
            return null;
        }
    }
}
