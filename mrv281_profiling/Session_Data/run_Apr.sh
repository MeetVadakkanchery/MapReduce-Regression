rm -rf output
javac -classpath `yarn classpath` -d . src/SessionMapper.java
javac -classpath `yarn classpath` -d . src/SessionReducer.java
javac -classpath `yarn classpath`:. -d . src/Session.java
jar -cvf sessionData.jar *.class
hadoop jar sessionData.jar Session /user/mrv281/Project_Data/Cleaned_Data_Apr.txt /user/mrv281/output
hadoop fs -get output
hdfs dfs -rm -r output
mv output/part-r-00000 output/Session_Data_Apr.txt
