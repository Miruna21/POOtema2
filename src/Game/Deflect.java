package Game;

public class Deflect implements Ability{
    private final static float basePercent = 0.35f;
    private final static float plusPercentPerLevel = 0.02f;

    private final static float RogueVictimModifier = 0.2f;
    private final static float KnightVictimModifier = 0.4f;
    private final static float PyromancerVictimModifier = 0.3f;
    @Override
    public void attack(Rogue rogue, Ground ground, Player attacker) {
        float damage = attacker.getDamageWithoutRaceModifier();
        float percent = basePercent + rogue.getLevel() * plusPercentPerLevel;
        float newPercent = percent + RogueVictimModifier * percent;
        int finalDamage = Math.round(newPercent * damage);
        // modificare hp
        rogue.subHp(finalDamage);
    }

    @Override
    public void attack(Wizard wizard, Ground ground, Player attacker) {

    }

    @Override
    public void attack(Knight knight, Ground ground, Player attacker) {
        float damage = attacker.getDamageWithoutRaceModifier();
        float percent = basePercent + knight.getLevel() * plusPercentPerLevel;
        float newPercent = percent + KnightVictimModifier * percent;
        int finalDamage = Math.round(newPercent * damage);
        // modificare hp
        knight.subHp(finalDamage);
    }

    @Override
    public void attack(Pyromancer pyromancer, Ground ground, Player attacker) {
        float damage = attacker.getDamageWithoutRaceModifier();
        float percent = basePercent + pyromancer.getLevel() * plusPercentPerLevel;
        float newPercent = percent + PyromancerVictimModifier * percent;
        int finalDamage = Math.round(newPercent * damage);
        // modificare hp
        pyromancer.subHp(finalDamage);
    }
}
