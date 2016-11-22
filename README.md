##Project main structure
###Main - > Java
  1. java\Pages - contains page object classes
  2. java\Utils - contains utils clases:
    - DriverManager - util to manage the work with driver
    - PageProvider - the class designed using Facade and Singleton pattern. Use for getting app pages
    - PropertiesManager - class contains methods to set properties from file
    - SetUpManager - class where the testing system can be configured
    - XMLDataProvider - class that includes method that parses XML documents and provides data in correct format

###Main - > recources
  1. resources\log4j.properties - contains defined properties for log4j
  2. resources\platform.properties - contains defined properties for testing system 
  3. resources\triller_2_4_0_260.apk - application file
  
###Test -> java
  1. com\Triller\Tests\...-package with tests

###Test -> testResources
  1. TestRecources\testData.xml - file with test data in XML format


#### Example of results provided by log4j
```
2016-11-21 18:30:26 : INFO  BaseTest  	-[setUp]:21 - *****************************************************************************
2016-11-21 18:30:26 : INFO  BaseTest  	-[setUp]:22 - Log in with valid credentials- test has been started
2016-11-21 18:30:26 : INFO  BaseTest  	-[setUp]:23 - Initialisation of platform properties
2016-11-21 18:30:57 : INFO  PositiveTests  	-[LogIn]:19 - Verify if user is able to login to the system using valid credentials
2016-11-21 18:31:02 : INFO  LoginOptionsPage  	-[logInWithEmail]:19 - Choosing login via email
2016-11-21 18:31:05 : INFO  LoginPage  	-[fillCredentials]:28 - Fill fields with username - qatester and password - aqswdefr
2016-11-21 18:31:26 : INFO  ProfilePage  	-[checkUserTitle]:26 - Check if users profile is displaying
2016-11-21 18:31:28 : INFO  ProfilePage  	-[checkUserTitle]:29 - User profile is opened
2016-11-21 18:31:28 : INFO  BaseTest  	-[TestEnd]:30 - Closing app
2016-11-21 18:31:28 : INFO  BaseTest  	-[TestEnd]:31 - *****************************************************************************
```
