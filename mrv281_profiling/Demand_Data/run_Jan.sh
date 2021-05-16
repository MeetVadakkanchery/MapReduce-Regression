rm -rf output
rm -rf output
javac -classpath `yarn classpath` -d . src/DemandMapper.java
javac -classpath `yarn classpath` -d . src/DemandReducer.java
javac -classpath `yarn classpath`:. -d . src/Demand.java
jar -cvf demandData.jar *.class
hadoop jar demandData.jar Demand /user/mrv281/Project_Data/Cleaned_Data_Jan.txt /user/mrv281/output
hadoop fs -get output
hdfs dfs -rm -r output
cat output/part-r-00000
mv output/part-r-00000 output/Demand_Data_Jan.txt
