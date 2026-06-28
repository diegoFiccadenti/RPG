package mechanics;

import entities.Fighter;

public interface Attack {

    void use(Fighter user, Fighter target);

    String getName();

    int getPower();
}
