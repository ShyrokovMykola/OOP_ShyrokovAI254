package pixelbattle.heroes;

import pixelbattle.core.Fighter;
import pixelbattle.core.Hero;
import pixelbattle.core.Skill;
import pixelbattle.core.Target;
import pixelbattle.core.Ultimate;
import pixelbattle.engine.Sprite;

/** Лучниця — швидка й спритна. */
public class Archer extends Hero {

    public Archer() {
        super("Лучниця", 80, new Sprite("elf_f_idle_anim", 4, 4));

        addSkill(new Skill("Постріл", Target.ENEMY, 0, (user, target) ->
                user.getName() + " стріляє в " + target.getName() + ": "
                        + target.takeDamage(random(10, 16)) + " шкоди"));

        // TODO 3: «Подвійний постріл» — два постріли, у журнал сума шкоди
        addSkill(new Skill("Подвійний постріл", Target.ENEMY, 1, (user, target) -> {
            int total = target.takeDamage(random(7, 11));
            total += target.takeDamage(random(7, 11));
            return user.getName() + " робить подвійний постріл у " + target.getName() + ": "
                    + total + " шкоди";
        }));

        // TODO 9: ультимейт «Злива стріл» — анонімний клас з полем-лічильником
        setUltimate(new Ultimate() {
            private int arrows = 3;   // скільки стріл на ворога при наступному використанні

            @Override
            public String getName() { return "Злива стріл"; }

            @Override
            public String getDescription() {
                return "Кожен живий ворог отримує " + arrows + " стріл по 4–8 шкоди (щоразу на 1 більше)";
            }

            @Override
            public String activate(Fighter user, Fighter[] allies, Fighter[] enemies) {
                int n = arrows;
                int total = 0;
                for (Fighter e : enemies) {
                    for (int i = 0; i < n && e.isAlive(); i++) {
                        total += e.takeDamage(Fighter.random(4, 8));
                    }
                }
                arrows++;
                return user.getName() + " випускає зливу стріл (" + n + " на ворога): "
                        + total + " шкоди";
            }
        });
    }

    // TODO 5: пасивка «Ухилення» — 25% шанс не отримати шкоди
    @Override
    protected int modifyIncomingDamage(int damage) {
        return chance(25) ? 0 : damage;
    }
}
