# MonopolySolver

## Summary:
### Context:
#### One day I was playing an intense game of Monopoly with my girlfriend and we reached a point in the game where it got really slow and we had bought all the properties available.  I knew this game could last hours until we'd see an end, so that's when I got the idea of Monopoly Solver.  Instead of playing the game for hours to find a winner, why not have the computer simulate the game and compute a winner?

#### This app is meant to speed the game of Monopoly up to find a winner when you no longer feel like playing, but still want to know who won.  The app helps gather all the statistics of the game such as: 
- how many players? 
- the balance each player currently has
- the position the player currently is at
- the owner of each property


#### Having all these stats about the game allows me to run it through the custom logic I wrote for Monopoly in the Java class MonopolyLogic.  The logic takes rent, pass go receive 200, and jail time into consideration.  It rolls for each player by generating two random numbers between the range of (1-6) and adding them together, simulating a pair of dice.  It keeps rolling until either a player goes bankrupt, or until a player reaches the max int value.
