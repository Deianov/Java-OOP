//03. Players and Monsters
package C_Inheritance.Exercises.PlayersAndMonsters;

import C_Inheritance.Exercises.PlayersAndMonsters.hero.BladeKnight;
import C_Inheritance.Exercises.PlayersAndMonsters.hero.Hero;
import C_Inheritance.Exercises.PlayersAndMonsters.hero.MuseElf;
import C_Inheritance.Exercises.PlayersAndMonsters.hero.SoulMaster;

public class Main {
    public static void main(String[] args) {

        Hero museElf = new MuseElf("elf", 1);
        Hero soulMaster = new SoulMaster("master", 2);
        Hero bladeKnight = new BladeKnight("blade", 3);

        System.out.println(museElf.toString());
        System.out.println(soulMaster.toString());
        System.out.println(bladeKnight.toString());
    }
}
