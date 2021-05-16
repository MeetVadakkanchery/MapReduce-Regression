rm -rf output
rm -rf output
javac -classpath `yarn classpath` -d . src/DailyMapper.java
javac -classpath `yarn classpath` -d . src/DailyReducer.java
javac -classpath `yarn classpath`:. -d . src/Daily.java
jar -cvf dailyData.jar *.class
hadoop jar dailyData.jar Daily /user/mrv281/Project_Data/Cleaned_Data_Apr.txt /user/mrv281/output
hadoop fs -get output
hdfs dfs -rm -r output
cat output/part-r-00000
mv output/part-r-00000 output/Daily_Data_Apr.txt
