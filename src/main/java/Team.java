public class Team implements TeamType{
    String name =  "";
    String cityname = "";
    Player[] listPlayers = new Player[11];

    public Team(String name, String cityname, Player[] listPlayers) {
        this.name = name;
        this.cityname = cityname;
        this.listPlayers = listPlayers;
    }

    public Team(String name) {
        this.name = name;
    }

    public void setPlayers(Player[] listejoueurs) {
        this.listPlayers = listejoueurs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String cityname) {
        this.cityname = cityname;
    }

    public String getFullName() {
        return this.name;
    }
}
