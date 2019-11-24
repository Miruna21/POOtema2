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
        int victimMaxHpOnHerLevel = Rogue.getInitialHp() + rogue.getLevel() * Rogue.getPlusHpPerLevel();
        float a = 0.3f * victimMaxHpOnHerLevel;
        float b = rogue.getHp();
        if (a < b){
            baseHp = a;
        } else {
            baseHp = b;
        }
        int finalDamage = Math.round(newPercent * baseHp);
        // modificare hp
        rogue.subHp(finalDamage);
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, rogue);
    }

    @Override
    public void attack(Wizard wizard, Ground ground, Player attacker) {
        float percent = basePercent + wizard.getLevel() * plusPercentPerLevel;
        float newPercent = percent + WizardVictimModifier * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = Wizard.getInitialHp() + wizard.getLevel() * Wizard.getPlusHpPerLevel();
        float a = 0.3f * victimMaxHpOnHerLevel;
        float b = wizard.getHp();
        if (a < b){
            baseHp = a;
        } else {
            baseHp = b;
        }
        int finalDamage = Math.round(newPercent * baseHp);
        // modificare hp
        wizard.subHp(finalDamage);
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, wizard);
    }

    @Override
    public void attack(Knight knight, Ground ground, Player attacker) {
        float percent = basePercent + knight.getLevel() * plusPercentPerLevel;
        float newPercent = percent + KnightVictimModifier * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = Knight.getInitialHp() + knight.getLevel() * Knight.getPlusHpPerLevel();
        float a = 0.3f * victimMaxHpOnHerLevel;
        float b = knight.getHp();
        if (a < b){
            baseHp = a;
        } else {
            baseHp = b;
        }
        int finalDamage = Math.round(newPercent * baseHp);
        // modificare hp
        knight.subHp(finalDamage);
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, knight);
    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker) {
        float percent = basePercent + pyromancer.getLevel() * plusPercentPerLevel;
        float newPercent = percent + PyromancerVictimModifier * percent;
        float baseHp;
        int victimMaxHpOnHerLevel = Pyromancer.getInitialHp() + pyromancer.getLevel() * Pyromancer.getPlusHpPerLevel();
        float a = 0.3f * victimMaxHpOnHerLevel;
        float b = pyromancer.getHp();
        if (a < b){
            baseHp = a;
        } else {
            baseHp = b;
        }
        int finalDamage = Math.round(newPercent * baseHp);
        // modificare hp
        pyromancer.subHp(finalDamage);
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, pyromancer);
    }
    public void verifyVictimDead(Player attacker, Player victim){
        if (!victim.getLife()){
            int max;
            int a = 0;
            int b = 200 - (attacker.getLevel() - victim.getLevel()) * 40;
            int xpWinner = attacker.getXp();
            int newXpWinner;
            if (a > b){
                max = a;
            } else {
                max = b;
            }
            newXpWinner = xpWinner + max;
            attacker.setHp(newXpWinner);
        }
    }
}
