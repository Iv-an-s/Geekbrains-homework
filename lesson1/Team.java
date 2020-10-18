package part2.lesson1;

public class Team {
    String teamName;
    Participating [] participants;

    public Team(){
        this.teamName = "Team";
        participants = new Participating[4];
        participants[0] = new Person("Vasya", 3, 3000);
        participants[1] = new Person("Anya", 2, 5000);
        participants[2] = new Cat ("Pushok", 3, 2000);
        participants[3] = new Robot("Werder", 1, 42000);
    }

    public String getTeamName() {
        return teamName;
    }

    public Participating[] getParticipants() {
        return participants;
    }

    public Team(String name){
        new Team();
        this.teamName = name;
    }

    public Team(String teamName, Participating[] participants) {
        this.teamName = teamName;
        this.participants = participants;
    }

    public void showResults(){
        for (int i = 0; i < participants.length; i++) {
            if (participants[i] instanceof Winner){
                if (((Winner)participants[i]).isWin()){
                    System.out.println(participants[i].getName() + " успешно прошел полосу препятствий!");
                }
            }
        }
    }
}
