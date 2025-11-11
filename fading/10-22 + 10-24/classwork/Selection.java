public class Selection {
    public String gradeCalculator(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
        
    }

    public String zipCode1(int zip) {
        if (zip == 94040) {
            return "Mountain View";
        } else if (zip == 94115) {
            return "San Francisco";
        } else if (zip == 95051) {
            return "Santa Clara";
        } else if (zip == 95129) {
            return "San Jose";
        } else if (zip == 94607) {
            return "Oakland";
        } else if (zip == 95035) {
            return "Milpitas";
        } else {
            return "Unknown Zip Code";  
        }
    }

    public String zipCode2(int zip) {
        switch (zip) {
            case 94040:
                return "Mountain View";
            case 94115:
                return "San Francisco";
            case 95051:
                return "Santa Clara";
            case 95129:
                return "San Jose";
            case 94607:
                return "Oakland";
            case 95035:
                return "Milpitas";
            default:
                return "Unknown Zip Code";
        }
    }
}
