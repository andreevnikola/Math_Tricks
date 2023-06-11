package math.tricks.Bot;


import lombok.NoArgsConstructor;

import java.util.Scanner;

enum SkillLevel {
    NOOB, MID, PRO
}

@NoArgsConstructor
public class Bot {

    SkillLevel skillLevel;

    public Bot generate() {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream

        System.out.print("Enter the skill level of the BOT \n - 1. Nooby \n - 2. Medium \n - 3. Gigga \nSkill level: ");
        String skillLevel = sc.nextLine();

        switch (skillLevel) {
            case "Nooby":
                this.skillLevel = SkillLevel.NOOB;
                break;

            case "Medium":
                this.skillLevel = SkillLevel.MID;
                break;

            case "Gigga":
                this.skillLevel = SkillLevel.PRO;
                break;

            default:
                System.out.println("Please choose a valid option (Nooby / Medium / Gigga)");
                this.generate();
                break;
        }

        return this;
    }
}
