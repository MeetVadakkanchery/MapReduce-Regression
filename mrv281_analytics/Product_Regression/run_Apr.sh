rm -rf output
javac -classpath `yarn classpath` -d . src/ProductRegressionMapper.java
javac -classpath `yarn classpath` -d . src/ProductRegressionReducer.java
javac -classpath `yarn classpath`:. -d . src/ProductRegression.java
jar -cvf productRegressionData.jar *.class
hadoop jar productRegressionData.jar ProductRegression /user/mrv281/Project_Data/product_Covid.txt /user/mrv281/output
hadoop fs -get output
hdfs dfs -rm -r output
cat output/part-r-00000

