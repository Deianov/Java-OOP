package A_WorkingWithAbstraction.Exercises.CardSuit;

enum Suits3 {
    CLUBS{
        @Override
        public String toString() {
            return "Clubs";
        }
    },
    DIAMONDS{
        @Override
        public String toString() {
            return "Diamonds";
        }
    },
    HEARTS{
        @Override
        public String toString() {
            return "Hearts";
        }
    },
    SPADES{
        @Override
        public String toString() {
            return "Spades";
        }
    };
}
