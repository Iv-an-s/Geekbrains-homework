package part2.lesson1;

public class Person extends Winner implements Participating{
    String name;
    int jumpAbility;
    int runAbility;

    public int getJumpAbility() {
        return jumpAbility;
    }

    @Override
    public int getRunAbility() {
        return runAbility;
    }

    public Person(String name, int jumpAbility, int runAbility) {
        this.name = name;
        if (jumpAbility >0) {
            this.jumpAbility = jumpAbility;
        }else{
            this.jumpAbility = 0;
        }
        if (runAbility > 0) {
            this.runAbility = runAbility;
        }else{
            this.runAbility = 0;
        }
    }

    public void jump(Wall wall){
        if (jumpAbility >= wall.getSize()){
            System.out.println(name + " jumped successfully");
            setWin(true);
        } else{
            System.out.println("The wall is too high." + name + " can't jump over the wall.");
            setWin(false);
        }
    }

    public void run(Obstruction obstruction){
        if (runAbility >= obstruction.getSize()) {
            System.out.println(name + "'s overcome " + obstruction.getClass().getSimpleName() + " successfully");
            setWin(true);
        }else{
            System.out.println(name + " can't overcome this " + obstruction.getClass().getSimpleName()
                    + ". It is too big");
            setWin(false);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
