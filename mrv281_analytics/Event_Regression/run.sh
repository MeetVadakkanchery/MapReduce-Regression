rm -rf output
javac -classpath `yarn classpath` -d . src/EventRegressionMapper.java
javac -classpath `yarn classpath` -d . src/EventRegressionReducer.java
javac -classpath `yarn classpath`:. -d . src/EventRegression.java
jar -cvf eventRegressionData.jar *.class
hadoop jar eventRegressionData.jar EventRegression /user/mrv281/Project_Data/event_Covid.txt /user/mrv281/output
hadoop fs -get output
hdfs dfs -rm -r output
cat output/part-r-00000

