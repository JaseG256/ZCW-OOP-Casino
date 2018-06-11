package io.zipcoder.casino;

    public class Dice {

        private Die[] dies;
        private int numberOfDice;

        public Dice(int numberOfDice) {

            this.numberOfDice = numberOfDice;
            dies = new Die[this.numberOfDice];

            for (int i = 0; i < this.numberOfDice; i++) {
                dies[i] = new Die();
            }
        }

        public int getSum() {

            int sumOfTosses = 0;
            for (Die die : dies) {
                sumOfTosses += die.toss();
            }
            Console.output(sumOfTosses);
            return sumOfTosses;
        }

        @Override
        public String toString() {
            String describe = "";
            for (int i = 0; i < dies.length; i++) {
                describe = Console.output("Die " + i + dies[i].getValue());
            }
            return describe;
        }

    }