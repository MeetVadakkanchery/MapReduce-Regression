import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.util.Arrays;
import java.util.ArrayList;

public class CleanMapper
extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		ArrayList<String> line = new ArrayList(Arrays.asList(value.toString().split(",")));
		String[] time = line.get(0).split("\\s+");
		if(line.size() == 9){
			boolean clean = true; 
			// Need to split column 4, so we have more categorization of products
			ArrayList<String> category_data = new ArrayList(Arrays.asList(line.remove(4).split("\\."))); 
			// Don't need column 3
			line.remove(3); 
			line.add(0, line.remove(5));
			// Adding Padding to make sure consistency for field names
			if (category_data.size() < 3 && category_data.size() != 0){
				int curr = category_data.size();
				if (category_data.get(curr-1).equals(" ")){
				    clean = false;
				}
				for(int i = curr; i<3; i++){
					category_data.add(1, "DNE");
				}
			}
			// If not category data, ignore the record
			if (category_data.size() == 0){ clean = false;};
			for(int i = category_data.size()-1; i>=0; i--){
				line.add(3, category_data.get(i));
			}
			String data = new String();
			if(time.length == 3){
				data = time[0] + ',' + time[1]+time[2];
			}else{ clean = false; }
			for(int i = 2; i<line.size(); i++){
			    if (line.get(i).equals("")) { clean = false; break;}
				data+=","+line.get(i).replaceAll(" ", "");
			}
			if(clean){ context.write(new Text(line.get(0)), new Text(","+line.get(0)+","+data)); }
		}
		
	} 
}
