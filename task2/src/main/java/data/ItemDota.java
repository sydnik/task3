package data;

public class ItemDota {
    private String fullName;
    private String rarity;
    private String hero;
    private String game;

    public ItemDota(String fullName, String rarity, String hero, String game) {
        this.fullName = fullName;
        this.rarity = rarity;
        this.hero = hero;
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemDota)) return false;

        ItemDota itemDota = (ItemDota) o;

        if (!fullName.equals(itemDota.fullName)) return false;
        if (!rarity.equals(itemDota.rarity)) return false;
        if (!hero.equals(itemDota.hero)) return false;
        return game.equals(itemDota.game);
    }

    @Override
    public int hashCode() {
        int result = fullName.hashCode();
        result = 31 * result + rarity.hashCode();
        result = 31 * result + hero.hashCode();
        result = 31 * result + game.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ItemDota{" +
                "fullName='" + fullName + '\'' +
                ", rarity='" + rarity + '\'' +
                ", hero='" + hero + '\'' +
                ", game='" + game + '\'' +
                '}';
    }
}
