import java.util.Random;
public class FluffyDescriptions {
    Random random = new Random();
    private String[] color = {"blue", "green", "yellow", "purple", "red"};
    private String[] areaType = {"in a cave", "in a grotto", "looking over a lake", "too close for comfort to a pool of lava", "a muddy area", "on a stone chess board floor"};
    private String[] action = {"hanging from the ceiling", "growing on the walls", "floating mysteriously in the air", "swinging from outcroppings near the ceiling"};
    private String[] decoration = {"mushrooms", "fungus", "rocks", "skulls", "webby stuff"};

    public void setColor(String[] color){
        this.color = color;
    }

    public FluffyDescriptions(){};

    public String toString(){
        return "You stand " + areaType[random.nextInt(areaType.length)] + " where " + color[random.nextInt(color.length)] +
                " " + decoration[random.nextInt(decoration.length)] + " are " + action[random.nextInt(action.length)] + ".";
    }
}
