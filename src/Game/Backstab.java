package Game;

public class Backstab implements Ability{
    private final static int baseDamage = 200;
    private final static int plusDamagePerLevel = 20;

    private final static float RogueVictimModifier = 0.2f;
    private final static float KnightVictimModifier = -0.1f;
    private final static float PyromancerVictimModifier = 0.25f;
    private final static float WizardVictimModifier = 0.25f;

    private float levelAndGroundDamage(Ground ground, Player attacker){
        float landModifier = attacker.acceptLandModifier(ground);
        int attackerLevel = attacker.getLevel();
        float levelDamage = baseDamage + attackerLevel * plusDamagePerLevel;
        float criticalHit = 1f;
        // critical hit o data la 3 lovituri daca se afla pe Woods
        if ((attacker.getNrBackstabHit() % 3 == 0) && (ground instanceof Woods)){
            criticalHit = 1.5f;
        }
        attacker.addNrBackstabHit(1);
        //System.out.println(levelDamage + " " + criticalHit + " " + landModifier);
        return levelDamage * criticalHit * landModifier;
    }

    @Override
    public void attack(Rogue rogue, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        rogue.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + RogueVictimModifier));
        // modificare hp
        rogue.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }

    @Override
    public void attack(Wizard wizard, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        wizard.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + WizardVictimModifier));
        // modificare hp
        wizard.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }

    @Override
    public void attack(Knight knight, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        knight.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + KnightVictimModifier));
        // modificare hp
        knight.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker) {
        float damageWithoutRaceModifier = levelAndGroundDamage(ground, attacker);
        pyromancer.setDamageWithoutRaceModifier(Math.round(damageWithoutRaceModifier));
        int finalDamage = Math.round(Math.round(damageWithoutRaceModifier) * (1 + PyromancerVictimModifier));
        // modificare hp
        //System.out.println(finalDamage);
        pyromancer.subHp(finalDamage);
        attacker.addNrBackstabHit(1);
    }
}
