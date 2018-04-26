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

### Single Card:

* Make Purchase
  	* Say currency not in card only if card is a multicard and currency isn't in card (requires SQL/filesaving code)
  	* Make purchase even if currency not in card if basic card (requires SQL/filesaving code)

### Overall Program:

 * Split main GUI components into separate classes/files to clean up the program.

 * All callbacks so card selection lists are repopulated when the program is opened and when a new card is created (requires splitting GUI components into separate classes).

## Acknowledgments

* My compsci professor for teaching me Java and thus making me fiddle around with it here.

## Changelog

### 26-04-2018
* Added file IO:
	* Program loads saved card and purchase data on open.
	* Program saves card and purchase data on close.

* Added ability to convert currency:
	* Convert AUD on card to any of the 7 available currencies.
	* Will not work if more than 5 currencies already on card, or there are insufficient funds to do the conversion.

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