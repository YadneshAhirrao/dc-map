 import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CountryRankMapper extends Mapper<LongWritable, Text, Text, Text> {

  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

    // Skip the header line
    if (key.get() == 0) {
      return;
    }

    String line = value.toString();
    String rank = line.split(",")[0]; // Assuming rank is in the first column
    String country = line.split(",")[2]; // Assuming country is in the third column

    if ("5".equals(rank)) {
      context.write(new Text("Rank 5 Country"), new Text(country));
    }
  }
}

