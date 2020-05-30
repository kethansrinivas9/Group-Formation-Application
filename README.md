# Group8

### Guidelines to follow while contributing to the project

## Coding Guidelines
1. In Java, all the names will be in Camel case
2. Classes and Interface names should be nouns
    ```
    Ex:
    interface  Bicycle
    class MountainBike implements Bicycle
    ``` 
3. Methods names should be verbs
    ```
    Ex:
    void changeGear(int newValue);
    void speedUp(int increment);
    void applyBrakes(int decrement);
    ```
4. Variable names should be short and meaningful
    ```
    Ex:
    int firstName;
    int lastName;
    ```
5. Static variables should be declared at the top of the    
   class with capital letters and words separated by an underscore('_')
   ```
    Ex:
    static final int MIN_WIDTH = 4;
   ```
6. Package names should be all-lowercase with letters and numbers
    ```
    Ex:
    com.sun.eng
    com.apple.quicktime.v2
    ```
7. Each method should have only one task to be done, precisely you should use the Single Responsibility Principle (SRP). This helps in testing the code efficiently.



## Git Guidelines
1. All the feature development should be done in the branches created from develop and should be merged back to develop
2. Feature branch name should start with the feature id and should contain a brief description with all-capital letters and an underscore separating the words 
```
    Ex:
    AS_1_SETUP_CONTINUOUS_INTEGRATION_IN_HEROKU
```
3. For each commit, the commit message should contain a brief explanation of what they have done and the new few lines will have an in-detail list of tasks done.
```
    Ex:
    Created Project Guidelines
    * Added coding guidelines for Java
    * Added guidelines to for the usage of Git
```
4. We may want to have each Pull request reviewed by at least 2 persons before merging to make sure their code follows all the rules we have defined.


