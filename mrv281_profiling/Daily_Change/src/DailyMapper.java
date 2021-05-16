import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.Arrays;
import java.util.ArrayList;

public class DailyMapper
extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		ArrayList<String> line = new ArrayList(Arrays.asList(value.toString().split(",")));
		line.remove(0);
		String key_map = line.get(1)+" "+line.get(4);
		context.write(new Text(key_map), new IntWritable(1));
	} 
}
