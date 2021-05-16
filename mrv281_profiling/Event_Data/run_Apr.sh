rm -rf output
javac -classpath `yarn classpath` -d . src/EventMapper.java
javac -classpath `yarn classpath` -d . src/EventReducer.java
javac -classpath `yarn classpath`:. -d . src/Event.java
jar -cvf eventData.jar *.class
hadoop jar eventData.jar Event /user/mrv281/Project_Data/Cleaned_Data_Apr.txt /user/mrv281/output
hadoop fs -get output
hdfs dfs -rm -r output
cat output/part-r-00000
mv output/part-r-00000 output/Event_Data_Apr.txt
