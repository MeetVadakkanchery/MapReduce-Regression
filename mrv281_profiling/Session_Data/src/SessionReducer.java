import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.util.HashSet;

public class SessionReducer extends Reducer<Text, Text, Text, Text> {
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		HashSet<String> userSession =  new HashSet<>();
		for(Text val:values){
			userSession.add(val.toString());
		}
		context.write(key, new Text(',' + key.toString() + ',' + Integer.toString(userSession.size())));
	}
}
