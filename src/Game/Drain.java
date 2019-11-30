package Game;

public class Drain implements Ability{
    private final static float basePercent = 0.2f;
    private final static float plusPercentPerLevel = 0.05f;

    private final static float RogueVictimModifier = -0.2f;
    private final static float KnightVictimModifier = 0.2f;
    private final static float PyromancerVictimModifier = -0.1f;
    private final static float WizardVictimModifier = 0.05f;
    @Override
    public void attack(Rogue rogue, Ground ground, Player attacker) {
        float percent = basePercent + rogue.getLevel() * plusPercentPerLevel;
        float newPercent = percent + RogueVictimModifier * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = rogue.getInitialHp() + rogue.getLevel() * rogue.getPlusHpPerLevel();
        float a = 0.3f * victimMaxHpOnHerLevel;
        float b = rogue.getHp();
        if (a < b){
            baseHp = a;
        } else {
            baseHp = b;
        }
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(Wizard wizard, Ground ground, Player attacker) {
        float percent = basePercent + wizard.getLevel() * plusPercentPerLevel;
        float newPercent = percent + WizardVictimModifier * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = wizard.getInitialHp() + wizard.getLevel() * wizard.getPlusHpPerLevel();
        float a = 0.3f * victimMaxHpOnHerLevel;
        float b = wizard.getHp();
        if (a < b){
            baseHp = a;
        } else {
            baseHp = b;
        }
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        // modificare hp
        wizard.subHp(finalDamage);
    }

    @Override
    public void attack(Knight knight, Ground ground, Player attacker) {
        float percent = basePercent + knight.getLevel() * plusPercentPerLevel;
        float newPercent = percent + KnightVictimModifier * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = knight.getInitialHp() + knight.getLevel() * knight.getPlusHpPerLevel();
        float a = 0.3f * victimMaxHpOnHerLevel;
        float b = knight.getHp();
        if (a < b){
            baseHp = a;
        } else {
            baseHp = b;
        }
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        //System.out.println("drain");
        //System.out.println(finalDamage);
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker) {
        float percent = basePercent + pyromancer.getLevel() * plusPercentPerLevel;
        float newPercent = percent + PyromancerVictimModifier * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = pyromancer.getInitialHp() + pyromancer.getLevel() * pyromancer.getPlusHpPerLevel();
        float a = 0.3f * victimMaxHpOnHerLevel;
        float b = pyromancer.getHp();
        if (a < b){
            baseHp = a;
        } else {
            baseHp = b;
        }
        float landModifier = attacker.acceptLandModifier(ground);
        int finalDamage = Math.round(newPercent * baseHp * landModifier);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
