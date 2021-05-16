import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.Arrays;
import java.util.ArrayList;

public class StockRegressionMapper
extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		ArrayList<String> line = new ArrayList(Arrays.asList(value.toString().split(",")));
		String[] date = line.get(0).split("-"); 
		String key_map = date[0]+"-"+date[1];
		long total = Long.parseLong(line.get(1))+Long.parseLong(line.get(2))+Long.parseLong(line.get(3));
		String val_map = Long.toString(total)+","+line.get(4);
		context.write(new Text(key_map), new Text(val_map));
	}
}
