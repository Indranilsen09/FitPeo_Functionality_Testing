# FitPeo_Functionality_Testing_Assessment<br>
### Author: <u>Indranil Sen</u>
##### Build-Tool: Maven
##### Build-Language:Java
##### UI-Functionality-Testing-Tool: Selenium 
##### Framework_Structure: Behavior Driver Development <br>

## System-Requirement:
### Java should be installed in system - 
    to Check Java version CMD: "java --version"
### Maven should be installed in system -
    to Check Maven version CMD: "mvn --version"
#### Note: Java & Maven should be setted as Environment Variable

## Steps for Running in Local
1. Clone the Repository <br> 
   git clone https://github.com/Indranilsen09/FitPeo_Functionality_Testing
2. Move to the cloned directory -
    cd path/to/the/project/directory
3. Run command : <strong>"mvn clean test"</strong> or <strong>"mvn clean install"</strong>


## Post Running :-
1. Cucumber Reports can be found under "target/reports" folder <br> 
     - 3 formats of reports can be found:- .html/.json/.xml
   
2. Screenshots are placed under "target/screenshots" folder(in order)
3. No need to Setup BrowserDriver Path as Selenium manager will handle the Browser binaries
4. TestNG Reports can be found under "target/surefire-reports"

