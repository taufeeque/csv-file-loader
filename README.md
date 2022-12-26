# csv-file-loader
This is a java maven project to parse and read csv files from path to a folder consisting csv files getting as a command line argument
We have implemented as concurrent execution.

To Use this simply glone this project into your intellij,eclispe(Any IDE).
Do Run install and package.

Go in Target folder.

Use below command to run the jar file

		cmd:  java -jar takeHomeTest-0.0.1-SNAPSHOT-exec.jar  <local path of the directory containing all csv files>
			e.g.- java -jar takeHomeTest-0.0.1-SNAPSHOT-exec.jar /Users/mdtaufeequealam/Downloads/SampleData
      
   sample output will look likw below:

Total revenue for each website:	
3612: INR 502930346
3611: INR 501464022
3610: INR 496560990
……..
…….
…….
4940: INR 466823829
4941: INR 480434718
4942: INR 509543409
4943: INR 505026538
3619: INR 490473205
3618: INR 499875130
Total revenue across  all website:  INR4998665839088
Total revenue for each advertiserId:
Network18: INR 556092099534
GAM: INR 555736936550
GCP: INR 555128853451
Media.Net: INR 554951609780
AdMedia: INR 555493405336
Criteo: INR 556004138490
AUM: INR 554699178322
JUW: INR 555137220047
AP: INR 555422397578
total time taken to calculate revenue from all csv files: 6722 ms
