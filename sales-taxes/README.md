# Sales Taxes

## Summary
The idea of this test project is to calculate sales taxes in different products. 

## Architecture
The project has 2 sub-modules:
* cli. This module use the core module and expose the business logic. It's packaged using Appassembly in a zip file with the project dependencies and a Shell script executable file. 
* core. This module implements the sales taxes business logic. The core module is packaged as a jar that can be included from another project. In the core submodule you will find the following packages:
..* com.examples.apps.sales.core - The interface of core business logic is the SalesManager class, in that class you'll find the methods than external sub-modules or services can use to interact with the core module. This package also includes a ItemsFactory class in order to abstract the Items creation.
..* com.examples.apps.sales.core.models - Include the Item and Receipt models
..* com.examples.apps.sales.core.utils - Include the Utils class with a couple of support static methods to deal with numbers

Using this architecture integrate the sales taxes business logic in other project or module (like a RESTful resource) it's quite simple. Example:

``` java

Receipt receipt1= manager.createReceipt();

receipt1.addItem(manager.createItem("Book", 12.49, "BOOK", false))
	.addItem(manager.createItem("music CD", 14.99, "MUSIC", false))
	.addItem(manager.createItem("chocolate bar", 0.85, "FOOD", false));

receipt1.toString()
```
## Tests

The core project includes the Junit test cases of all different classes. The SalesManagerImplTest class includes the test cases that validate the different receipts (receipt1Test, receipt2Test, receipt3Test).

## Usage

Compile the application using maven:

``` bash
$ mvn clean install
[..]
[INFO] --- maven-assembly-plugin:2.2-beta-5:single (assemble) @ cli ---
[INFO] Building zip: /home/aitor/projects/personal/examples/sales-taxes/cli/target/sales-taxes-cli-bin.zip
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO] 
[INFO] Sales Taxes Example ............................... SUCCESS [0.921s]
[INFO] Example service Core library ...................... SUCCESS [5.827s]
[INFO] Command Line Interface ............................ SUCCESS [3.854s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 10.886s
[INFO] Finished at: Fri Jan 16 13:27:24 CET 2015
[INFO] Final Memory: 22M/167M
[INFO] ------------------------------------------------------------------------
$
```

In cli/target folder you will find the sales-taxes-cli-bin.zip with all cli and core modules packaged. You can unpackage that zip, and run the cli.sh file to run the software.

``` bash
aitor@portal:~/projects/personal/examples/sales-taxes (master)$ cd cli/target/
aitor@portal:~/projects/personal/examples/sales-taxes/cli/target (master)$ unzip sales-taxes-cli-bin.zip 
Archive:  sales-taxes-cli-bin.zip
   creating: repo/
   creating: repo/com/
   creating: repo/com/examples/
   creating: repo/com/examples/apps/
   creating: repo/com/examples/apps/cli/
   creating: repo/com/examples/apps/cli/0.0.1-SNAPSHOT/
   creating: repo/com/examples/apps/core/
   creating: repo/com/examples/apps/core/0.0.1-SNAPSHOT/
   creating: repo/log4j/
   creating: repo/log4j/log4j/
   creating: repo/log4j/log4j/1.2.17/
   creating: repo/commons-logging/
   creating: repo/commons-logging/commons-logging/
   creating: repo/commons-logging/commons-logging/1.2/
  inflating: repo/com/examples/apps/cli/0.0.1-SNAPSHOT/cli-0.0.1-SNAPSHOT.jar  
  inflating: repo/com/examples/apps/core/0.0.1-SNAPSHOT/core-0.0.1-SNAPSHOT.jar  
  inflating: repo/log4j/log4j/1.2.17/log4j-1.2.17.jar  
  inflating: repo/commons-logging/commons-logging/1.2/commons-logging-1.2.jar  
   creating: bin/
  inflating: bin/cli.sh.1183180371.formatted  
  inflating: bin/cli.sh              
  inflating: bin/cli.bat             
  inflating: bin/cli.bat.1014863666.formatted  
aitor@portal:~/projects/personal/examples/sales-taxes/cli/target (master)$ /bin/sh sales-taxes-cli^C  
aitor@portal:~/projects/personal/examples/sales-taxes/cli/target (master)$ /bin/sh bin/cli.sh
Initializing Sales Taxes app
Items: {
 [Book: price= 12.49, taxes= 0, total price= 12.49]
 [music CD: price= 14.99, taxes= 1.5, total price= 16.49]
 [chocolate bar: price= 0.85, taxes= 0, total price= 0.85]
} - Sales Taxes: 1.5 - Total: 29.83

Items: {
 [Imported Box of chocolates: price= 10, taxes= 0.5, total price= 10.5]
 [Imported Bottle of perfume: price= 47.5, taxes= 7.15, total price= 54.65]
} - Sales Taxes: 7.65 - Total: 65.15

Items: {
 [Imported Bottle of perfume: price= 27.99, taxes= 4.2, total price= 32.19]
 [Bottle of perfume: price= 18.99, taxes= 1.9, total price= 20.89]
 [Headache pills: price= 9.75, taxes= 0, total price= 9.75]
 [Imported Box of chocolates: price= 11.25, taxes= 0.6, total price= 11.85]
} - Sales Taxes: 6.7 - Total: 74.68

aitor@portal:~/projects/personal/examples/sales-taxes/cli/target (master)$ 
```

## Cobertura

You can run cobertura plugin to check the core module code coverage.

## Technologies
The project has been coded using Java 7 and Maven (Cobertura, Junit, Appassembly)

## ToDo
If time permits i would like to face a few details:
* Orchestrate the application using spring and put the taxes and goods categories in a properties file
* Create in a new project submodule a HTTP RESTful resource to expose the sales taxes business logic using any Java Microservice implementation (with Netflix API for example)
* A deployment script using Docker
* Add a Jmeter performance test


