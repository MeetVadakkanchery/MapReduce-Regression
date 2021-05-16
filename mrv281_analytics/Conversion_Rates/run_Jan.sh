rm -rf output
javac -classpath `yarn classpath` -d . src/ConversionMapper.java
javac -classpath `yarn classpath` -d . src/ConversionReducer.java
javac -classpath `yarn classpath`:. -d . src/Conversion.java
jar -cvf conversionData.jar *.class
hadoop jar conversionData.jar Conversion /user/mrv281/Project_Data/Event_Data_Jan.txt /user/mrv281/output
hadoop fs -get output
hdfs dfs -rm -r output
cat output/part-r-00000
mv output/part-r-00000 output/Conversion_Data_Jan.txt
