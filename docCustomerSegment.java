/*-----------------------PACKAGE-"car.package.customer"-------------------------------------------*/
//COPYRIGHT NOTICE-> CAR MANFACTURING FIRM -> JATAN TANDON*(OWNER OF PACKAGE) , JAY PATEL (CONTIBUTER FOR PACKAGE)

import java.lang.String;
//import java.util.Scanner;

interface carPart {
    // ATTRIBUTES

    // METHODS
    // char grade(); /* A,B,C */

    // void showSpecs(); /* BRAND , QUAITY , WARRANTY... */

    int priceRaise(int deafultPrice);

    int timeCharge(int deafultPrice);
}

abstract class primary implements carPart {
    char grade; // GRADE OF QUALIY
    String brandModel;
    int warranty; // In no of months

    static public double gradingP(char grade) {
        double ans;
        switch (grade) {
            case 'A':
                ans = 1.5;
                break;
            case 'B':
                ans = 1.2;
                break;
            case 'C':
                ans = 0.8;
                break;

            default:
                ans = 0;
        }
        return ans;
    }

    static public double gradingT(char grade) {// in hours
        double ans;
        switch (grade) {
            case 'A':
                ans = 1.7;
                break;

            case 'B':
                ans = 1.2;
                break;

            case 'C':
                ans = 0.9;
                break;

            default:
                ans = 0;

        }
        return ans;
    }

    static public double segmentP(String segment) {
        double ans;
        switch (segment) {
            case "SUV":
                ans = 1.5;
                break;
            case "AVERAGE":
                ans = 1.2;
                break;
            case "HATCHBACK":
                ans = 0.8;
                break;

            default:
                ans = 0;
        }
        return ans;
    }

    static public double segmentT(String segment) {
        double ans;
        switch (segment) {
            case "SUV":
                ans = 1.7;
                break;
            case "AVERAGE":
                ans = 1.2;
                break;
            case "HATCHBACK":
                ans = 0.9;
                break;

            default:
                ans = 0;
        }
        return ans;
    }

}

/*--------------------------------CORE PART-{ TYRE, STIRRING , ENGINE } ----------------------------*/

class corePart extends primary {
    String corePartSegment = new String();

    // BOOLEAN customised = false;

    corePart() {
        this.grade = 'B';
        this.corePartSegment = "AVERAGE";// HATCHBACK , SUV

    }

    // this will be called only if customer wants to customise
    corePart(char grade, String corePartSegment) {
        this.grade = grade;
        this.corePartSegment = corePartSegment;
        // customised = true;
    }

    public int priceRaise(int deafultPrice) {
        // if (1) {
        // According to SUV dimension
        deafultPrice *= segmentP(corePartSegment) + gradingP(this.grade);
        // }
        return deafultPrice;
    }

    public int timeCharge(int deafultTime) {

        // if (1) {
        // According to SUV dimension
        deafultTime *= gradingT(this.grade) + segmentT(corePartSegment);
        // }
        return deafultTime;

    }
}

class auxillaryPart extends primary {
    String auxillaryPartSegment;// months

    // BOOLEAN customised = false;

    auxillaryPart() {
        this.grade = 'B';
        this.auxillaryPartSegment = "AVERAGE";// HATCHBACK , SUV , AVERAGE-> COMPACT SUV / PREMIUM HATCHBACK

    }

    // this will be called only if customer wants to customise
    auxillaryPart(char grade, String auxillaryPartSegment) {
        this.grade = grade;
        this.auxillaryPartSegment = auxillaryPartSegment;
        // customised = true;
    }

    public int priceRaise(int deafultPrice) {
        // if (customised) {
        // According to SUV dimension + quality grading
        deafultPrice *= 1.27 + gradingP(this.grade) - 0.1 + segmentP(auxillaryPartSegment) - 0.1;
        // }
        return deafultPrice;

    }

    public int timeCharge(int deafultTime) {

        // if (customised) {
        // According to SUV dimension + quality grading
        deafultTime *= gradingT(this.grade) + segmentT(auxillaryPartSegment);
        // }
        return deafultTime;

    }

}

interface look {
    // void type();

    int priceRaise(int price);

    int timeCharge(int price);
}

class interior implements look {
    String intLook; // Classic / Rolls Royac / Volvo

    interior() {
        this.intLook = "Classic";
    }

    interior(String intLook) {
        this.intLook = intLook;
    }

    public int priceRaise(int defaultPrice) {
        if (this.intLook == "Rolls Royac") {
            defaultPrice *= 1.6;
        } else if (this.intLook == "Volvo") {
            defaultPrice *= 1.7;
        }
        return defaultPrice;
    }

    public int timeCharge(int defaultPrice) {
        if (this.intLook == "Rolls Royac") {
            defaultPrice *= 1.5;
        } else if (this.intLook == "Volvo") {
            defaultPrice *= 1.6;
        }
        return defaultPrice;
    }
}

interface time {
    void defaultCarTime();

    void customisedCarTime(car C);

}

class timing implements time {
    int timeReq = 0;

    public void defaultCarTime() {

        // ALL OF B GRADE QUALTIY FOR AVERAGE
        // CORE PART
        this.timeReq += 12;//
        // AUX PART
        this.timeReq += 8;//
        // INTERIOR LOOK CLASSIC
        this.timeReq += 8;
    }

    public void customisedCarTime(car C) {
        this.timeReq = C.AXP.timeCharge(this.timeReq) + C.COP.timeCharge(this.timeReq) + C.INT.timeCharge(this.timeReq)
                - 2 * this.timeReq;
        // ereturn this.timeReq;
    }

}

interface price {

    void defaultCarPrice();

    void customisedCarPrice(car C);

}

class pricing implements price {
    int priceReq = 0;

    public void defaultCarPrice() {
        this.priceReq = 0;
        // ALL OF B GRADE QUALTIY FOR AVERAGE
        // CORE PART
        this.priceReq += 700000;// 7 LAKHS
        // AUX PART
        this.priceReq += 400000;// 4 LAKHS
        // INTERIOR LOOK CLASSIC
        this.priceReq += 200000;
    }

    public void customisedCarPrice(car C) {
        this.priceReq = C.AXP.priceRaise(this.priceReq) + C.COP.priceRaise(this.priceReq)
                + C.INT.priceRaise(this.priceReq)
                - 2 * this.priceReq;
        // return this.priceReq;
    }
}

class car {
    corePart COP = new corePart();
    auxillaryPart AXP = new auxillaryPart();
    interior INT = new interior();

    car(corePart COP, auxillaryPart AXP, interior INT) {
        this.COP = COP;
        this.AXP = AXP;
        this.INT = INT;
    }
}

interface displayer {
}

interface idGenerator {
    // basic info attributes
    // STALLED FOR NOW -> void bonusApplicable();
    // int prevoiusPurchase;
}

public class docCustomerSegment {
    public static void main(String[] args) {
        corePart COP = new corePart('A', "SUV");
        interior INT = new interior();
        auxillaryPart AXP = new auxillaryPart('A', "SUV");
        car jatan = new car(COP, AXP, INT);
        // pricing paisa;
        timing tame = new timing();
        pricing paisa = new pricing();
        paisa.defaultCarPrice();
        paisa.customisedCarPrice(jatan);
        tame.defaultCarTime();
        tame.customisedCarTime(jatan);
        System.out.println(tame.timeReq);

        System.out.println(paisa.priceReq);
    }
}