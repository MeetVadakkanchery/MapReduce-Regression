import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EventReducer extends Reducer<Text, Text, Text, Text> {
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		int countPurchase = 0;
		int countCart = 0;
		int countViews = 0;
		for(Text val:values){
			if(val.toString().equals("view")){ countViews++; }
			if(val.toString().equals("cart")){ countCart++; }
			if(val.toString().equals("purchase")) { countPurchase++; }
		}
		context.write(new Text("1"), new Text("," + key.toString() + "," + Integer.toString(countViews) + "," + Integer.toString(countCart) + "," + Integer.toString(countPurchase)));
	}
}
