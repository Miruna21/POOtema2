package Game;

public class Execute implements Ability{
    private final static int baseDamage = 200;
    private final static int plusDamagePerLevel = 30;

    private final static float RogueVictimModifier = 0.15f;
    private final static float KnightVictimModifier = 0;
    private final static float PyromancerVictimModifier = 0.1f;
    private final static float WizardVictimModifier = -0.2f;

    public float levelAndGroundDamage(Ground ground, Player attacker){
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = baseDamage + attackerLevel * plusDamagePerLevel;
        return levelDamage * landModifier;
    }

    @Override
    public void attack(Rogue rogue, Ground ground, Player attacker) {
        int maxVictimHpOnHerLevel = rogue.getInitialHp() + rogue.getLevel() * rogue.getPlusHpPerLevel();
        float hpLimit = 0.2f * maxVictimHpOnHerLevel + rogue.getLevel();
        if (rogue.getHp() < hpLimit){
            rogue.setDamageWithoutRaceModifier(Math.round(rogue.getHp()));
            rogue.setLife(false);
        } else {
            float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
            rogue.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
            int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + RogueVictimModifier));
            // modificare hp
            rogue.subHp(finalDamage);
        }
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, rogue);
    }

    @Override
    public void attack(Wizard wizard, Ground ground, Player attacker) {
        int maxVictimHpOnHerLevel = wizard.getInitialHp() + wizard.getLevel() * wizard.getPlusHpPerLevel();
        float hpLimit = 0.2f * maxVictimHpOnHerLevel + wizard.getLevel();
        if (wizard.getHp() < hpLimit){
            wizard.setDamageWithoutRaceModifier(Math.round(wizard.getHp()));
            wizard.setLife(false);
        } else {
            float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
            wizard.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
            int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + WizardVictimModifier));
            // modificare hp
            wizard.subHp(finalDamage);
        }
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, wizard);
    }

    @Override
    public void attack(Knight knight, Ground ground, Player attacker) {
        int maxVictimHpOnHerLevel = knight.getInitialHp() + knight.getLevel() * knight.getPlusHpPerLevel();
        float hpLimit = 0.2f * maxVictimHpOnHerLevel + knight.getLevel();
        if (knight.getHp() < hpLimit){
            knight.setDamageWithoutRaceModifier(Math.round(knight.getHp()));
            knight.setLife(false);
        } else {
            float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
            knight.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
            int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + KnightVictimModifier));
            // modificare hp
            knight.subHp(finalDamage);
        }
        // daca victima a murit, castigatorul va primi xp
        verifyVictimDead(attacker, knight);
    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker) {
        int maxVictimHpOnHerLevel = pyromancer.getInitialHp() + pyromancer.getLevel() * pyromancer.getPlusHpPerLevel();
        float hpLimit = 0.2f * maxVictimHpOnHerLevel + pyromancer.getLevel();
        if (pyromancer.getHp() < hpLimit){
            pyromancer.setDamageWithoutRaceModifier(Math.round(pyromancer.getHp()));
            pyromancer.setLife(false);
        } else {
            float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
            pyromancer.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
            int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + PyromancerVictimModifier));
            // modificare hp
            pyromancer.subHp(finalDamage);
        }
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
            attacker.gainXp(newXpWinner, attacker.getInitialHp(), attacker.getPlusHpPerLevel());
        }
    }
}
