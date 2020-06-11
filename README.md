# TicTacToe Game

Tic-tac-toe, Xs and Os or CROSS and NOUGHTS is a game for two players, X and O, who take turns marking the spaces in a 3X3 matrix as depicted below. 
The player who places three of their marks in a horizontal, vertical, or diagonal row [either from right top to left bottom or left top to right bottom ]is the winner. 
Game result will be declared as 'Draw' when all of the positions in game board are marked.
```
0 1 2
3 4 5
6 7 8
```
# Purpose

This TicTacToe game is developed using Test Driven Development approach in Java programming language.

# Rules 
```
The rules are described below :

1) X always goes first.
2) Players cannot play on a played position.
3) Players alternate placing X’s and O’s on the board until either:
4) One player has three in a row, horizontally, vertically or diagonally
5) All nine squares are filled.
6) If a player is able to draw three X’s or three O’s in a row, that player wins.
7) If all nine squares are filled and neither player has three in a row, the game is a draw.
```

# Functional Cases:
```
1) Player X should be always given the first move and should be able to place the mark in gameBoard
2) Player 0 should be given the next move , following player X
3) Player X should be given the next move , following player O
4) Player X should be declared as winner when he takes all the fields in 1st row
5) Player X should be declared as winner when he takes all the fields in 2nd row
6) Player X should be declared as winner when he takes all the fields in 3rd row
7) Player X should be declared as winner when he takes all the fields in 1st column
8) Player X should be declared as winner when he takes all the fields in 2nd column
9) Player X should be declared as winner when he takes all the fields in 3rd column
10) Player X should be declared as winner when he takes diagonally all positions from left to right
11) Player X should be declared as winner when he takes diagonally all positions from right to left
12) Player O should be declared as winner when he takes all the fields in 1st row
13) Player O should be declared as winner when he takes all the fields in 2nd row
14) Player O should be declared as winner when he takes all the fields in 3rd row
15) Player O should be declared as winner when he takes all the fields in 1st column
16) Player O should be declared as winner when he takes all the fields in 2nd column
17) Player O should be declared as winner when he takes all the fields in 3rd column
18) Player O should be declared as winner when he takes diagonally all positions from left to right
19) Player O should be declared as winner when he takes diagonally all positions from right to left
20) Game should be declared as Draw when all positions are filled in the board by both players
21) Exception should be thrown when any player selects the range other than 0 to 8
22) Game should not allow any player to place their mark in already occupied position
```

# Prerequisites
To run this program below softwares needs to be installed
```
Java - Version 1.7 or above
JRE compliance - 1.7 or above
Maven - For Dependency management
JUnit - Version 4.12 (added dependency in pom.xml)
Eclipse - Any IDE which supports Java
```

# Steps to run the test cases in eclipse IDE
```
1) Download project as zip file and unzip the same to a folder. 
2) In eclipse IDE,  Go to the below path
   File -> Import -> select Existing Maven Project option -> Next -> 
   Browse 	extracted folder and Finish
3) Then, Right click project in Project Explorer window and 
   select Run As -> Maven install
4) Once above steps done open <b>TicTacToeTestSuite</b> class and right click  
   file and choose Run As -> JUnit Test
```
# How to access the code coverage report
```
Jacoco code coverage report can be accessed by the following steps.

Download project as zip file and unzip the same to a folder. 
Open a command prompt and goto the project(extracted) folder and execute below commands:
mvn clean
mvn install
After completion of above steps, the report will be available in below path
<PROJECT_ROOT_FOLDER>\target\site\jacoco\index.html
```
# Passing input values - Guidelines
```
1) Your inputs should be in the format of row, column. for eg.0,0 or 1,2 .
2) Your inputs should be in the range of 0 to 2 i.e 1,2 or 2,0.
3) Your inputs should contain only digits and comma. for eg 1,2 .
4) Please do not enter already played position again.
5) Some Invalid inputs examples for your reference (0,-1),(1,3), (3,3), (m,2), ( ,1), (1, )  .
```
# Steps to run the application in command prompt
```

After successful maven build
Goto <ProjectDirectory>\target\classes
and execute below command

java -classpath .\ com.bnpp.kata.game.TicTacToeGameRunner 
Press Enter
Then give row value, column value to be placed as depicted below
0,1 [in words : Zero comma One]

Please provide the row and column values until the game ends!!


