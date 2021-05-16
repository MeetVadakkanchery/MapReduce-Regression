import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.Arrays;
import java.util.ArrayList;

public class ProductRegressionMapper
extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		ArrayList<String> line = new ArrayList(Arrays.asList(value.toString().split(",")));
		for(int i = 0; i<line.size(); i++){
			line.set(i, line.get(i).replaceAll("\\s", ""));
		}
		String[] date = line.get(0).split("-");
		String key_map = date[0]+"-"+date[1]+","+line.get(3);
		String val_map = line.get(1)+","+line.get(4);
		context.write(new Text(key_map), new Text(val_map));	
	}
}
