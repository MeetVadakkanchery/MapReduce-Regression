Name: Meet Remesh Vadakkanchery
NetID: mrv281

Map_Reduce_2:
	Code Type: Data Cleaning
	Description: Cleans data that we will be using for analysis and insights, it removes rows that do not
	match our criteria based on what we want to analyse. It additionally removes 2 columns that we believe
	is not useful to us. It also splits a column product_description into 3 columns, (1) product_category,
	(2) product_subcategory, (3) product_name. This makes it easy for us to understand each product activity
	that we deal with
	Input_File_1: 2020-Apr.csv Located in /user/mrv281/Project_Data/2020-Apr.csv  <- in HDFS
	Input_File_1: 2020-Jan.csv Located in /user/mrv281/Project_Data/2020-Jan.csv <- in HDFS
	Instructions to Run: use ./run_Apr.sh - to produce cleaned data for April Data (uses Input_File_1)
			     use ./run_Jan.sh - to produce cleaned data for Jan Data (uses Input_File_2)
	Output: Output present in /output directory
	Code: 	Code: Present in /src

