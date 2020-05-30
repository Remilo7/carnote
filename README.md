# CarNote
Spring MVC based car expenses notebook and calculator. 

## Features
 - Bootstrap based front-end
 - MySQL database 
 - Adding / removing vehicles
 - Adding / removing / editing expenses 
    - Various categories of expenses
      - Exploitation
      - Repairs
      - MOT
      - Insurance
      - Other
 - Adding / removing / editing fuel expenses
   - Diesel
   - PB
   - PB + LPG
 - Vehicle panel
   - List of expenses
     - Expense name
     - Type
     - Date
     - Milage
     - Price
     - Searching
   - Calculating last and average fuel consumption
   - Summarizing cost of particular types of expenses 
   - Details of each expense
   - Importing expenses from .xlsx file
   - Exporting expenses to .xlsx file
 
## Running the application locally

You need to have installed Java and Maven. 
Enter the directory where you downloaded the code and run:
```
mvn package
```
And then 
```
java -jar target/dependency/webapp-runner.jar target/*.war
```
After few seconds, the web application is available on http://localhost:8080/

You can also check it on https://carnote.herokuapp.com

