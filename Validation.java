public class Validation {
    public boolean nameValidaion(String name) {
        if (name == null)
            return false;
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean ageValidaion(String age) {
        int age1;
        try {
            age1 = Integer.parseInt(age);
        } catch (NumberFormatException e) {
            return false;
        }
            if (age1 < 0)
                return false;
            return true;

    }

    public boolean gpaValidaion(String gpa) {
        double gpa1;
        try {
            gpa1 = Double.parseDouble(gpa);
        }catch (NumberFormatException e){
            return false;
        }
        if(gpa1<0||gpa1>4) {
            return false;
        }
        return true;
    }
}


