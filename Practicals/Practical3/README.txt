===============
Practical 3
===============

Initially only MatrixInterface.java MatrixService.java MatrixPublisher.java MatrixUtility.java and MatrixClient.java
should be present in the directory. The jaxws (JAX Web Service) and CMatrix (Helper Classes) are generated later using
the 'wsgen' and 'wsimport' utilities.

1. Compile everything (MatrixInterface.java MatrixService.java MatrixPublisher.java MatrixUtility.java) EXCEPT MatrixClient.java.

2. Generate helper classes at service side to manage complex data types using wsgen utility.
	> wsgen -cp . -keep Practicals.Practical3.MatrixService
   This will generate a 'jaxws' directory.

3. > java Practicals.Practical3.MatrixPublisher

4. Generate helper classes at client side to manage complex data types using wsimport utility.
	> wsimport -p Practicals.Practical3.CMatrix -keep http://localhost:8883/matrix?wsdl
	This will generate a 'CMatrix' directory.

5. Now compile and run MatrixClient.java.