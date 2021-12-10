package Data;

public class Game {
    private String name;
    private String date;
    private String price;

    public Game(String name, String date, String price) {
        this.name = name;
        this.date = date;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;

        Game game = (Game) o;

        if (!name.equals(game.name)) return false;
        if (!date.equals(game.date)) return false;
        return price.equals(game.price);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + date.hashCode() + price.hashCode();
    }
}
