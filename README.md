# Goal
Goal: Practice OO and UI design with what we learned in Java / Android weeks.


## Food Tracker
You are required to write an Android app that allows a user to track the food they eat.


### MVP:
 Users should be able to enter what they eat and when (date/time) and for what meal.


### Possible Extensions:
The app should show the user a record of what they have eaten over a given period e.g. In March I drank lots of Irn-Bru.

## My Experience:
Started off by having a group planning session where we captured and discussed viable methods for completing the tasks.
User needs, class diagrams, and table diagrams were sketched out and we discussed the pros and cons of each suggested solution.
We ended up agreeing on creating only one table with 6 columns as follows:
1: ID,
2: Breakfast,
3: Lunch,
4: Dinner,
5: Snacks,
6: Date.
Only 1 Model for the above table was deemed to be necessary, along with an ENUM for the Meal types.

The first task was to review and research tutorials on-line for implementing & using SQLite database for Android. This was not covered in previous weeks at CodeClan, but would be required to build a successful app.
I started off by creating my directory structure, based on previous classroom and homework exercises. I then created my Food model, a Mealtype Enum and tested the getters & setters.
Once done I started work on the SQLite database and creating the table. During this time I realised that my plan to have separate columns for each meal type was impractical, since when inserting a new row there would be numerous null fields.
Decided to revisit my plan and decided to have a table as follows:
1: ID,
2: Meal Type,
3: Food Eaten,
4: Date,
5: Calories (as an extension if time allowed following MVP attainment).
This meant that my Food model and tests would have to be refactored, but this wasn't a big issue since I was using an Enum for the meal type anyway. So just some minor tweaks were required, including adding a new parameter for food eaten.
Following this, I continued working on setting up the Database. I ran into a few problems due to the use of an Enum for the Meal type, and I had to write methods to convert the constants into Strings. I then had to write another method to convert them back again!!
Eventually, the set-up of the database with all CRUD functions was completed, and I could start work on developing the app.
I decided that the App should use a list view, which is something we had been shown how to use previously. I encountered an issue where my app was not displaying any information from my database, although information was being saved. With some help from the instructors I managed to make some corrections in the code for the Array Adapter, and everything was fine. I did start going down the route of using a Cursor Adapter instead, but found that this would not provide any meaningful advantage.
In my list view I wanted it set up so that when a user selected a specific row it would redirect them to an 'edit' screen where they could delete the item, or perform updates. This was trickier than I thought, since I wanted the fields to be auto-populated with the data from the selected item, and I had included a spinner for the meal type. Again, I received some help on this, and once done I managed to meet the MVP.
Following MVP I then added some bells & whistles including a Calendar for selecting the date and a welcome screen.
I also found time to add Calorie count and adjust the app to suit.


##Setting up
- Install Android Studio.
- Clone/Download repository to a destination of your choice.
- Open Android Studio and choose the 'open existing project' option.
- The app can be run from the run menu option and selecting an emulator of your choice.

## Design
The design intent was to keep it as simple as possible and maintain accessibility.
A simple list view layout with a comfortable colour scheme was chosen throughout. A spinner was used for populating the meal type field in order to limit the options, and prevent typing errors. Similarly, the Calendar pop-up was used for the date selection.

## Outcome
The MVP was achieved, with basic functionality. I therefore achieved what I set out to do in this respect, but would've liked a bit more time to include additional features.
My main aim - as per project brief - was to consolidate all that I had been taught over the past few weeks with Java and Android, and gain an understanding on implementing SQLite. I feel that over the course of the project, and by working through various problems, that my understanding has improved, and the goal has largely been met.

## Moving Forward
At some point I would like to revisit this app and include a filter for the list, along with a graph to trend calorie intake.
