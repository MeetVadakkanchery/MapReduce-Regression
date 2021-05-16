import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DemandReducer extends Reducer<Text, Text, Text, Text> {
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		int countPurchase = 0;
		int countActivity = 0;
		for(Text val:values){
			if (val.toString().equals("purchase")){
				countPurchase+=1; 
			}
			countActivity+=1;
		}
		context.write(new Text("1"), new Text("," + key.toString() + "," + Integer.toString(countActivity) + "," + Integer.toString(countPurchase)));
	}
}
