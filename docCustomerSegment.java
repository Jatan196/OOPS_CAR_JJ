/*-----------------------PACKAGE-"car.package.customer"-------------------------------------------*/
//COPYRIGHT NOTICE-> CAR MANFACTURING FIRM -> JATAN TANDON*(OWNER OF PACKAGE) , JAY PATEL (CONTIBUTER FOR PACKAGE)

import java.lang.String;
import java.util.Scanner;
import java.text.DecimalFormat;

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
        switch (segment) {//
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
        deafultPrice *= 1.27 + gradingP(this.grade) - 0.1 + segmentP(this.auxillaryPartSegment) - 0.1;
        // }
        return deafultPrice;

    }

    public int timeCharge(int deafultTime) {

        // if (customised) {
        // According to SUV dimension + quality grading
        deafultTime *= gradingT(this.grade) + segmentT(this.auxillaryPartSegment);//
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
        this.intLook = "CLASSIC";
    }

    interior(String intLook) {
        this.intLook = intLook;
    }

    public int priceRaise(int defaultPrice) {
        if (this.intLook == "ROLLS ROYCE") {
            defaultPrice *= 1.6;
        } else if (this.intLook == "VOLVO") {
            defaultPrice *= 1.7;
        }
        return defaultPrice;
    }

    public int timeCharge(int defaultPrice) {
        if (this.intLook == "ROLLS ROYCE") {
            defaultPrice *= 1.5;
        } else if (this.intLook == "VOLVO") {
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
                - 2 * this.timeReq;//
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

public class docCustomerSegment {
    public static void main(String[] args) {

        displayer dsp = new displayer();

        corePart COP = new corePart(dsp.gradeAux, dsp.corePartSegment);
        interior INT = new interior(dsp.intLook);
        auxillaryPart AXP = new auxillaryPart(dsp.gradeAux, dsp.auxillaryPartSegment);
        car jatan = new car(COP, AXP, INT);

        // OPERATION ON DATA
        timing tame = new timing();
        pricing paisa = new pricing();

        tame.defaultCarTime();
        paisa.defaultCarPrice();
        if (dsp.check) {
            tame.customisedCarTime(jatan);
            paisa.customisedCarPrice(jatan);
        }

        // Creating a DecimalFormat object with the desired format pattern
        DecimalFormat df = new DecimalFormat("##,##,##,##,###");

        String formattedNumber = df.format(paisa.priceReq);
        System.out.println(tame.timeReq + " Hrs will be taken to ready you product");
        System.out.println(formattedNumber + " Lakhs will add upto your cost as per you customisation");

    }
}
/*--------------------------DISPLAYER METHOD AND VALUE SETTER------------------------------ */

class setter {

    String partSet(String code) {

        switch (code) {
            case "***":
                return "SUV";

            case "**":
                return "AVERAGE";

            case "*":
                return "HATCHBACK";

            default:
                return "AVERAGE";
        }

    }

    String lookSet(String code) {

        switch (code) {
            case "***":
                return "VOLVO";

            case "**":
                return "ROLLS ROYCE";

            case "*":
                return "CLASSIC";

            default:
                return "CLASSIC";
        }

    }

}

class displayer {
    String corePartSegment = "AVERAGE";
    char gradeCore = 'B';

    String auxillaryPartSegment = "AVERAGE";
    char gradeAux = 'B';

    String intLook = "CLASSIC";
    Scanner sc = new Scanner(System.in);
    boolean check = false;

    boolean customised() {

        System.out.println(
                "Now you can go for customisation of all above functionalities by pressing C  OR Enter N for next customisation");
        char c = sc.next().charAt(0);
        if (c == 'C') {
            check = true;
            return true;
        }

        return false;
    }

    void copBrochure(char c) {

        // SUV Segment

        if (c == 'B') {
            System.out.println("SUV Specifications:");
            System.out.println(
                    "- Tires: 265/70R17 for maximum traction and durability. Puncture-resistant and built for rough terrains.");
            System.out.println(
                    "- Steering: Robust power steering system, built for heavy-duty use, with enhanced stability control.");
            System.out.println(
                    "- Engine: V6 or 6-cylinder engines with 300+ horsepower for superior torque and towing capacity.");
            System.out.println(
                    "- Durability: Built to withstand challenging conditions and designed for off-road adventures.");
            System.out.println("- Expected Working Well Duration Period: Over 200,000 miles.");
            System.out.println(
                    "- Benefits: Exceptional power for off-road capabilities, durability, and long-lasting performance.");

            // AVERAGE Segment
            System.out.println("\nAVERAGE Car Specifications:");
            System.out.println(
                    "- Tires: 215/65R16 for versatile driving conditions. Balanced tread life and durability.");
            System.out.println(
                    "- Steering: Standard hydraulic power steering system, responsive and adaptable for different driving conditions.");
            System.out.println(
                    "- Engine: 4-cylinder engines with 150-200 horsepower for a range of driving conditions.");
            System.out.println("- Durability: Versatile and reliable for everyday use.");
            System.out.println("- Expected Working Well Duration Period: Over 150,000 miles.");
            System.out.println(
                    "- Benefits: Versatile performance across different terrains, reliability, and lower overall costs.");

            // HATCHBACK Segment
            System.out.println("\nHATCHBACK Specifications:");
            System.out.println(
                    "- Tires: 195/60R15 for urban driving efficiency. Good tread life and low rolling resistance.");
            System.out.println(
                    "- Steering: Compact electric power steering system for city driving. Nimble steering response.");
            System.out
                    .println("- Engine: Compact 4-cylinder engines with 100-150 horsepower for urban efficiency.");
            System.out.println("- Durability: Designed for city roads, reliable, and fuel-efficient.");
            System.out.println("- Expected Working Well Duration Period: Over 150,000 miles.");
            System.out.println("- Benefits: Fuel economy, precise handling, and lower maintenance costs.");
        } else {
            return;
        }
    }

    void axpBrochure(char c) {

        if (c == 'B') {
            // SUV Segment
            System.out.println("SUV Specifications:");
            // Gear Box
            System.out.println("- Gear Box:");
            System.out.println(
                    "  - Type: 8-speed automatic transmission designed for seamless power delivery, ideal for off-road adventures.");
            System.out
                    .println(
                            "  - Durability: Engineered for heavy-duty use, rated for over 150,000 miles of performance.");
            System.out
                    .println(
                            "  - Features: Advanced gear shifting technology for smooth transitions and precise control.");

            // Airbags
            System.out.println("\n- Airbags:");
            System.out.println(
                    "  - Safety: Eight airbags strategically placed throughout the cabin for comprehensive passenger protection.");
            System.out.println(
                    "  - Durability: Built to deploy instantly in case of an impact, reducing the risk of injury. Meets highest safety standards.");
            System.out.println(
                    "  - Features: Advanced sensor systems for precise airbag deployment tailored to various collision scenarios.");

            // Headlights
            System.out.println("\n- Headlights:");
            System.out.println(
                    "  - Type: Powerful LED headlights with adaptive features, rated for over 50,000 hours of use, perfect for night-time off-road driving.");
            System.out.println(
                    "  - Durability: Built to withstand harsh weather conditions and provide long-lasting illumination.");
            System.out.println(
                    "  - Features: Adaptive lighting technology adjusts beam patterns for optimal visibility on winding paths.");

            // HATCHBACK Segment
            System.out.println("\nHATCHBACK Specifications:");
            // Gear Box
            System.out.println("- Gear Box:");
            System.out.println(
                    "  - Type: 7-speed automatic transmission for smooth city driving and efficient fuel consumption.");
            System.out.println(
                    "  - Durability: Designed for urban use, delivering reliability and efficiency, rated for over 100,000 miles.");
            System.out.println("  - Features: Responsive gear changes for nimble handling in crowded streets.");

            // Airbags
            System.out.println("\n- Airbags:");
            System.out.println(
                    "  - Safety: Six airbags ensure comprehensive protection for occupants in urban driving conditions.");
            System.out.println(
                    "  - Durability: Designed to deploy rapidly in the event of an accident, enhancing safety. Meets industry standards.");
            System.out.println(
                    "  - Features: Integrated with sensors for precise deployment tailored to urban collision scenarios.");

            // Headlights
            System.out.println("\n- Headlights:");
            System.out.println(
                    "  - Type: Sleek and efficient halogen headlights perfect for urban navigation, rated for over 1,000 hours of use.");
            System.out.println("  - Durability: Designed for consistent performance in city conditions.");
            System.out.println("  - Features: Smart beam technology for optimal illumination during city driving.");

            // AVERAGE Segment
            System.out.println("\nAVERAGE Car Specifications:");
            // Gear Box
            System.out.println("- Gear Box:");
            System.out.println("  - Type: Standard 6-speed automatic transmission for versatile driving conditions.");
            System.out.println(
                    "  - Durability: Balanced between efficiency and reliability for everyday use, rated for over 120,000 miles.");
            System.out
                    .println("  - Features: Smooth gear changes for consistent performance across different terrains.");

            // Airbags
            System.out.println("\n- Airbags:");
            System.out.println(
                    "  - Safety: Equipped with essential six airbags for occupant safety under various driving conditions.");
            System.out
                    .println("  - Durability: Engineered for reliable deployment when needed. Meets safety standards.");
            System.out.println("  - Features: Enhanced sensor systems ensure timely airbag deployment.");

            // Headlights
            System.out.println("\n- Headlights:");
            System.out.println(
                    "  - Type: Standard halogen headlights designed for all-purpose use, rated for over 800 hours of use.");
            System.out.println(
                    "  - Durability: Built to provide consistent illumination across different terrains and weather conditions.");
            System.out.println("  - Features: Reliable lighting technology for versatile driving.");
        }

        else {
            return;
        }
    }

    void intLookBrochure(char c) {
        if (c == 'B') {
            displayInterior("Classic", "Elegant wood and leather design.", "Detailed craftsmanship and vintage charm.");
            displayInterior("Rolls-Royce Style", "Unmatched luxury with handcrafted veneers.",
                    "Personalized inlays and cutting-edge tech.");
            displayInterior("Volvo Style", "Scandinavian minimalism with natural materials.",
                    "Comfortable, safety-focused design.");
        } else {
            return;
        }
    }

    void choiceDisplay() {
        System.out.println("You can for SUV segment for this parts by entering --> *** ");
        System.out.println("You can for AVERAGE segment for this parts by entering --> ** ");
        System.out.println("You can for HATCHBACK segment for this parts by entering --> * ");
    }

    // Helper method to display interior specifications.
    void displayInterior(String style, String design, String features) {
        System.out.println(style + " Interior Look:");
        System.out.println("- Design: " + design);
        System.out.println("- Features: " + features);
    }

    void grade() {
        System.out.println("When choosing equipment and parts, consider the following grades:");
        System.out.println(
                "- Grade A: Opt for premium grade A components for superior performance, durability, and reliability, ensuring top-tier results.");
        System.out.println(
                "- Grade B: Grade B equipment offers a balance between quality and cost-effectiveness, making it a cost-efficient choice without compromising essential performance.");
        System.out.println(
                "- Grade C: Choose grade C when budget constraints are a primary concern. While grade C parts are more budget-friendly, they may sacrifice some performance and durability.");
        System.out.println("Enter grade accordingly --> A OR B OR C");
    }

    displayer() {
        Scanner sc = new Scanner(System.in);
        setter st = new setter();

        // For Core Part
        System.out.println("To have look on specification for CORE PARTS press B for Brochure or can press N for next");

        char c = sc.next().charAt(0);
        copBrochure(c);
        System.out.println(
                "------------------------------------------------------------------------------------------------------");
        boolean flag = customised();
        if (flag) {
            choiceDisplay();
            String choice1 = sc.next();
            this.corePartSegment = st.partSet(choice1);
            System.out.println(
                    "------------------------------------------------------------------------------------------------------");

            // System.out.println("------------------------------------------------------------------------------------------------------");

            grade();
            this.gradeCore = sc.next().charAt(0);
            System.out.println(
                    "------------------------------------------------------------------------------------------------------");

        }

        // For Auxillary Part
        System.out.println(
                "To have look on specification for AUXILLARY PARTS press B for Brochure or can press N for next");
        char c1 = sc.next().charAt(0);
        axpBrochure(c1);
        System.out.println(
                "------------------------------------------------------------------------------------------------------");

        flag = customised();
        if (flag) {
            choiceDisplay();
            String choice2 = sc.next();
            this.auxillaryPartSegment = st.partSet(choice2);
            System.out.println(
                    "------------------------------------------------------------------------------------------------------");

            grade();
            this.gradeAux = sc.next().charAt(0);
            System.out.println(
                    "------------------------------------------------------------------------------------------------------");

        }

        // For Interior Look
        System.out.println(
                "To have look on specification for INTERIOR LOOK press B for Brochure or can press N for next");
        char c2 = sc.next().charAt(0);
        intLookBrochure(c2);
        System.out.println(
                "------------------------------------------------------------------------------------------------------");

        flag = customised();
        if (flag) {
            System.out.println("You can go for VOLVO segment for this parts by entering *** ");
            System.out.println("You can go for ROLLS ROYCE segment for this parts by entering ** ");
            System.out.println("You can go for CLASSIC segment for this parts by entering * ");

            String choice3 = sc.next();
            this.intLook = st.lookSet(choice3);
            System.out.println(
                    "------------------------------------------------------------------------------------------------------");
        }
    }

}
