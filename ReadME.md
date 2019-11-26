## Test demo task

### Description
1. Basic Selenium tests. 

*Note: there was issues with web app, like 502 error, changes of DOM (looks application is keep on updating), so due to development time limitation
 for POC added Thread.sleep(). Also stage version has CAPTCHA enabled, so Login tests will fails.*

2. Small API test. Implemented faster approach, to check expected and actual responses, also due to POC-demo time limitation

### Running
1. install java >= 8
2. install maven
3. `mvn test`


