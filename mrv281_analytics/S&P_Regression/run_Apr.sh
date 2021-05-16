rm -rf output
javac -classpath `yarn classpath` -d . src/StockRegressionMapper.java
javac -classpath `yarn classpath` -d . src/StockRegressionReducer.java
javac -classpath `yarn classpath`:. -d . src/StockRegression.java
jar -cvf stockRegressionData.jar *.class
hadoop jar stockRegressionData.jar StockRegression /user/mrv281/Project_Data/event_Stock_Apr.txt /user/mrv281/output
hadoop fs -get output
hdfs dfs -rm -r output
cat output/part-r-00000

