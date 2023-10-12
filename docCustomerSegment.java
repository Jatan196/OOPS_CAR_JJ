/*-----------------------PACKAGE-"car.package.customer"-------------------------------------------
-----------------------------interfaces and classes------------------------------------

1.carPart->class:-{tyre,seats,lights,corePart->{stirring,gearBox,engine,battery},airBags}

2.look->class:-{intLook, extLook}

3.price->{defaultPartPrice,specialPartPrice}

4.time->time

5.idGenerator->idGenerator

*/
interface carPart {
    void Grade(); /* A,B,C */

    void showSpecs(); /* BRAND , QUAITY , WARRANTY... */

    void priceRaise();

    void timeCharge();
}

interface look {
    void type();

    void priceRaise();

    void timeCharge();
}

interface time {
    void defaultModelTime();

    void specialModelTime(tyre t, seats s, lights l, corePart cp, airbags abg, idGenerator ig);

}

interface price {
    void defaultPartPrice();

    void specialPartPrice(tyre t, seats s, lights l, corePart cp, airbags abg, idGenerator ig);

}

interface idGenerator {
    // basic info attributes
    void bonusApplicable();

}

class tyre implements carPart {
    // attributes
    // overridden methods
}

class seats implements carPart {
    // attributes
    // overridden methods
}

class lights implements carPart {
    // attributes
    // overridden methods
}

class corePart implements carPart {
    // attributes
    // overridden methods
}

// ...stirring

// ...gearBox

// ...battery

// ...engine

class airbags implements carPart {
    // attributes
    // overridden methods
}
