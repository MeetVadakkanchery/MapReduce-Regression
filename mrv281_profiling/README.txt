Name: Meet Remesh Vadakkanchery
NetID: mrv281

Daily_Change (directory):
	Code Type: Profiling
	Description: Gives us statistics about daily activity for each of product_categories
	Input_File_1: Cleaned_Data_Apr.txt Located in /user/mrv281/Project_Data/Cleaned_Data_Apr.txt  <- in HDFS
	Instructions to Run: use ./run_Apr.sh - to produce product activity stats for April Data (uses Input_File_1)
	Output: Output present in /output directory
	Code: Code: Present in /src
	Use_Case: We use this in our analytic to understand daily activity patterns as Covid Cases increase

Demand_Data (directory):
	Code Type: Profiling
	Description: Gives us statistics about demands for each of product_categories in the given month
	Input_File_1: Cleaned_Data_Apr.txt Located in /user/mrv281/Project_Data/Cleaned_Data_Apr.txt  <- in HDFS
	Input_File_2: Cleaned_Data_Jan.txt Located in /user/mrv281/Project_Data/Cleaned_Data_Jan.txt  <- in HDFS
	Instructions to Run: use ./run_Apr.sh - to produce category demand stats for April Data (uses Input_File_1)
			     use ./run_Jan.sh - to produce category demand stats for Jan Data (uses Input_File_2)
	Output: Output present in /output directory
	Code: Code: Present in /src
	Use_Case: We use this to understand the most in demand products

Event_Data (directory):
	Code Type: Profiling
	Description: Gives us statistics about demands for each of product_categories in the given month
	Input_File_1: Cleaned_Data_Apr.txt Located in /user/mrv281/Project_Data/Cleaned_Data_Apr.txt  <- in HDFS
	Input_File_2: Cleaned_Data_Jan.txt Located in /user/mrv281/Project_Data/Cleaned_Data_Jan.txt  <- in HDFS
	Instructions to Run: use ./run_Apr.sh - to produce event activity stats for April Data (uses Input_File_1)
			     use ./run_Jan.sh - to produce event activity stats for Jan Data (uses Input_File_2)
	Output: Output present in /output directory
	Code: Code: Present in /src
	Use_Case: We use this to understand impact of COVID on user activity 

MR_1 (directory):
	Code Type: Profiling
	Description: Gives us line counts pre and post cleaning of data.
	Input_File_1: 2020-Apr.csv Located in /user/mrv281/Project_Data/2020-Apr.csv  <- in HDFS
	Input_File_2: 2020-Jan.csv Located in /user/mrv281/Project_Data/2020-Jan.csv  <- in HDFS
	Input_File_3: Cleaned_Data_Apr.txt Located in /user/mrv281/Project_Data/Cleaned_Data_Apr.txt  <- in HDFS
	Input_File_4: Cleaned_Data_Jan.txt Located in /user/mrv281/Project_Data/Cleaned_Data_Jan.txt  <- in HDFS
	Instructions to Run: use ./run_post_Apr.sh - to produce product line counts for raw April Data (uses Input_File_1)
			     use ./run_post_Jan.sh - to produce product line counts for raw Jan Data (uses Input_File_2)
			     use ./run_pre_Apr.sh - to produce product line counts for cleaned April Data (uses Input_File_3)
			     use ./run_pre_Jan.sh - to produce product line counts for cleaned Jan Data (uses Input_File_4)
	Output: Output present in /output directory
	Code: Code: Present in /src
	Use_Case: We use this to understand how many rows do we lose out on after cleaning 

Session_Data (directory):
	Code Type: Profiling
	Description: Gives us statistics about sessions held by each user in the given month
	Input_File_1: Cleaned_Data_Apr.txt Located in /user/mrv281/Project_Data/Cleaned_Data_Apr.txt  <- in HDFS
	Input_File_2: Cleaned_Data_Jan.txt Located in /user/mrv281/Project_Data/Cleaned_Data_Jan.txt  <- in HDFS
	Instructions to Run: use ./run_Apr.sh - to produce category demand stats for April Data (uses Input_File_1)
			     use ./run_Jan.sh - to produce category demand stats for Jan Data (uses Input_File_2)
	Output: Output present in /output directory
	Code: Code: Present in /src
	Use_Case: We use this to understand how many sessions do users typically hold in a given data/month