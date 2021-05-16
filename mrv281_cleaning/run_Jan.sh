rm -rf output
javac -classpath `yarn classpath` -d . src/CleanMapper.java
javac -classpath `yarn classpath` -d . src/CleanReducer.java
javac -classpath `yarn classpath`:. -d . src/Clean.java
jar -cvf cleanRecs.jar *.class
hadoop jar cleanRecs.jar Clean /user/mrv281/Project_Data/2020-Jan.csv /user/mrv281/output
hadoop fs -get output
hdfs dfs -rm -r output
mv output/part-r-00000 output/Cleaned_Data_Jan.txt
