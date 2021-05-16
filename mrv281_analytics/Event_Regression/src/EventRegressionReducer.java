import java.io.IOException;
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.lang.Math;

public class EventRegressionReducer extends Reducer<Text, Text, Text, Text> {
	class LinearRegression{
		long sum_x = 0;
		long sum_x_sq = 0;
		long sum_x_y = 0;
		long sum_y = 0;
		long sum_1 = 0;
		double [][] A = new double[2][2];
		double [] b = new double[2];
		public LinearRegression(long sum_x, long sum_x_sq, long sum_x_y, long sum_y, long sum_1){
			this.sum_x = sum_x;
			this.sum_y = sum_y;
			this.sum_x_y = sum_x_y;
			this.sum_y = sum_y;
			this.sum_1 = sum_1;
			A[0][0] = sum_x_sq;
			A[0][1] = sum_x;
			A[1][0] = sum_x;
			A[1][1] = sum_1;
			b[0] = sum_x_y;
			b[1] = sum_y;
		}

		public double[] getCoefficients(){
			double[][] A_inv = this.computeInverse();
			double a = A_inv[0][0]*this.b[0] + A_inv[0][1]*this.b[1];
			double b = A_inv[1][0]*this.b[0] + A_inv[1][1]*this.b[1];
			return new double[]{a, b};
		}

		public double[][] computeInverse(){
			double[][] A_inv  = new double[2][2];
			double det = this.determinant();
			A_inv[0][0] = this.A[1][1]*det;
			A_inv[0][1] = -this.A[0][1]*det;
			A_inv[1][0] = -this.A[1][0]*det;
			A_inv[1][1] = this.A[0][0]*det;
			return A_inv;
		}

		public double determinant(){
			return 1/((A[0][0]*A[1][1])-(A[0][1]*A[1][0]));
		}

		public double getPrediction(double x){
			double [] coefs = this.getCoefficients();
			return x*coefs[0]+coefs[1];
		}
	}
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		long sum_x = 0;
		long sum_x_sq = 0;
		long sum_y = 0;
		long sum_x_y = 0;
		long sum_1 = 0;
		long sum_y_sq = 0;

		for(Text val:values){
			String[] data = val.toString().split(",");
			long y = Long.parseLong(data[1]);
			long x = (long)Double.parseDouble(data[0]);
			sum_x += x;
			sum_x_sq += (x*x);
			sum_y_sq += (y*y);
			sum_y += y;
			sum_x_y += (x*y);
			sum_1 += 1;
		}
		LinearRegression reg = new LinearRegression(sum_x, sum_x_sq, sum_x_y, sum_y, sum_1);
		context.write(new Text("Stats"), new Text(","+Long.toString(sum_x)+","+Long.toString(sum_x_sq)+","+Long.toString(sum_x_y)+","+Long.toString(sum_y)+","+Long.toString(sum_1)+","+Long.toString(sum_y_sq)));
		double[] coeffs = reg.getCoefficients();
		context.write(new Text("Regression Model"), new Text(","+Double.toString(coeffs[0])+","+Double.toString(coeffs[1])));
		double initial = 2000000;
		while(initial < 3000000){
			double result = reg.getPrediction(initial);
			context.write(new Text(Double.toString(initial)), new Text(Long.toString((long)result)));
			initial*=1.05;
			initial = Math.floor(initial);
		}
		
	}
}
