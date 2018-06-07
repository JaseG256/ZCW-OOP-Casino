package io.zipcoder.casino;

import java.util.Random;

    public class Dice
    {
        private int dice;
        private Random randomGenerator;

        public Dice(int numberOfDice)
        {
            dice = numberOfDice;
        }

        public int getSum()
        {
            int sumOfTosses = 0;
            for (int i=0; i<dice; i++)
            {
                randomGenerator = new Random();
                int resultOfToss = randomGenerator.nextInt(6)+1;
                sumOfTosses += resultOfToss;
            }
            return sumOfTosses;
        }

        public int[] getEach()
        {
            int[] tosses = new int[dice];
            for (int i=0; i<dice; i++)
            {
                randomGenerator = new Random();
                tosses[i] = randomGenerator.nextInt(6)+1;
            }
            return tosses;
        }
    }

