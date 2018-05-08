# Java Test

Learning Java pls ignore

## Getting Started

Dunno why you want to but okay.

### Prerequisites

* Java
* Computer
* Eyes

### Installing

Honestly the thing isn't done and doesn't work properly, and I assume that if you reaaaaally want to look at the thing then you know how to compile and run it.

## Author

* Me (Tumuk)

## Todo

### Overall Program:

* Fun stuff not really needed but anyway:
 	* Toolbar
 	* File choosing box, so user can choose which save file to load into the program.

## Acknowledgments

* My compsci professor for teaching me Java and thus making me fiddle around with it here.

## Changelog

### 08-05-2018
* Changed some for loops into lambda expressions.

* Added the @Override annotation to all methods that override parent class methods.

### 30-04-2018
* Whew, this is a big one.

* Removed text file IO, replaced it with database IO:
	* Uses SQLite (specifically the library [here](https://bitbucket.org/xerial/sqlite-jdbc) (which is needed to compile and run the program))
	* The program reads the database on open and saves to the database on close.

* Separated GUI components into their own classes and files:
	* Put each instance of a JPanel into its own class.
	* Put each ActionListener for each JPanel into its own class.
	* This took most of the time working on this today, I'm so tired, but feel so accomplished.

* Changed how card lists are populated for all tabs that use them. Moved from using a MouseEntered listener (which was yucky) to an interface implementation and callbacks (not yucky). Fixes an issue that the card lists had before, where if your mouse pointer entered the JComboBox, the selected item index would reset.

* And probably other smaller things that I can't think of because I'm tired. Sorry changelog purists.

### 26-04-2018
* Added file IO:
	* Program loads saved card and purchase data on open.
	* Program saves card and purchase data on close.

* Added ability to convert currency:
	* Convert AUD on card to any of the 7 available currencies.
	* Will not work if more than 5 currencies already on card, or there are insufficient funds to do the conversion.

* Changed how making a purchase works:
  	* Warn user that the selected currency is not in the selected card only if the card is a multicard, and the currency isn't in card.
  	* Make a purchase even if the selected currency is not in the card if the card is a basic card.

* Added a title to the window!

* General code cleanup.

### 23-04-2018
* Added basic functionality for all things that can be done to all cards:
	* See the total value for all cards.
	* See the total balance for each currency over all cards.
	* See the total spent in each country over all cards.
	* List all of the cards by either the order they were created in or the value of the card.

* Cleaned up some spacing between elements in the GUI to ensure no weird stuff happens when a label changes (for example).

### 18-04-2018
* Fixed label spacing for "Purchase Made Successfully" in the "Make Purchase" tab.

* Added full GUI functionality to the "Total Spent by Country" tab for the "Single Card" tab.

* Added full GUI functionality to the "Show Value" tab for the "Single Card" tab.

### 15-04-2018

* Pushed the work I had done so far to GitHub. Includes (among other, less important features):
	* Working (and completed) code for the MultiCard, BasicCard, Card, and Purchase classes.
	* Basic GUI outline for all features of the program.
	* Full GUI functionality for creating and loading a card, and seeing a single card's purchase history.
	* Partially completed GUI functionality for making a purchase.