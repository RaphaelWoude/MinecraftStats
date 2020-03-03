package org.sympatic.minecraftstats.file;

import org.sympatic.minecraftstats.MinecraftStats;

public class ProfileFile extends AbstractFile {

    /**
     * Constructor.
     *
     * @param minecraftStats Main.
     * @param filePath File path.
     * @param fileName File name.
     */
    public ProfileFile(MinecraftStats minecraftStats, String filePath, String fileName) {
        super(minecraftStats, filePath, fileName);
    }

    /**
     * Generates the defaults in profile file.
     */
    public void generateDefaults() {
        if (getConfig().get("kills") == null) getConfig().set("kills", 0);
        if (getConfig().get("deaths") == null) getConfig().set("deaths", 0);
        if (getConfig().get("playtime") == null) getConfig().set("playtime", 0);
        if (getConfig().get("quartz") == null) getConfig().set("quartz", 0);
        if (getConfig().get("emeralds") == null) getConfig().set("emeralds", 0);
        if (getConfig().get("diamonds") == null) getConfig().set("diamonds", 0);
        if (getConfig().get("redstone") == null) getConfig().set("redstone", 0);
        if (getConfig().get("lapis") == null) getConfig().set("lapis", 0);
        if (getConfig().get("diamonds") == null) getConfig().set("diamonds", 0);
        if (getConfig().get("gold") == null) getConfig().set("gold", 0);
        if (getConfig().get("iron") == null) getConfig().set("iron", 0);
        if (getConfig().get("coal") == null) getConfig().set("coal", 0);
    }

    /**
     * Gets the kills of the player profile.
     *
     * @return Kills of player profile.
     */
    public int getKills() {
        return getConfig().getInt("kills");
    }

    /**
     * Gets the deaths of the player profile.
     *
     * @return Deaths of player profile.
     */
    public int getDeaths() {
        return getConfig().getInt("deaths");
    }

    /**
     * Sets the kills for the player profile.
     *
     * @param kills Kills for player profile.
     */
    public void setKills(int kills) {
        getConfig().set("kills", kills);
    }

    /**
     * Sets the deaths for the player profile.
     *
     * @param deaths Deaths for player profile.
     */
    public void setDeaths(int deaths) {
        getConfig().set("deaths", deaths);
    }

    /**
     * Gets the playtime for the player profile
     *
     * @return Playtime of player profile.
     */
    public int getPlaytime() {
        return getConfig().getInt("playtime");
    }

    /**
     * Sets the playtime for the player profile.
     *
     * @param playtime Playtime for player profile.
     */
    public void setPlaytime(int playtime) {
        getConfig().set("playtime", playtime);
    }

    /**
     * Gets the quartz for the player profile
     *
     * @return Quartz of player profile.
     */
    public int getQuartz() {
        return getConfig().getInt("quartz");
    }

    /**
     * Sets the quartz for the player profile.
     *
     * @param quartz Quartz for player profile.
     */
    public void setQuartz(int quartz) {
        getConfig().set("quartz", quartz);
    }

    /**
     * Gets the emeralds for the player profile
     *
     * @return Emeralds of player profile.
     */
    public int getEmeralds() {
        return getConfig().getInt("emeralds");
    }

    /**
     * Sets the emeralds for the player profile.
     *
     * @param emeralds Emeralds for player profile.
     */
    public void setEmeralds(int emeralds) {
        getConfig().set("emeralds", emeralds);
    }

    /**
     * Gets the diamonds for the player profile
     *
     * @return Diamonds of player profile.
     */
    public int getDiamonds() {
        return getConfig().getInt("diamonds");
    }

    /**
     * Sets the diamonds for the player profile.
     *
     * @param diamonds Diamonds for player profile.
     */
    public void setDiamonds(int diamonds) {
        getConfig().set("diamonds", diamonds);
    }

    /**
     * Gets the redstone for the player profile
     *
     * @return Redstone of player profile.
     */
    public int getRedstone() {
        return getConfig().getInt("redstone");
    }

    /**
     * Sets the redstone for the player profile.
     *
     * @param redstone Redstone for player profile.
     */
    public void setRedstone(int redstone) {
        getConfig().set("redstone", redstone);
    }

    /**
     * Gets the lapis for the player profile
     *
     * @return Lapis of player profile.
     */
    public int getLapis() {
        return getConfig().getInt("lapis");
    }

    /**
     * Sets the lapis for the player profile.
     *
     * @param lapis Lapis for player profile.
     */
    public void setLapis(int lapis) {
        getConfig().set("lapis", lapis);
    }

    /**
     * Gets the gold for the player profile
     *
     * @return Gold of player profile.
     */
    public int getGold() {
        return getConfig().getInt("gold");
    }

    /**
     * Sets the gold for the player profile.
     *
     * @param gold Gold for player profile.
     */
    public void setGold(int gold) {
        getConfig().set("gold", gold);
    }

    /**
     * Gets the iron for the player profile
     *
     * @return Iron of player profile.
     */
    public int getIron() {
        return getConfig().getInt("iron");
    }

    /**
     * Sets the gold for the player profile.
     *
     * @param iron Gold for player profile.
     */
    public void setIron(int iron) {
        getConfig().set("iron", iron);
    }

    /**
     * Gets the coal for the player profile
     *
     * @return Coal of player profile.
     */
    public int getCoal() {
        return getConfig().getInt("coal");
    }

    /**
     * Sets the coal for the player profile.
     *
     * @param coal Coal for player profile.
     */
    public void setCoal(int coal) {
        getConfig().set("coal", coal);
    }

}
