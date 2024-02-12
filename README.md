# MaxPopulation Hadoop MapReduce Application
### Overview
This repository contains a Java-based Hadoop MapReduce application for finding the country with the maximum population based on data provided.

### Usage
To use this application, follow these steps:

1. Ensure you have Hadoop installed and configured.
2. Compile the Java files using javac.
3. Package the compiled classes into a JAR file.
4. Run the JAR file using Hadoop with appropriate input and output paths.

### Input Data
The input data should be in CSV format, where each row represents information about a country. The application expects the following columns:

1. **Country Code:** Unique identifier for each country.
2. **Country Name:** Name of the country.
3. **Population 2020:** Population count for the year 2020.

### Execution

1. Go to Directory and Compile all the java file  `MaxPopulation.java` ,  `MaxPopulationMapper.java` and `MaxPopulationReducer.java` using Haddop jar files
   ```bash
   javac -classpath $HADOOP_INSTALL/share/hadoop/common/hadoop-common-3.3.6.jar:$HADOOP_INSTALL/share/hadoop/mapreduce/hadoop-mapreduce-client-core-3.3.6.jar MaxPopulation*.java
   ```

2. Combine all compiled file into single jar file called  `MaxPopulation.jar`
   ```bash
   jar -cvf MaxPopulation.jar MaxPopulation*.class
   ```

3. Execute the MapReduce job
   ```bash
   hadoop jar MaxPopulation.jar MaxPopulation <input_path> <output_path>
   ```

4. to get Output
  ```bash
  cat output/*
  ```

### Mapper
The MaxPopulationMapper class extracts the country name and its corresponding population count from each line of the input CSV file. It emits a key-value pair, where the country name is the key and the population count is the value.

### Reducer
The `MaxPopulationReducer` class receives key-value pairs from the mapper, where keys are country names and values are population counts. It calculates the total population for each country and keeps track of the country with the maximum population.

### Output
The output of the MapReduce job is written to the specified output path. It contains a single line indicating the country with the maximum population, along with the population count.
