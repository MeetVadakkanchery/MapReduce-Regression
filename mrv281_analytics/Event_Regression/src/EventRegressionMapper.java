import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.Arrays;
import java.util.ArrayList;

public class EventRegressionMapper
extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		ArrayList<String> line = new ArrayList(Arrays.asList(value.toString().split(",")));
		String[] date = line.get(0).split("-"); 
		String keyDate = date[0]+"-"+date[1];
		String cases = line.get(1);
		long totalActivity = 0;
		for(int i = 2; i<line.size(); i++){
			totalActivity+=(long)Double.parseDouble(line.get(i));
		}
		context.write(new Text(keyDate), new Text(cases+","+Long.toString(totalActivity)));
	}
}
