package pixelbattle.ultimates;

import pixelbattle.core.Fighter;
import pixelbattle.core.Ultimate;

/** TODO 8: ультимейт «Метеорит» — звичайний (іменований) клас. */
public class Meteor implements Ultimate {

    @Override
    public String getName() { return "Метеорит"; }

    @Override
    public String getDescription() { return "Кожному живому ворогу 20–30 шкоди"; }

    @Override
    public String activate(Fighter user, Fighter[] allies, Fighter[] enemies) {
        int total = 0;
        for (Fighter e : enemies) {
            if (e.isAlive()) {
                total += e.takeDamage(Fighter.random(20, 30));
            }
        }
        return user.getName() + " викликає Метеорит: " + total + " шкоди всім ворогам";
    }
}
