# GSV-Test-Automation #

This is a small automation framework based on Selenide.
The test case scenarios are made for openweathermap.org UI & API testing.

### Tools used ###

* Java 1.8
* Maven
* Selenide
* TestNG
* Rest-assured

### Setup for first time ###

* git clone
* git pull
* mvn clean install

### How to use? ###

###### Groups

* **all** - runs all test cases.
* **ui** - runs test cases which are related to UI testing.
* **api** - runs all test cases which are related to API testing.

###### Startup command (cmd)

```
mvn clean test -Denv=*environment_name* -Dgroups=*group_name*
```
Example:
```
mvn clean test -Denv=dev -Dgroups=all
```

Or it can be run it straight from IDE
