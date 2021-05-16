rm -rf output
javac -classpath `yarn classpath` -d . src/CountRecsMapper.java
javac -classpath `yarn classpath` -d . src/CountRecsReducer.java
javac -classpath `yarn classpath`:. -d . src/CountRecs.java
jar -cvf countRecs.jar *.class
hadoop jar countRecs.jar CountRecs /user/mrv281/Project_Data/Cleaned_Data_Apr.txt /user/mrv281/output
hadoop fs -get output
hdfs dfs -rm -r output
cat output/part-r-00000
