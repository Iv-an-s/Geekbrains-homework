package part2.lesson1;

public class Course {
    Obstruction[] obstructions;

    public Course() {
        this.obstructions = new Obstruction[]{new RunningTrack(3000), new Wall(3)};
    }
    public Course(Obstruction[] obstructions){
        this.obstructions = obstructions;
    }

    public void doIt (Team team) {
        Participating[] participants = team.getParticipants();
        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstructions.length; j++) {
                if (obstructions[j] instanceof RunningTrack){
                    if (((Winner)participants[i]).isWin()) {
                        participants[i].run(obstructions[j]);
                    }else{
                        System.out.println(participants[i].getName() + " сошел с дистанции");
                    }
                }else if (obstructions[j] instanceof Wall) {
                    if (((Winner) participants[i]).isWin()) {
                        participants[i].jump((Wall) obstructions[j]);
                    } else {
                        System.out.println(participants[i].getName() + " сошел с дистанции");
                    }
                }
            }
        }
    }
}
