public class Room {
    private String name;
    private String description;
    private Boolean northPassage;
    private Boolean southPassage;
    private Boolean westPassage;
    private Boolean eastPassage;
    private int numberRoom;

    public Room(){}

    public Room(String name, String description,
                Boolean northPassage, Boolean southPassage, Boolean westPassage,
                Boolean eastPassage, int numberRoom){
        setName(name);
        setDescription(description);
        setNorthPassage(northPassage);
        setSouthPassage(southPassage);
        setWestPassage(westPassage);
        setEastPassage(eastPassage);
        setNumberRoom(numberRoom);
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setNorthPassage(Boolean northPassage){
        this.northPassage = northPassage;
    }
    public void setSouthPassage(Boolean southPassage){
        this.southPassage = southPassage;
    }
    public void setWestPassage(Boolean westPassage){
        this.westPassage = westPassage;
    }
    public void setEastPassage(Boolean eastPassage){
        this.eastPassage = eastPassage;
    }
    public void setNumberRoom(int numberRoom){ this.numberRoom = numberRoom; }
    public String getName(){return name;}
    public String getDescription(){return description;}

    public Boolean getNorthPassage() {
        return northPassage;
    }

    public Boolean getSouthPassage() {
        return southPassage;
    }

    public Boolean getWestPassage() {
        return westPassage;
    }

    public Boolean getEastPassage() {
        return eastPassage;
    }
}
