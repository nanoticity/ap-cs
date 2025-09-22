public class Profile {
    private String name;
    private int age;
    private String subject;
    private String hobby;
    private String food;

    public Profile(String name, int age, String subject, String hobby, String food) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.hobby = hobby;
        this.food = food;
    }

    public Profile() {
        this.name = "unknown";
        this.age = 0;
        this.subject = "unknown";
        this.hobby = "unknown";
        this.food = "unknown";
    }

    public void updateProfile(String name, int age, String subject, String hobby, String food) {
        this.name = name;
        this.age = age;
        this.subject = subject;
        this.hobby = hobby;
        this.food = food;
    }

    private void printCareer() {
        if (subject.equals("math")) {
            if (hobby.equals("piano")) {
                if (food.equals("sushi") ) {
                    System.out.println("Your future career is a programmer.");
                } else if (food.equals("tacos")) {
                    System.out.println("Your future career is a mathematician.");
                } else if (food.equals("burger")) {
                    System.out.println("Your future career is a teacher.");
                }
            } else if (hobby.equals("sailing")) {
                if (food.equals("burger")) {
                    System.out.println("Your future career is an engineer.");
                } else if (food.equals("sushi")) {
                    System.out.println("Your future career is a pilot.");
                } else if (food.equals("tacos")) {
                    System.out.println("Your future career is a chef.");
                }
            } else if (hobby.equals("soccer")) {
                if (food.equals("tacos")) {
                    System.out.println("Your future career is an accountant.");
                } else if (food.equals("sushi")) {
                    System.out.println("Your future career is a financial analyst.");
                } else if (food.equals("burger")) {
                    System.out.println("Your future career is a businessperson.");
                }
            }


        } else if (subject.equals("history")) {
            if (hobby.equals("piano")) {
                if (food.equals("tacos")) {
                    System.out.println("Your future career is a historian.");
                } else if (food.equals("sushi")) {
                    System.out.println("Your future career is a writer.");
                } else if (food.equals("burger")) {
                    System.out.println("Your future career is a librarian.");
                }
            } else if (hobby.equals("sailing")) {
                if (food.equals("burger")) {
                    System.out.println("Your future career is a politician.");
                } else if (food.equals("sushi")) {
                    System.out.println("Your future career is a diplomat.");
                } else if (food.equals("tacos")) {
                    System.out.println("Your future career is a travel agent.");
                }
            } else if (hobby.equals("soccer")) {
                if (food.equals("tacos")) {
                    System.out.println("Your future career is a coach.");
                } else if (food.equals("sushi")) {
                    System.out.println("Your future career is a sports journalist.");
                } else if (food.equals("burger")) {
                    System.out.println("Your future career is an athlete.");
                }
            }
        } else if (subject.equals("science")) {
            if (hobby.equals("soccer")) {
                if (food.equals("burger")) {
                    System.out.println("Your future career is a scientist.");
                } else if (food.equals("sushi")) {
                    System.out.println("Your future career is a doctor.");
                } else if (food.equals("tacos")) {
                    System.out.println("Your future career is a veterinarian.");
                }
            } else if (hobby.equals("sailing")) {
                if (food.equals("burger")) {
                    System.out.println("Your future career is a marine biologist.");
                } else if (food.equals("sushi")) {
                    System.out.println("Your future career is an oceanographer.");
                } else if (food.equals("tacos")) {
                    System.out.println("Your future career is a fisherman.");
                }
            } else if (hobby.equals("piano")) {
                if (food.equals("tacos")) {
                    System.out.println("Your future career is a chemist.");
                } else if (food.equals("sushi")) {
                    System.out.println("Your future career is a physicist.");
                } else if (food.equals("burger")) {
                    System.out.println("Your future career is a biologist.");
                }
            }
        } else {
            System.out.println("Your future career is unknown.");
        }

    }

    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Favorite Subject: " + subject);
        System.out.println("Hobby: " + hobby);
        System.out.println("Favorite Food: " + food);
        printCareer();
    }

}
