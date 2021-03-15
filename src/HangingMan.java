class HangingMan {

    private int numWrongGuesses;

    HangingMan() {
        numWrongGuesses = 0;
    }

    boolean isntDead() {
        return numWrongGuesses < HangmanImage.length;
    }
    void show() {
        System.out.println(HangmanImage[numWrongGuesses]);
    }
    void dieSomeMore() {
        numWrongGuesses++;
    }

    private String[] HangmanImage = {"+----+\n"+
            "|\n"+
            "|\n"+
            "|\n"+
            "/\\\n",

            "+----+\n"+
                    "|    O\n"+
                    "|\n"+
                    "|\n"+
                    "/\\\n",

            "+----+\n"+
                    "|    O\n"+
                    "|    +\n"+
                    "|\n"+
                    "/\\\n",

            "+----+\n"+
                    "|    O\n"+
                    "|    +-\n"+
                    "|\n"+
                    "/\\\n",


            "+----+\n"+
                    "|    O\n"+
                    "|   -+-\n"+
                    "|\n"+
                    "/\\\n",


            "+----+\n"+
                    "|    O\n"+
                    "|   -+-\n"+
                    "|   / \n"+
                    "/\\\n",


            "+----+\n"+
                    "|    O\n"+
                    "|   -+-\n"+
                    "|   / \\\n"+
                    "/\\\n",
    };

}
