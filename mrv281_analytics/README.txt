Name: Meet Remesh Vadakkanchery
NetID: mrv281

Conversion_Rates (directory):
	Code Type: Analytic
	Description: Finds out the conversion rates (between non-purchase activity and purchase activity). 
	Uses Linear_Regression.java, that is an inner class used to run linear regression and help and 
	predict outcomes based on new COVID cases observed
	Input_File_1: Event_Data_Apr.txt. Located in /user/mrv281/Project_Data/Event_Data_Apr.txt  <- in HDFS
	Input_File_2: Event_Data_Jan.txt. Located in /user/mrv281/Project_Data/Event_Data_Jan.txt <- in HDFS
	Instructions to Run: use ./run_Apr.sh - to find conversion rates for April Data (uses Input_File_1)
		             use ./run_Jan.sh - to find conversion rates for Jan Data (uses Input_File_2)
	Output: Output present in /output directory under Conversion_Rates
	Code: Present in /src

Event_Regression (directory):
	Code Type: Analytic
	Description: Finds out delta in user e-commerce activity based on new COVID cases observed. 
	Uses Linear_Regression.java, that is an inner class used to run linear regression and help and 
	predict outcomes based on new COVID cases observed.
	Input_File_1: event_Covid.txt Located in /user/mrv281/Project_Data/event_Covid.txt  <- in HDFS
	Instructions to Run: use ./run.sh - to find results for April Data (uses Input_File_1)
	Output: Output present in /output directory under Event_Regression
	Code: Present in /src


Product_Regression (directory):
	Code Type: Analytic
	Description: Finds out changes in purchase patterns for each product category based
	on new COVID cases observed, also gives out the exact delta for each category.  Uses Linear_Regression.java,
	that is an inner class used to run linear regression and help and predict outcomes based on new COVID cases observed
	Input_File_1: product_Covid.txt Located in /user/mrv281/Project_Data/product_Covid.txt  <- in HDFS
	Instructions to Run: use ./run_Apr.sh - to find results for April Data (uses Input_File_1)
	Output: Output present in /output directory under Product_Regression
	Code: Present in /src


S&P_Regression (directory):
	Code Type: Analytic
	Description: Finds out impact of daily change in the Stock market indices on e-commerce activity.  Uses Linear_Regression.java,
	that is an inner class used to run linear regression and help and predict outcomes based on new S&P index data observed
	Input_File_1: event_Stock_Apr.txt Located in /user/mrv281/Project_Data/event_Stock_Apr.txt  <- in HDFS
	Input_File_2: event_Stock_Jan.txt Located in /user/mrv281/Project_Data/event_Stock_Jan.txt  <- in HDFS
	Instructions to Run: use ./run_Apr.sh - to find results for April Data (uses Input_File_1)
			     use ./run_Jan.sh - to find results for Jan Data (uses Input_File_2)
	Output: Output present in /output directory under Product_Regression
	Code: Present in /src
