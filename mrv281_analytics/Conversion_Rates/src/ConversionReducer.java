import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.DoubleWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.*;

public class ConversionReducer extends Reducer<LongWritable, Text, Text, Text> {
	@Override
	public void reduce(LongWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		Text value = values.iterator().next();
		ArrayList<String> line = new ArrayList(Arrays.asList(value.toString().split(",")));
		line.remove(0);
		long denom = Long.parseLong(line.get(2));
		long num = Long.parseLong(line.get(3))*100;
		context.write(new Text("1"), new Text(","+line.get(0)+","+Double.toString((num/denom))));
	}
}
