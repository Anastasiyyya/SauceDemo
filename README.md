   LoginPage:
1) Login with empty fields
2) Login with empty Username
3) Login with empty Password
4) Login with incorrect  Username and Password
   ProductsPage:
5) Check for "ADD TO CART" button presence on the page
6) Check for "REMOVE" button presence on the page
   CartPage:
7) Check product price on the page
8) Check remove from the cart button
9) Check the number of items in the cart


**_mvn versions:display-dependency-updates_**

[INFO] artifact org.testng:testng: checking for updates from central
[INFO] artifact org.seleniumhq.selenium:selenium-java: checking for updates from central
[INFO] artifact org.seleniumhq.selenium:selenium-chrome-driver: checking for updates from central
[INFO] artifact org.seleniumhq.selenium:selenium-api: checking for updates from central
[INFO] artifact io.github.bonigarcia:webdrivermanager: checking for updates from central
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-api ........ 3.141.59 -> 4.0.0-beta-3
[INFO]   org.seleniumhq.selenium:selenium-chrome-driver ...
[INFO]                                                 3.141.59 -> 4.0.0-beta-3
[INFO]   org.seleniumhq.selenium:selenium-java ....... 3.141.59 -> 4.0.0-beta-3
[INFO]   org.testng:testng ..................................... 7.1.0 -> 7.4.0

_**mvn clean test**_

[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 56.365 s - in TestSuite
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  01:00 min
[INFO] Finished at: 2021-06-05T08:01:31+03:00
[INFO] ------------------------------------------------------------------------

**_mvn -Dtest=CartTest#addProductToCartTest+checkProductPriceTest test_**

[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 10.042 s - in tests.CartTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  12.886 s
[INFO] Finished at: 2021-06-05T08:05:08+03:00
[INFO] ------------------------------------------------------------------------

**_mvn -Dtest=CartTest#checkProductPriceTest -DuserName=standard_user -Dpassword=secret_sauce
test_**

[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 6.743 s - in tests.CartTest
[INFO]
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  9.562 s
[INFO] Finished at: 2021-06-05T08:15:28+03:00
[INFO] ------------------------------------------------------------------------
